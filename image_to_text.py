import os
import tempfile
import requests
from flask import Flask, request, jsonify
import pytesseract
from PIL import Image

app = Flask(__name__)

# 允许的图像文件类型
ALLOWED_EXTENSIONS = {'png', 'jpg', 'jpeg'}

# 检查文件类型是否被允许
def allowed_file(filename):
    return '.' in filename and \
           filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS

# 图像文本识别的函数
def recognize_text(img):
    text = pytesseract.image_to_string(img, lang='eng')
    return text.strip()

# 处理上传的图像文件
def handle_uploaded_file(file):
    # 将上传的文件保存到临时目录中
    _, file_extension = os.path.splitext(file.filename)
    with tempfile.NamedTemporaryFile(suffix=file_extension) as tmp:
        file.save(tmp.name)
        img = Image.open(tmp.name)
        # 进行图像文本识别
        text = recognize_text(img)
    return text

# 处理从URL获取的图像文件
def handle_url_image(url):
    # 下载图像文件到本地临时文件
    with tempfile.NamedTemporaryFile(delete=False) as tmp:
        response = requests.get(url, stream=True)
        for chunk in response.iter_content(chunk_size=1024):
            tmp.write(chunk)
        img = Image.open(tmp.name)
        # 进行图像文本识别
        text = recognize_text(img)
    os.unlink(tmp.name)
    return text

# API端点
@app.route('/recognize-text', methods=['POST'])
def recognize_text_api():
    # 检查请求是否包含图像文件或URL
    if 'file' not in request.files and 'url' not in request.form:
        return jsonify({'error': 'No file or URL provided.'}), 400

    # 如果请求包含文件，则处理文件
    if 'file' in request.files:
        file = request.files['file']
        if file.filename == '':
            return jsonify({'error': 'No file selected.'}), 400
        if not allowed_file(file.filename):
            return jsonify({'error': 'Unsupported file type.'}), 400
        # 进行图像文本识别
        text = handle_uploaded_file(file)
        return jsonify({'text': text})

    # 如果请求包含URL，则处理URL
    if 'url' in request.form:
        url = request.form['url']
        # 进行图像文本识别
        text = handle_url_image(url)
        return jsonify({'text': text})

# 启动服务器
if __name__ == '__main__':
    app.run(debug=True, port=5000)

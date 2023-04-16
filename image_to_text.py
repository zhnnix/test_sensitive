import pytesseract
from PIL import Image

def recognize_text(filename):
    # 打开图片
    img = Image.open(filename)

    # 识别图片中的文本
    text = pytesseract.image_to_string(img, lang='eng')

    # 返回识别出来的文本
    return text.strip()

# 测试
print(recognize_text('example.png'))

import java.util.HashMap;
import java.util.Map;

public class VulnerabilityDatabase {
    private Map<String, Vulnerability> vulnerabilities;

    public VulnerabilityDatabase() {
        vulnerabilities = new HashMap<>();
    }

    // 新增漏洞
    public void addVulnerability(Vulnerability vulnerability) {
        vulnerabilities.put(vulnerability.getId(), vulnerability);
        System.out.println("漏洞已成功添加到数据库。");
    }

    // 查询漏洞
    public Vulnerability getVulnerability(String vulnerabilityId) {
        return vulnerabilities.get(vulnerabilityId);
    }

    // 修改漏洞
    public void updateVulnerability(Vulnerability vulnerability) {
        if (vulnerabilities.containsKey(vulnerability.getId())) {
            vulnerabilities.put(vulnerability.getId(), vulnerability);
            System.out.println("漏洞已成功更新。");
        } else {
            System.out.println("指定的漏洞不存在。");
        }
    }

    public static void main(String[] args) {
        // 创建漏洞数据库实例
        VulnerabilityDatabase database = new VulnerabilityDatabase();

        // 创建漏洞对象
        Vulnerability vuln1 = new Vulnerability("CVE-2023-1234", "漏洞描述1");
        Vulnerability vuln2 = new Vulnerability("CVE-2023-5678", "漏洞描述2");

        // 新增漏洞
        database.addVulnerability(vuln1);
        database.addVulnerability(vuln2);

        // 查询漏洞
        Vulnerability queriedVulnerability = database.getVulnerability("CVE-2023-1234");
        if (queriedVulnerability != null) {
            System.out.println("查询到的漏洞描述：" + queriedVulnerability.getDescription());
        } else {
            System.out.println("未找到指定的漏洞。");
        }

        // 修改漏洞
        Vulnerability updatedVulnerability = new Vulnerability("CVE-2023-1234", "更新后的漏洞描述");
        database.updateVulnerability(updatedVulnerability);

        // 再次查询漏洞
        queriedVulnerability = database.getVulnerability("CVE-2023-1234");
        if (queriedVulnerability != null) {
            System.out.println("更新后的漏洞描述：" + queriedVulnerability.getDescription());
        } else {
            System.out.println("未找到指定的漏洞。");
        }
    }
}

class Vulnerability {
    private String id;
    private String description;

    public Vulnerability(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}

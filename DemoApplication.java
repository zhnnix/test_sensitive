package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
@RestController
public class DemoApplication {
    @RequestMapping("/")
    public String hello() {
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    private void sensitiveInfoTest() {

        String password = "tt_z0d1284fj_pwd";

        String new_password
                = "aIYATjBPlUhYU/9gLpQFuPnIfGB/sz5ZTFu5gvtnS6lkSz9oBTTtDDwkHqjIKhNZfR7hOMvwSVq5iwZcP6TSCFVCqm";

        String old_password = "Fu5gvtmnS09WlDoJrx2yNnVLDVm4peAU6C0BK6";

        String carrier = "Asia/Singapore";

        final String JIAMI_HUANHANG_Token = EncryptUtils.decrypt(
                "nE/9ZEToI5jHQdhuzU7OzgPOTPnsE9v78+byIlhTc4HPQ2dmGEoYBhoDTCqhfa0TltQ9Nq/"
                        + "p2JOz8NH+fany6gSI3cQnYgnwkp4uX7NikJowaNZE7GwzTBem1F1wCOs6wwrJvJFlyN906HJyvSFYx/"
                        + "aIYATjBPlUhYU/9gLpQFuPnIfGB/sz5ZTFu5gvtnS0MkSz9oBTTtDDwkHqjIKhNZfR7hOMvwScq5iwZcP6TSCFVCqm"
                        + "i7JwiKPdHO7YmaFRAIF1wCOs6wwrJvJFlyN906Hx3RlHdZFSOvf1FRujB1Sdl4FVnYIIBpUzUysM1xxbu"
                        + "3KfbIYDQ2W5j+ax6TgvdhuzU7OzgPOTPnsE9v78+byIlhTcCVkvuqumFMrY1TArDu9u/uprdfPqizTD/7alkp4uX7NikJowaNZ69E"
                        + "LdWKMgrXa9TIkVU72pJGikJowaNZE7GwzTBru+dvIfGB/sz5ZTFu5gvtnS09WlDJrx2yNnVLDVm4peAUC0BK6H"
                        + "ae2pXouPLFeB/uprdfPqizTD/7alkp4uX7J2fu87PW3NWQ==");

        //        String new_password = {"header":{"alg":"RS256","jwk":{"kty":"RSA","n":"7ixeydcbxxppzxrBphrW1atUiEZqTpiHDpI-79olav5XxAgWolHmVsJyxzoZXRxmtED8PF9-EICZWBGdSAL9ZTD0hLUCIsPcpdgT_LqNW3Sh2b2caPL2hbMF7vsXvnCGg0asdVnvJOPuYTyRrCLUF9vM7ES-V3VCYTa7LcCSRm56Gg9r1995ioqZ9kIKBBxpgt723v2cC4bmLmoAX2s217ou3uCpCXGLOeV_BesG4--Nl3pso1VhCfO85wEWjmW6lbv7Kg4d7Jdkv5DjDZfJ086fkEAYZVYGRpIgAvJBH3d3yKDCrSByUEud1bWuFjQBmMaeYOrVDXO_mbYg5PwUDMhw","e":"AQAB"}},"protected":"eyJub25jZSI6IjhISWVwVU56IjghLWV4S1RyWFZmNGcifQ","payload":"eyJjb250YWN0PldasGAmZaWx0bzpmb29AYmFyLmNvbSJdfQ","signature":"AyvVGMgXsQ1zTdXrZxE_gyO63pQgotL1KbI7gv6Wi8I7NRy0iAOkDAkWcTQT9pcCYApJ04lXfEDZfP5i0XgcFUm_6spxi5mFBZU-NemKcvK9dUiAbXvb4hB3GnaZtZiuVnMQUb_ku4DOaFFKbteA6gOYCnED_x7v0kAPHIYrQnvIa-KZ6pTajbV9348zgh9TL7NgGIIsTcMHd-Jatr4z1LQ0ubGa8tS300hoDhVzfoDQaEetYjCo1drR1RmdEN1SIzXdHOHfubjA3ZZRbrF_AlLmKpRRoIwzu1VayOhRmdy1qVSQZq_tENF4VrQFycEL7DhG7JLoXC4T2p1urwMlsw"};

        String region = "-north";

        //    	URL records OpenTSDB HTTP API urls without the OpenTSDB host endpoint.
        //    	URL records OpenTSDB BASE64 API urls without the OpenTSDB host endpoint.
    }
    
    
    public static String getSHA256(String str) throws NoSuchAlgorithmException {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] encodedHash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
    StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
    for (byte b : encodedHash) {
        String hex = String.format("%02x", b);
        hexString.append(hex);
    }
    return hexString.toString();
}

}

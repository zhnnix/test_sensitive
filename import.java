package com.example.demo;

import com.example.config.TestConfig;
import com.example.util.PasswordKeyUtil;

import static com.example.config.TestConfig.ENTROPY_PASSWORD;
import static com.example.config.TestConfig.ENTROPY_TOKEN;

public class import_test {

    private final static String APPROVER_NAME = PasswordKeyUtil.decryptData(
            "d2NjX2NyeXB0ATQxNDU1MzVGNDM0MjQzOzQxNDIPjkzdMjMyNDUzNTM1NDQ0MjQ0NDUzNDQ1MzE0NTM3MzU0MMLM4NDIzNTM1MzUzOTM4NDY7OzM1MzAzMDMwMzA7Q0Y5MzAyNDg1MjY2ODY0RTA1NTQwRDk4QTJCQzY2NTg7RlMOtFDrekVENTZGQzdCRTs");


    private final static String T2 = PasswordKeyUtil.decryptData(ENTROPY_TOKEN);

    String entropyPassword = ENTROPY_PASSWORD;

    String password = TestConfig.PASSWORD;
    
    String fb_t = "EAAYLJvFkfAYBAIvLX7nj1tnIOCTMx45zwMoEYBBZCWv8IqGIE1zuJbSDrr6kdowyZB8KdFedJknnpZCNmFi9zmDpnsU4NssqBwr1fXU6AcpkGq2bGpJSbBMAAHQbe8iqSnMmwnBoT0GAZC8LxNK6AvdHDhJkVHk8KzhGo1w1oAZDZD";

}

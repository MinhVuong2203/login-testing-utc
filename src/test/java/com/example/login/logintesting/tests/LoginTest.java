package com.example.login.logintesting.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.login.logintesting.base.BaseTest;
import com.example.login.logintesting.pages.LoginPage;

public class LoginTest extends BaseTest {

    // TC_LOGIN_01
    // Đăng nhập với thông tin hợp lệ
    @Test
    public void TC_LOGIN_01_validLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "huongnt",
                "123456@utc2"
        );

        Assertions.assertNotEquals(
                "https://vanphongdientu.utc.edu.vn/Login",
                loginPage.getCurrentUrl()
        );
    }


    // TC_LOGIN_02
    // Username đúng, password sai
    @Test
    public void TC_LOGIN_02_correctUsernameWrongPassword() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "huongnt",
                "123456_sai"
        );

        Assertions.assertEquals(
                "https://vanphongdientu.utc.edu.vn/Login",
                loginPage.getCurrentUrl()
        );
    }


}
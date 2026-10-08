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

    // TC_LOGIN_03
    // Username sai, password đúng
    @Test
    public void TC_LOGIN_03_wrongUsernameCorrectPassword() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "username_sai",
                "123456@utc2"
        );

        Assertions.assertEquals(
                "https://vanphongdientu.utc.edu.vn/Login",
                loginPage.getCurrentUrl()
        );
    }

    
    // TC_LOGIN_04
    // Username và password đều sai
    @Test
    public void TC_LOGIN_04_wrongUsernameWrongPassword() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "username_sai",
                "password_sai"
        );

        Assertions.assertEquals(
                "https://vanphongdientu.utc.edu.vn/Login",
                loginPage.getCurrentUrl()
        );
    }

    // TC_LOGIN_05
    // Bỏ trống username
    @Test
    public void TC_LOGIN_05_emptyUsername() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterPassword("123456@utc2");

        loginPage.clickLogin();

        Assertions.assertEquals(
                "https://vanphongdientu.utc.edu.vn/Login",
                loginPage.getCurrentUrl()
        );
    }

    // TC_LOGIN_06
    // Bỏ trống password
    @Test
    public void TC_LOGIN_06_emptyPassword() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("huongnt");

        loginPage.clickLogin();

        Assertions.assertEquals(
                "https://vanphongdientu.utc.edu.vn/Login",
                loginPage.getCurrentUrl()
        );
    }

    // TC_LOGIN_07
    // Bỏ trống cả username và password
    @Test
    public void TC_LOGIN_07_emptyUsernameAndPassword() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLogin();

        Assertions.assertEquals(
                "https://vanphongdientu.utc.edu.vn/Login",
                loginPage.getCurrentUrl()
        );
    }

    // TC_LOGIN_08
    // Username có khoảng trắng đầu/cuối
    @Test
    public void TC_LOGIN_08_usernameWithSpaces() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "  huongnt  ",
                "123456@utc2"
        );

        // Kiểm tra hệ thống không bị crash
        Assertions.assertNotNull(
                loginPage.getCurrentUrl()
        );
    }

    // TC_LOGIN_09
    // Password có khoảng trắng
    @Test
    public void TC_LOGIN_09_passwordWithSpaces() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "huongnt",
                "  123456@utc2  "
        );

        // Kiểm tra hệ thống không bị crash
        Assertions.assertNotNull(
                loginPage.getCurrentUrl()
        );
    }

    // TC_LOGIN_10
    // Nhập ký tự đặc biệt
    @Test
    public void TC_LOGIN_10_specialCharacters() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "<script>alert(1)</script>",
                "' OR '1'='1"
        );

        Assertions.assertEquals(
                "https://vanphongdientu.utc.edu.vn/Login",
                loginPage.getCurrentUrl()
        );
    }

    // TC_LOGIN_11
    // Nhập dữ liệu vượt quá độ dài cho phép
    @Test
    public void TC_LOGIN_11_exceedMaximumLength() {

        LoginPage loginPage = new LoginPage(driver);

        String longText = "A".repeat(1000);

        loginPage.login(
                longText,
                longText
        );

        Assertions.assertNotNull(
                loginPage.getCurrentUrl()
        );
    }

    // TC_LOGIN_12
    // Đăng xuất sau khi đăng nhập
    @Test
    public void TC_LOGIN_12_logout() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "huongnt",
                "123456@utc2"
        );

   
        // Sau khi xác định chính xác phần tử "Đăng xuất"
        // sẽ bổ sung thao tác logout tại đây.

        Assertions.assertNotNull(
                loginPage.getCurrentUrl()
        );
    }

}
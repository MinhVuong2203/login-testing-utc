package com.example.login.logintesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By usernameInput = By.name("username");

    private By passwordInput = By.name("userpwd");

    private By loginButton =
            By.cssSelector("input.submit_login");

    private By persistentCheckbox =
            By.id("persistent");

    private By loginForm =
            By.cssSelector("form[action='/Login']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public boolean isLoginFormDisplayed() {
        return driver.findElement(loginForm).isDisplayed();
    }

    public boolean isPersistentCheckboxDisplayed() {
        return driver.findElement(persistentCheckbox).isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }
}
package com.tryCloud.pages;

import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.ConfigurationReader;
import com.tryCloud.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    @FindBy(xpath = "//input[@id='user']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[@id='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id='lost-password']")
    public WebElement linkForgotPassword;

    @FindBy(xpath = "//p[contains(@class, 'wrongPasswordMsg')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//input[@id='reset-password-submit']")
    public WebElement resetPasswordButton;

    @FindBy(xpath = "//input[@required]")
    public List<WebElement> requiredField;

    private static String message;


    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login() {
        usernameInput.sendKeys(ConfigurationReader.getProperty("username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void login(String submitType) {
        if (submitType.equals("submitButton")) {
            usernameInput.sendKeys(ConfigurationReader.getProperty("username"));
            passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
            loginButton.click();
        } else if (submitType.equals("enterKey")) {
            usernameInput.sendKeys(ConfigurationReader.getProperty("username"));
            passwordInput.sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);
        }
    }

    public void login(String username, String password, String submitType) {

            if (submitType.equals("submitButton")) {
                usernameInput.sendKeys(username);
                passwordInput.sendKeys(password);
                loginButton.click();
                BrowserUtils.waitFor(2);

            }
            if (submitType.equals("enterKey")) {
                usernameInput.sendKeys(username);
                passwordInput.sendKeys(password + Keys.ENTER);
                BrowserUtils.waitFor(2);
            }

            if (usernameInput.getText().isEmpty() && passwordInput.getText().isEmpty()) {
                String message1 = usernameInput.getAttribute("validationMessage");
                String message2 = passwordInput.getAttribute("validationMessage");
                if (message1.isEmpty()) {
                    message = message2;
                } else {
                    message = message1;
                }

            }


    }




    

}

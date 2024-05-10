package com.tryCloud.step_definitions;

import com.tryCloud.pages.LoginPage;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.ConfigurationReader;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class US001_Login_StepDef {

    // scenario1: Valid login
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        // this is handled by the hooks class
    }

    @When("I log in with {string}")
    public void i_log_in_with(String string) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(string);
    }

    @Then("I should see the url contains {string}")
    public void i_should_see_the_url_contains(String string) {
        System.out.println(Driver.getDriver().getCurrentUrl());
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(string));
    }

    // scenario2: Invalid login with wrong username or password
    @When("I log in with {string} and {string} using {string}")
    public void i_log_in_with_and_using(String string, String string2, String string3) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(string, string2, string3);
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String string) {
        LoginPage loginPage = new LoginPage();
        String actualMessage = loginPage.errorMessage.getText();
        Assert.assertEquals(string, actualMessage);
    }

    // Scenario3: Invalid login with empty username or password
    @Then("I should see the alert {string}")
    public void i_should_see_the_alert(String string) {
        LoginPage loginPage = new LoginPage();
        for (WebElement element : loginPage.requiredField) {
            String actualMessage = element.getAttribute("validationMessage");
            Assert.assertEquals(string, actualMessage);
        }
    }

    // scenario4: password visibility
    @When("I enter a password")
    public void i_enter_a_password() {
        LoginPage loginPage = new LoginPage();
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @Then("I should see the password as dots")
    public void i_should_see_the_password_as_dots() {
        LoginPage loginPage = new LoginPage();
        String actualPassword = loginPage.passwordInput.getAttribute("type"); // where the type of the input is password
        Assert.assertEquals("password", actualPassword);
    }


    // scenario5: Forgot password
    @Then("I should see the forgot password link")
    public void i_should_see_the_forgot_password_link() {
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.linkForgotPassword.isDisplayed());
    }

    @When("I click the forgot password link")
    public void i_click_the_forgot_password_link() {
        LoginPage loginPage = new LoginPage();
        loginPage.linkForgotPassword.click();
    }

    @Then("I should see the {string} button")
    public void i_should_see_the_button(String string) {
        LoginPage loginPage = new LoginPage();
        BrowserUtils.waitForVisibility(loginPage.resetPasswordButton, 10);
        Assert.assertTrue(new LoginPage().resetPasswordButton.isDisplayed());
        Assert.assertEquals(string, new LoginPage().resetPasswordButton.getAttribute("value"));
    }


}

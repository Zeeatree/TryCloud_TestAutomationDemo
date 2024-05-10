package com.tryCloud.step_definitions;

import com.tryCloud.pages.DashboardPage;
import com.tryCloud.pages.LoginPage;
import com.tryCloud.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class US002_Dashboard_StepDef {

    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();

    // scenario1: User should be able to see the modules
    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        loginPage.login();
    }

    @Then("the user should be able to see below modules")
    public void the_user_should_be_able_to_see_below_modules(List<String> expectedModules) {

        BrowserUtils.waitFor(3);
        List<String> actualModules = new ArrayList<>();
        for (WebElement module : dashboardPage.modules) {
            actualModules.add(module.getAttribute("aria-label"));
        }
        System.out.println("actualModules = " + actualModules);
        Assert.assertEquals(expectedModules, actualModules);

    }

    // scenario2: User should be able to see the search box
    @When("the user enters {string} into the search box")
    public void the_user_enters_into_the_search_box(String string) {
        BrowserUtils.waitForVisibility(dashboardPage.searchBox, 5);
        dashboardPage.searchBox.sendKeys(string);
    }

    @Then("the user should see search results related to {string}")
    public void the_user_should_see_search_results_related_to(String string) {
        BrowserUtils.waitFor(3);
        List<String> actualResults = dashboardPage.searchResults.stream().map(WebElement::getText).collect(Collectors.toList());
        System.out.println("actualResults = " + actualResults);
        for (String actualResult : actualResults) {
            String fileName = actualResult.split("\n")[0]; // get the first word which is the filename
            System.out.println("fileName = " + fileName);
            System.out.println(string);
            Assert.assertTrue(fileName.contains(string));
            break;
        }
    }

    // scenario3: User should be able to see the notifications
    @Then("the user should be able to see their notifications")
    public void the_user_should_be_able_to_see_their_notifications() {

        BrowserUtils.waitForVisibility(dashboardPage.notificationsIcon, 5);
        dashboardPage.notificationsIcon.click();
        BrowserUtils.waitFor(3);
        Assert.assertTrue(dashboardPage.Notifications.isDisplayed());

    }

    // scenario4: User should be able to see the user icon
    @When("the user clicks on the user icon")
    public void the_user_clicks_on_the_user_icon() {
        BrowserUtils.waitForVisibility(dashboardPage.userIcon, 5);
        dashboardPage.userIcon.click();
    }

    @Then("the user should be able to see their profile and settings")
    public void the_user_should_be_able_to_see_their_profile_and_settings() {
        BrowserUtils.waitFor(3);
        for (WebElement element : dashboardPage.userOptions) {
            System.out.println("element = " + element.getText());
            Assert.assertTrue(element.isDisplayed());
        }
    }

    // scenario5: User should be able to see the contacts menu
    @Then("the user should be able to see their contact menu")
    public void the_user_should_be_able_to_see_their_contact_menu() {
        BrowserUtils.waitForVisibility(dashboardPage.contactsIcon, 5);
        dashboardPage.contactsIcon.click();
        BrowserUtils.waitFor(3);
        Assert.assertTrue(dashboardPage.ContactsMenu.isDisplayed());
    }


}

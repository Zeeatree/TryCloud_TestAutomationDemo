package com.tryCloud.step_definitions;

import com.tryCloud.pages.UserProfilePage;
import com.tryCloud.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US003_UserProfile_StepDef {

    UserProfilePage userProfilePage = new UserProfilePage();

    @Given("the user clicks the user icon")
    public void the_user_clicks_the_user_icon() {
        userProfilePage.userIcon.click();
    }
    @Given("the user clicks settings label")
    public void the_user_clicks_settings_label() {
        BrowserUtils.waitFor(3);
        userProfilePage.linkSettings.click();
    }

    // scenario1: User should be able to see the modules
    @Then("the user should see following labels")
    public void the_user_should_see_following_labels(List<String> expectedModules) {
        List<String> actualModules = BrowserUtils.getElementsText(userProfilePage.labels);
        System.out.println("actualModules = " + actualModules);
        for (String expectedModule : expectedModules) {
            Assert.assertTrue(actualModules.contains(expectedModule));
        }
    }


    // scenario2: User should be able to change the name
    @Given("the user enters the name {string}")
    public void the_user_enters_the_name(String string) {
        userProfilePage.inputDisplayName.clear();
        userProfilePage.inputDisplayName.sendKeys(string);
    }
    @Then("the user should be able to see the {string} as the name")
    public void the_user_should_be_able_to_see_the_as_the_name(String string) {
        String actualName = userProfilePage.inputDisplayName.getAttribute("value");
        Assert.assertEquals(string, actualName);
    }


    // scenario3: User should be able to set the phone number as private
    @Given("the user clicks the phone icon-triangle")
    public void the_user_clicks_the_phone_icon_triangle() {
        userProfilePage.phoneTriangleIcon.click();
    }
    @Given("the user clicks the private label")
    public void the_user_clicks_the_private_label() {
        BrowserUtils.waitForVisibility(userProfilePage.privateLabel, 5);
        userProfilePage.privateLabel.click();
        BrowserUtils.waitFor(2);
    }
    @Then("the user should see the private is selected")
    public void the_user_should_see_the_private_is_selected() {
        String actualPrivacy = userProfilePage.phoneNumberPrivacy.getAttribute("value");
        Assert.assertEquals("private", actualPrivacy);
    }


    // scenario4: User should be able to see the local time
    @Then("the user should see the localtime in page")
    public void the_user_should_see_the_localtime_in_page() {
        BrowserUtils.scrollToElement(userProfilePage.localeExample);
        BrowserUtils.waitFor(2);
        Assert.assertTrue(userProfilePage.localeExample.isDisplayed());
    }


    // scenario5: User should be able to upload a new profile picture
    @When("the user clicks on the upload profile picture button")
    public void the_user_clicks_on_the_upload_profile_picture_button() {
        userProfilePage.uploadNew.click();
        BrowserUtils.waitFor(2);
    }
    @When("the user uploads a new picture")
    public void the_user_uploads_a_new_picture() {
        userProfilePage.uploadNew.sendKeys("src/test/resources/behance.jpg");
        BrowserUtils.waitFor(2);
    }
    @Then("the user should see the new picture as the profile picture")
    public void the_user_should_see_the_new_picture_as_the_profile_picture() {
        String actualPicture = userProfilePage.uploadNew.getAttribute("value");
        Assert.assertTrue(actualPicture.contains("behance.jpg"));
    }


    // scenario6: User should be able to select a new language
    @When("the user selects a new language from the language dropdown")
    public void the_user_selects_a_new_language_from_the_language_dropdown() {
        BrowserUtils.waitFor(2);
        userProfilePage.languageDropdown.click();
        BrowserUtils.waitFor(2);
        Select select = new Select(userProfilePage.languageDropdown);
        select.selectByVisibleText("English (US)");
    }
    @Then("the user should see the application in the new language")
    public void the_user_should_see_the_application_in_the_new_language() {
        String actualLanguage = userProfilePage.languageDropdown.getAttribute("value");
        Assert.assertEquals("en", actualLanguage);
    }

    // scenario7: User should be able to delete the account
    @When("the user clicks on the delete account button")
    public void the_user_clicks_on_the_delete_account_button() {
        BrowserUtils.scrollToElement(userProfilePage.requestDeletionButton);
        userProfilePage.requestDeletionButton.click();
    }
    @Then("the user should see the change of text to {string}")
    public void the_User_Should_See_The_Change_Of_Text_To(String string) {
        BrowserUtils.waitFor(2);
        String actualText = userProfilePage.requestDeletionButton.getText();
        Assert.assertEquals(string, actualText);
    }
}

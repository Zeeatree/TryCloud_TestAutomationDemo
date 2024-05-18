package com.tryCloud.step_definitions;

import com.tryCloud.pages.FileUploadDeletePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US004_Files_StepDef {

    FileUploadDeletePage fileUploadDeletePage = new FileUploadDeletePage();

    // scenario1: User is able to upload files
    @Given("the user navigate to {string}")
    public void the_user_navigate_to(String string) {
        fileUploadDeletePage.navigateTo(string);
    }

    @When("the user upload {string}")
    public void the_user_upload(String fileName) {
        fileUploadDeletePage.uploadFile(fileName);
    }

    @Then("the user should see {string} on page")
    public void the_user_should_see_on_page(String string) {
        fileUploadDeletePage.isUploadedOrCreated(string);
    }

    @Then("the user delete any selected {string}")
    public void the_user_delete_any_selected(String string) {
        fileUploadDeletePage.deleteItem(string);
    }

    @Then("the user should see {string} in deleted files")
    public void the_user_should_see_in_deleted_files(String string) {
        fileUploadDeletePage.isInDeletedFiles(string);
    }

    // scenario2: User is able to create a folder
    @When("the user create new folder {string}")
    public void the_user_create_new_folder(String string) {
        fileUploadDeletePage.createFolder(string);
    }

    @Then("the user should see new {string} on page")
    public void the_user_should_see_new_on_page(String string) {
        fileUploadDeletePage.isUploadedOrCreated(string);
    }

    // scenario3: User can move any files to any folders
    @When("the user move the {string} to {string}")
    public void the_user_move_the_to(String string, String string2) {
        fileUploadDeletePage.moveTo(string, string2);
    }

    @Then("the user should see moved {string} in {string}")
    public void the_user_should_see_moved_in(String string, String string2) {
        fileUploadDeletePage.isInFolder(string, string2);
    }

    // scenario4: User can copy any files to any folders
    @When("the user copy the {string} to {string}")
    public void the_user_copy_the_to(String string, String string2) {
        fileUploadDeletePage.copyTo(string, string2);
    }

    @Then("the user should see copied {string} in {string} and FileList")
    public void the_user_should_see_copied_in(String string, String string2) {
        fileUploadDeletePage.isInFolder(string, string2);
    }

    //
    @Then("the user should see total number of files and folders")
    public void the_User_Should_See_Total_Number_Of_Files_And_Folders() {

        int fileNum = fileUploadDeletePage.getDisplayedFileNumber();
        int folderNum = fileUploadDeletePage.getDisplayedFolderNumber();

        System.out.println("fileNum = " + fileNum);
        System.out.println("folderNum = " + folderNum);

        Assert.assertEquals(fileNum, fileUploadDeletePage.countFile());
        Assert.assertEquals(folderNum, fileUploadDeletePage.countFolder());
    }


}

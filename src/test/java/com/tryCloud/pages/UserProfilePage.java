package com.tryCloud.pages;

import com.tryCloud.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserProfilePage extends DashboardPage{

    @FindBy(xpath = "//h3/label")
    public List<WebElement> labels;

    @FindBy(xpath = "//*[@id='displayname']")
    public WebElement inputDisplayName;

    @FindBy(xpath = "//h2[@class='oc-dialog-title']")
    public WebElement authenticationRequired;

    @FindBy(xpath = "//*[@id = 'oc-dialog-1-content-input']")
    public WebElement inputPassword;

    @FindBy(xpath = "(//span[@class= 'icon-triangle-s'])[4]")
    public WebElement phoneTriangleIcon;

    @FindBy(xpath = "//a[@data-action='private']")
    public WebElement privateLabel;

    @FindBy(xpath="//input[@id='phonescope']")
    public WebElement phoneNumberPrivacy;

    @FindBy(xpath = "//*[@id='localeexample']")
    public WebElement localeExample;

    @FindBy(xpath = "//*[@id='uploadavatarbutton']")
    public WebElement uploadNew;

    @FindBy(xpath = "//*[@id='languageinput']")
    public WebElement languageDropdown;

    @FindBy(xpath = "//*[@id='data-request-deletion']")
    public WebElement requestDeletionButton;



    

    


    










}

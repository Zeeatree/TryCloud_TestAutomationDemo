package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@id='appmenu']/li[position() <= 7]/a")
    public List<WebElement> modules;

    @FindBy(xpath = "//*[@id='searchbox']")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@id = 'fileList']/tr")
    public List<WebElement> searchResults;

    @FindBy(xpath = "//div[@aria-controls='notification-container']")
    public WebElement notificationsIcon;

    @FindBy(xpath = "//div[@class='icon icon-notifications-dark']")
    public WebElement Notifications;

    @FindBy(xpath = "//*[@id='expand']")
    public WebElement userIcon;

    @FindBy(xpath = "//*[@id=\"expanddiv\"]/ul/li")
    public List<WebElement> userOptions;

    @FindBy(xpath = "//div[@class='icon-contacts menutoggle']")
    public WebElement contactsIcon;

    @FindBy(xpath = "//*[@id='contactsmenu-menu']")
    public WebElement ContactsMenu;

    @FindBy(xpath = "//li[@data-id='settings']")
    public WebElement linkSettings;

}

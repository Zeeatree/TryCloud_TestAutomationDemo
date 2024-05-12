package com.tryCloud.pages;

import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private WebDriverWait wait;

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void navigateTo(String module){
        module=module.toLowerCase();
        String locator="//ul[@id='appmenu']/li[@data-id='"+module+"']";
        WebElement moduleTab=Driver.getDriver().findElement(By.xpath(locator));
        BrowserUtils.waitForClickablility(moduleTab,10);
        moduleTab.click();
    }
}

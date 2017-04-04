package com.chudilka1.pages.quc;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class NewPaidPage extends AbstractPage {
    private String url;

    //LOCATORS
    //Order ID
    private By orderIDLocator = By.id("order-info");
    //Assign Writer
    private By assignWriterButton = By.id("set-assign-writer");


    public NewPaidPage(WebDriver driver) {
        super(driver);
    }

    public NewPaidPage(String url, WebDriver driver) {
        super(driver);
        this.url = url;
    }

    public NewPaidPage open(){
        driver.get(url);
        return this;
    }

    public NewPaidPage checkPage(String pageTitle) {
        if (isAuthorizationPage()) {
            authorize();
        }
        webDriverUtils.waitForExpectedCondition(ExpectedConditions.textToBePresentInElementLocated(orderIDLocator, pageTitle));
        Assert.assertTrue(driver.getTitle().contains(pageTitle) &&
                driver.findElement(orderIDLocator).getAttribute("title").contains("new_paid"));
        return this;
    }

    public NewPaidPage openAssignWriterDialog() {
        click(assignWriterButton);
        return this;
    }
}

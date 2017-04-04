package com.chudilka1.pages.quc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class OrdersAdminPage extends AbstractPage {
    private String url;
    private By searchFormLocator = By.id("search-order-form");

    //Order ID
    private By orderIDfield = By.xpath("//*[@id='search-order-form']/table/tbody/tr[1]/td[2]/input");

    //Order status
    private By orderStatusMenu = By.xpath("//*[@id='search-order-form']/table/tbody/tr[11]/td[2]/select");
    private By findButton = By.id("search-order");

    //Results table
    private By resultsTable = By.cssSelector(".td-padding.default-table>tbody>tr"); //table at least with one row
    private By statusInTableLocator = By.xpath("//*[@id='page-wrapper']/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[1]"); //1st row
    private By orderIDinTableLocator = By.xpath("//*[@id='page-wrapper']/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[2]/a"); //1st row


    public OrdersAdminPage(String url, WebDriver driver) {
        super(driver);
        this.url = url;
    }

    public OrdersAdminPage open() {
        driver.get(url);
        return this;
    }

    public OrdersAdminPage checkPage(String pageTitle) {
        if (isAuthorizationPage()) {
            authorize();
        }
        webDriverUtils.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(searchFormLocator));
        Assert.assertTrue(driver.getTitle().contains(pageTitle));
        return this;
    }

    public OrdersAdminPage typerOrderID(String orderID){
        typeText(orderIDfield, orderID);
        return this;
    }

    public OrdersAdminPage selectStatus(String status) {
        status = status.trim().replaceAll("\\s+","");
        Select select = new Select(driver.findElement(orderStatusMenu));
        List<WebElement> menu = select.getOptions();
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getText().trim().equals(status)) {
                menu.get(i).click();
                break;
            }
        }
        return this;
    }

    public OrdersAdminPage searchOrders(){
        click(findButton);
        webDriverUtils.waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(resultsTable));
        return this;
    }

    //Checks order status or order ID
    public OrdersAdminPage checkSearchResult(String expectedResult){
        Assert.assertTrue(getTextFromElement(statusInTableLocator).equals(expectedResult)||
                driver.findElement(orderIDinTableLocator).getAttribute("order-id").trim().equals(expectedResult));
        return this;
    }
}

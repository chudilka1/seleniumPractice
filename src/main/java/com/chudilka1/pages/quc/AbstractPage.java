package com.chudilka1.pages.quc;

import com.chudilka1.util.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AbstractPage {
    protected WebDriver driver;
    protected WebDriverUtils webDriverUtils;

    //Authorization on 'Fish' page
    private String login = "aleksandr.yepishev";
    private String pass = "Alex_2011_";
    private By loginLocator = By.id("username");
    private By passLocator = By.id("password");
    private By loginButtonLocator = By.id("regularsubmit");

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        webDriverUtils = new WebDriverUtils(this.driver);
    }

    public boolean isAuthorizationPage () {
        return driver.getTitle().contains("Authenticate");
    }

    public void authorize() {
        typeText(loginLocator, login);
        typeText(passLocator, pass);
        click(loginButtonLocator);
    }

    public void typeText(By elementId, String text) {
        WebElement textBox = driver.findElement(elementId);
        textBox.clear();
        textBox.sendKeys(text);
    }

    public void click(By elementId) {
        WebElement button = driver.findElement(elementId);
        button.click();
    }

    public String getTextFromElement(By elementId){
        WebElement element = driver.findElement(elementId);
        return element.getText().trim();
    }
}

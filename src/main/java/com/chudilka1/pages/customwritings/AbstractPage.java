package com.chudilka1.pages.customwritings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.navigate().to(url);
    }

    public void typeText(String elementId, String text) {
        WebElement textBox = driver.findElement(By.id(elementId));
        textBox.clear();
        textBox.sendKeys(text);
    }

    public void click(String elementId) {
        WebElement button = driver.findElement(By.id(elementId));
        button.click();
    }
}

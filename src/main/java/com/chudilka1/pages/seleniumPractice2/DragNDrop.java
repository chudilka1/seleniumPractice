package com.chudilka1.pages.seleniumPractice2;


import com.chudilka1.util.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragNDrop {
    private WebDriver driver;
    private WebDriverUtils webDriverUtils;
    private Actions builder;
    private String url;

    public DragNDrop(String url, WebDriver driver) {
        this.driver = driver;
        webDriverUtils = new WebDriverUtils(this.driver);
        builder = new Actions(this.driver);
        this.url = url;
    }

    public DragNDrop open() {
        driver.get(url);
        return this;
    }

    public DragNDrop switchToFrame(){
        driver.switchTo().frame(1);
        return this;
    }

    public DragNDrop dragImage(){
        WebElement From = driver.findElement(By.xpath(".//*[@id='treebox1']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));

        WebElement To = driver.findElement(By.xpath(".//*[@id='treebox2']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
        builder.clickAndHold(From).moveToElement(To).release(To).build().perform();
        //Assert.assertEquals();
        return this;
    }
}

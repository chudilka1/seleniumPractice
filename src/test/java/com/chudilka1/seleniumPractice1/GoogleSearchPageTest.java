package com.chudilka1.seleniumPractice1;

import com.chudilka1.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GoogleSearchPageTest extends WebDriverTestBase{

    @Test
    public void searchTest() {
        driver.get("https://www.google.com.ua");
        WebElement searchField = driver.findElement(By.name("q"));
        //Send text into input field
        searchField.sendKeys("Selenium");
        searchField.submit();
        //Finds first link with specified result
        WebElement seleniumLink = driver.findElement(By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/h3/a"));
        //Verifies a result
        assertEquals(seleniumLink.getText().contains("Selenium"), true);
    }
}

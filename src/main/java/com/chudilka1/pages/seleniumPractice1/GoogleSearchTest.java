package com.chudilka1.pages.seleniumPractice1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class GoogleSearchTest {
    WebDriver driver;

    //preconditions
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "D:\\Dropbox\\Documents\\Books\\QA\\QA_automation\\GitHub\\javacore\\src\\geckodriver.exe");
        //initialize a browser
        driver = new FirefoxDriver();
        //maximizes a window size
        driver.manage().window().maximize();
        //opens URL
        driver.get("https://www.google.com.ua");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void searchTest(){
        //find an element by name
        WebElement searchField = driver.findElement(By.name("q"));
        //Send text into input field
        searchField.sendKeys("Selenium");
        searchField.submit();
        //Finds first element with specified result
        //Finds first link with specified result
        WebElement seleniumLink = driver.findElement(By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/h3/a"));
        //Verifies a result
        assertEquals(seleniumLink.getText().contains("Selenium"), true);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

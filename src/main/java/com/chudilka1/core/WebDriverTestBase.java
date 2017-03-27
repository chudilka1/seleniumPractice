package com.chudilka1.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class WebDriverTestBase {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        //System.setProperty("webdriver.gecko.driver", "D:\\Dropbox\\Documents\\Books\\QA\\QA_automation\\GitHub\\javacore\\src\\geckodriver.exe");
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "D:\\Dropbox\\Documents\\Books\\QA\\QA_automation\\GitHub\\seleniumPractice\\src\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        //driver.close(); //closes tab
        driver.quit(); //closes browser
    }

}

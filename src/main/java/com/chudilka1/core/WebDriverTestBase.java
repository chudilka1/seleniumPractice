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
        //System.setProperty("webdriver.gecko.driver", WebDriverTestBase.class.getClassLoader().getResource("geckodriver.exe").getPath());
        //System.setProperty("webdriver.chrome.driver", WebDriverTestBase.class.getClassLoader().getResource("chromedriver.exe").getPath());
        System.setProperty("webdriver.chrome.driver", WebDriverTestBase.class.getClassLoader().getResource("chromedriver").getPath());
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        //driver.manage().deleteAllCookies();
        //driver.close(); //closes tab
        //driver.quit(); //closes browser
    }

}

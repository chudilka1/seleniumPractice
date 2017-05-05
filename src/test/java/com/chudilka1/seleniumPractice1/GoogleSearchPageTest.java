package com.chudilka1.seleniumPractice1;

import com.chudilka1.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class GoogleSearchPageTest extends WebDriverTestBase{

    //to run Grid locally
    //register hub, console: java -jar selenium-server-standalone-3.4.0.jar -role hub
    //register nodes, console: java -Dwebdriver.chrome.driver=chromedriver.exe -Dwebdriver.gecko.driver=geckodriver.exe -jar selenium-server-standalone-3.4.0.jar -role node -nodeConfig nodeConfig.json
    @Parameters({"platform", "browser"})
    @BeforeTest(alwaysRun = true)
    public void setup(String platform, String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        if (platform.equalsIgnoreCase("Windows")) {
            caps.setBrowserName(browser);
        }
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
    }

    @Test(description = "Google Search Test")
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

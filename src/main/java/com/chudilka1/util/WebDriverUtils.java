package com.chudilka1.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
    private static final String EXPLICIT_WAIT = "webdriver.explicit.wait";
    WebDriverWait wait;

    public WebDriverUtils(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Long.valueOf(getProperty(EXPLICIT_WAIT)));
    }

    private String getProperty(String key) {
        return PropertiesCache.getInstance().getProperty(key);
    }

    public void waitForExpectedCondition(ExpectedCondition expectedCondition) {
        wait.until(expectedCondition);
    }
}

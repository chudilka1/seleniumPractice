package com.chudilka1.pages.seleniumPractice1;

import com.chudilka1.util.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
    protected WebDriver driver;
    protected WebDriverUtils webDriverUtils;

    @FindBy(how = How.NAME, using = "q")
    private WebElement searchField;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        webDriverUtils = new WebDriverUtils(this.driver);
        PageFactory.initElements(driver, this);
    }

    public void sendSearchData(String search) {
        searchField.sendKeys(search);
        searchField.submit();
    }
}

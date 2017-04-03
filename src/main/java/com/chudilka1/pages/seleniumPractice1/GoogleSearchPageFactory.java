package com.chudilka1.pages.seleniumPractice1;

import org.openqa.selenium.WebDriver;

public class GoogleSearchPageFactory extends AbstractPage {

    public GoogleSearchPageFactory (WebDriver driver) {
        super(driver);
    }

    public void searchFor(String text) {
        sendSearchData(text);
    }
}

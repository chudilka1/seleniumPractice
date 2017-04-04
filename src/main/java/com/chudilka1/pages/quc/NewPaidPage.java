package com.chudilka1.pages.quc;

import org.openqa.selenium.WebDriver;

public class NewPaidPage extends AbstractPage {
    private String url;


    public NewPaidPage(String url, WebDriver driver) {
        super(driver);
        this.url = url;
    }
}

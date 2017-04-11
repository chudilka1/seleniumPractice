package com.chudilka1.seleniumPractice1;

import com.chudilka1.core.WebDriverTestBase;
import com.chudilka1.pages.seleniumPractice1.GoogleResultPage;
import org.testng.annotations.Test;


public class GoogleResultPageTest extends WebDriverTestBase {
    private String url = "https://www.google.com.ua";
    private String searchData = "Selenium";

    @Test
    public void findLink(){
        GoogleResultPage page = new GoogleResultPage(driver);
        driver.get(url);
        page.sendSearchData(searchData);
        page.findLink();
    }
}

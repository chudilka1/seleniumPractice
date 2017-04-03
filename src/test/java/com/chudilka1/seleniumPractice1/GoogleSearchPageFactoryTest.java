package com.chudilka1.seleniumPractice1;


import com.chudilka1.core.WebDriverTestBase;
import com.chudilka1.pages.seleniumPractice1.GoogleSearchPageFactory;
import org.testng.annotations.Test;

public class GoogleSearchPageFactoryTest extends WebDriverTestBase {
    private String url = "https://www.google.com.ua";
    private String searchData = "Вася";

    @Test
    public void searchText(){
        GoogleSearchPageFactory page = new GoogleSearchPageFactory(driver);
        driver.get(url);
        page.searchFor(searchData);

    }
}

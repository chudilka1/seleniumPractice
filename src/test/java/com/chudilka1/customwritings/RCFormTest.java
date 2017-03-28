package com.chudilka1.customwritings;

import com.chudilka1.core.WebDriverTestBase;
import com.chudilka1.pages.customwritings.RCForm;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import org.testng.Assert;

public class RCFormTest extends WebDriverTestBase {
    //Paper details
    By university34Locator = By.cssSelector(".radio-button.radio-button--n-3");
    By academicLevelSideWindowLocator = By.xpath("//*[@id='root']/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]");
    By researchPaperLocator = By.cssSelector("#react-select-3--option-2");
    By typeOfPaperSideWindowLocator = By.xpath("//*[@id='root']/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]");
    By englishLiterature = By.cssSelector("#react-select-4--option-1");
    By disciplineSideWindowLocator = By.xpath("//*[@id='root']/div/div/div[2]/div/div/div/div[2]/div[2]/div[3]");
    By topicSideWindowLocator = By.cssSelector(".OrderformCheckoutInfo__order-topic");
    By uploadedFileLocator = By.cssSelector(".FormFile");
    By apaFormatLocator = By.xpath(".//*[@id='root']/div/div/div[1]/div[3]/div/div[1]/div[2]/div[7]/div[2]/div/div/div/div[1]/div[2]/button");

    //Price calculation
    By deadline5DaysLocator = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[5]/button");
    By estimateDeadlineDateLocator = By.cssSelector(".DeadlineControl__estimated-deadline__date");
    By pagesSideWindowLocator = By.cssSelector(".OrderformCheckoutInfo__invoice__item__heading");

    //Account
    By emailLocator = By.name("email");
    By passwordLocator = By.name("password");
    By forgotPasswordLocator = By.cssSelector(".Auth__link");
    By succesfullSignInLocator = By.cssSelector(".rc-message.success.plate");

    @Test
    public void submitOrderForm() {
        RCForm rcForm = new RCForm("https://customwritings.com/order.html",driver);
        rcForm.open();
        Assert.assertEquals(driver.getTitle(), "Order now | Custom Written Essays, Term Papers, Research Papers, Thesis Papers, Dissertation and more");
        rcForm.chooseAcademicLevel(university34Locator);
        Assert.assertEquals(driver.findElement(academicLevelSideWindowLocator).getText().trim(), "Undergrad. (yrs 3-4)");
        rcForm.chooseTypeOfPaper(researchPaperLocator);
        Assert.assertEquals(driver.findElement(typeOfPaperSideWindowLocator).getText().trim(), "Research paper");
        rcForm.chooseNonCADiscipline(englishLiterature);
        Assert.assertEquals(driver.findElement(disciplineSideWindowLocator).getText().trim(), "Classic English Literature");
        rcForm.typeTopic("TESTING ORDER!!!");
        Assert.assertEquals(driver.findElement(topicSideWindowLocator).getText().trim(), "TESTING ORDER!!!");
        rcForm.typeInstructions("@TeSt \"yes\" 'no' / *b* ; select fid; ТеСт </br> eNd of' $string -");
        rcForm.uploadAddMaterials("/home/alexandr/Desktop/array.txt");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedFileLocator));
        rcForm.choosePaperFormat(apaFormatLocator);
        Assert.assertEquals(driver.findElement(apaFormatLocator).getText().trim(), "APA");
        String initialDeadline = driver.findElement(estimateDeadlineDateLocator).getText(); //gets estimated deadline before changing value
        rcForm.chooseDeadline(deadline5DaysLocator);
        String expectedDeadline = driver.findElement(estimateDeadlineDateLocator).getText();
        Assert.assertNotEquals(initialDeadline, expectedDeadline);
        rcForm.typeNumberOfPages("10");
        Assert.assertTrue(driver.findElement(pagesSideWindowLocator).getText().trim().startsWith("10"));
        rcForm.switchToReturningCustomerTab();
        Assert.assertTrue(driver.findElement(forgotPasswordLocator).isDisplayed());
        rcForm.typeEmail("test.yepishev@gmail.com");
        Assert.assertTrue(driver.findElement(emailLocator).getAttribute("value").equals("test.yepishev@gmail.com"));
        rcForm.typePassword("testyepishev");
        Assert.assertTrue(driver.findElement(passwordLocator).getAttribute("value").equals("testyepishev"));
        rcForm.signIn();
        Assert.assertTrue(driver.findElement(succesfullSignInLocator).getText().contains("test.yepishev@gmail.com"));
    }
}

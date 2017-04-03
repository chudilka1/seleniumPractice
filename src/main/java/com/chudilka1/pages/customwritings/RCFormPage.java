package com.chudilka1.pages.customwritings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class RCFormPage extends AbstractPage {

    //LOCATORS
    private String url;

    //PAPER DETAILS
    //Academic level
    private By highSchoolLocator = By.cssSelector(".radio-button.radio-button--n-1");
    private By undegrad12Locator = By.cssSelector(".radio-button.radio-button--n-2");
    private By undergrad34Locator = By.cssSelector(".radio-button.radio-button--n-3");
    private By mastersLocator = By.cssSelector(".radio-button.radio-button--n-4");
    private By phDLocator = By.cssSelector(".radio-button.radio-button--n-5");
    //Type of paper
    private By typeOfPaperLocator = By.cssSelector(".Select-placeholder");
    private By researchPaper = By.id("react-select-3--option-2");
    //Discipline
    private By disciplineLocator = By.cssSelector(".Select-placeholder");
    private By englishLiterature = By.cssSelector("#react-select-4--option-1");
    //Topic
    private By topicLocator = By.cssSelector(".UIInput.UIInput-default.UIInput-default--type-text.UIInput-default--size-m.UIInput-default--color-default.UIInput-default--oneline");
    //Paper Instructions
    private By instructionsLocator = By.cssSelector(".UIInput.UIInput-default.UIInput-default--type-textarea.UIInput-default--size-m.UIInput-default--color-default.UIInput-default--autosize.UIInput-default--not-resizable");
    //Additional Materials
    private By uploadAddMaterialsLocator = By.cssSelector(".UIInput.UIInput-default.UIInput-default--type-file.UIInput-default--size-m.UIInput-default--color-default.UIInput-default--oneline");
    private By uploadedFileLocator = By.cssSelector(".FormFile");
    //Paper Format
    private By mlaFormatLocator = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[1]/div[2]/div[7]/div[2]/div/div/div/div[1]/div[1]/button");
    private By apaFormatLocator = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[1]/div[2]/div[7]/div[2]/div/div/div/div[1]/div[2]/button");
    private By chicagoFormatLocator = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[1]/div[2]/div[7]/div[2]/div/div/div/div[1]/div[3]/button");
    private By notApplicableLocator = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[1]/div[2]/div[7]/div[2]/div/div/div/div[1]/div[4]/button");
    private By otherFormatLocator = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[1]/div[2]/div[7]/div[2]/div/div[1]/div/div[1]/div[5]/button");
    private By customFormatFieldLocator = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[1]/div[2]/div[7]/div[2]/div/div[2]/input");

    //PRICE CALCULATION
    //Deadline
    private String initialDeadline = "";
    private By estimateDeadlineDateLocator = By.cssSelector(".DeadlineControl__estimated-deadline__date");
    private By dealine8Hours = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/button");
    private By dealine24Hours = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/button");
    private By dealine48Hours = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[3]/button");
    private By deadline3Days = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[4]/button");
    private By deadline5Days = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[5]/button");
    private By deadline7Days = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[6]/button");
    private By deadline14Days = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[7]/button");
    private By deadline30Days = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[8]/button");
    //Pages
    private By pagesInoutLocator = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/input");

    //ACCOUNT
    private By returningCustomerTabLocator = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[3]/div[2]/div/div[1]/button[2]");
    private By forgotPasswordLocator = By.cssSelector(".Auth__link");
    private By emailLocator = By.name("email");
    private By passwordLocator = By.name("password");
    private By signInButtonLocator = By.cssSelector(".UIButton.UIButton-default-ghost.UIButton-default-ghost--size-l.UIButton-default-ghost--color-primary.UIButton-default-ghost--accent");
    private By succesfullSignInLocator = By.cssSelector(".rc-message.success.plate");

    private By paymentMenuSideWindowLocator = By.xpath(".//*[@id='react-select-8--value']/div[1]");
    private By payPalLocator = By.cssSelector(".payment-method-icon.payment-method-icon--g2s_paypal");
    private By creditCardLocator = By.cssSelector(".payment-method-icon.payment-method-icon--gate2shop");
    private By skrillLocator = By.cssSelector(".payment-method-icon.payment-method-icon--skrill");

    //SIDE WINDOW LOCATORS
    private By academicLevelSideWindowLocator = By.xpath("//*[@id='root']/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]");
    private By typeOfPaperSideWindowLocator = By.xpath("//*[@id='root']/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]");
    private By disciplineSideWindowLocator = By.xpath("//*[@id='root']/div/div/div[2]/div/div/div/div[2]/div[2]/div[3]");
    private By topicSideWindowLocator = By.cssSelector(".OrderformCheckoutInfo__order-topic");
    private By pagesSideWindowLocator = By.cssSelector(".OrderformCheckoutInfo__invoice__item__heading");
    private By pagesPriceSideWindowLocator = By.tagName("nobr");
    private By totalPriceSideWindowLocator = By.xpath(".//*[@id='root']/div/div/div[2]/div/div/div/div[2]/div[3]/div[2]/div[2]");
    private By payButtonSideWindowLocator = By.cssSelector(".OrderformCheckoutInfo__checkout-button.UIButton.UIButton-default-filled.UIButton-default-filled--size-l.UIButton-default-filled--color-primary");
    private By chosenPaymentMethodSideWindowLocator = By.xpath(".//*[@id='react-select-8--value']/div[1]");

    public RCFormPage(String url, WebDriver driver) {
        super(driver);
        this.url = url;
    }

    public RCFormPage open() {
        driver.get(url);
        return this;
    }

    public RCFormPage checkPage(String pageTitle) {
        Assert.assertEquals(driver.getTitle(), pageTitle);
        return this;
    }

    public RCFormPage chooseAcademicLevel(String academicLevel) {
        academicLevel = academicLevel.toLowerCase().replaceAll("\\s+","");
        switch (academicLevel) {
            case "highschool":
                driver.findElement(highSchoolLocator).click();
                break;
            case "undergraduate12":
                driver.findElement(undegrad12Locator).click();
                break;
            case "undergraduate34":
                driver.findElement(undergrad34Locator).click();
                break;
            case "masters":
                driver.findElement(mastersLocator).click();
                break;
            case "phd":
                driver.findElement(phDLocator).click();
                break;
            default:
                System.out.println("Entered Academic Level is not supported");
        }
        return this;
    }

    public RCFormPage checkAcademicLevel(String expectedResult){
        Assert.assertEquals(driver.findElement(academicLevelSideWindowLocator).getText().trim(), expectedResult);
        return this;
    }

    public RCFormPage chooseTypeOfPaper(String typeOfPaper) {
        typeOfPaper = typeOfPaper.toLowerCase().trim();
        driver.findElement(typeOfPaperLocator).click();
        switch (typeOfPaper) {
            case "research paper":
                driver.findElement(researchPaper).click();
                break;
            default:
                System.out.println("Entered Type of Paper is not supported");
        }
        return this;
    }

    public RCFormPage checkTypeOfPaper(String expectedResult) {
        Assert.assertEquals(driver.findElement(typeOfPaperSideWindowLocator).getText().trim(), expectedResult);
        return this;
    }

    public RCFormPage chooseNonCADiscipline(String discipline) {
        discipline = discipline.toLowerCase().trim();
        driver.findElement(disciplineLocator).click();
        switch (discipline) {
            case "english literature":
                driver.findElement(englishLiterature).click();
                break;
            default:
                System.out.println("Entered Discipline is not supported");
        }
        return this;
    }

    public RCFormPage checkDiscipline(String expectedResult) {
        Assert.assertEquals(driver.findElement(disciplineSideWindowLocator).getText().trim(), expectedResult);
        return this;
    }

    public RCFormPage typeTopic(String topic) {
        typeText(topicLocator, topic);
        return this;
    }

    public RCFormPage checkTopic(String expectedResult) {
        Assert.assertEquals(driver.findElement(topicSideWindowLocator).getText().trim(), expectedResult);
        return this;
    }

    public RCFormPage typeInstructions(String instructions) {
        typeText(instructionsLocator, instructions);
        return this;
    }

    public RCFormPage uploadAddMaterials(String fileName) {
        File file = new File("src/main/resources/RCForm/" + fileName);
        String filePath = file.getAbsolutePath();
        driver.findElement(uploadAddMaterialsLocator).sendKeys(filePath);
        return this;
    }

    public RCFormPage checkUploadedMaterials(){
        webDriverUtils.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(uploadedFileLocator));
        return this;
    }

    public RCFormPage choosePaperFormat(String paperFormat, String customFormat) {
        paperFormat = paperFormat.toLowerCase().trim();
        switch (paperFormat) {
            case "mla":
                driver.findElement(mlaFormatLocator).click();
                break;
            case "apa":
                driver.findElement(apaFormatLocator).click();
                break;
            case "chicago":
                driver.findElement(chicagoFormatLocator).click();
                break;
            case "not applicable":
                driver.findElement(notApplicableLocator).click();
                break;
            case "other":
                driver.findElement(otherFormatLocator).click();
                webDriverUtils.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(customFormatFieldLocator));
                typeText(customFormatFieldLocator, customFormat);
                break;
            default:
                System.out.println("Entered Paper Format is not supported");
        }
        return this;
    }

    //необходимо добавить id для кнопок и статус active, если нажата, изменить локаторы
    /*public RCFormPage checkPaperFormat(String expectedResult, String expectedComment) {
        expectedResult = expectedResult.toLowerCase().trim();
        switch (expectedResult) {
            case "mla":
                Assert.assertTrue(driver.findElement(mlaFormatLocator).getText().trim().equalsIgnoreCase(expectedResult));
                break;
            case "apa":
                Assert.assertTrue(driver.findElement(apaFormatLocator).getText().trim().equalsIgnoreCase(expectedResult));
                break;
            case "chicago / turabian":
                Assert.assertTrue(driver.findElement(chicagoFormatLocator).getText().trim().equalsIgnoreCase(expectedResult));
                break;
            case "not applicable":
                Assert.assertTrue(driver.findElement(notApplicableLocator).getText().trim().equalsIgnoreCase(expectedResult));
                break;
            case "other":
                Assert.assertTrue(driver.findElement(otherFormatLocator).getText().trim().equalsIgnoreCase(expectedResult));
                Assert.assertEquals(driver.findElement(customFormatFieldLocator).getText(), expectedComment);
                break;
        }
        return this;
    }*/

    public RCFormPage chooseDeadline(String deadline) {
        initialDeadline = driver.findElement(estimateDeadlineDateLocator).getText();
        deadline = deadline.toLowerCase().trim();
        switch (deadline) {
            case "8 hours":
                driver.findElement(dealine8Hours).click();
                break;
            case "24 hours":
                driver.findElement(dealine24Hours).click();
                break;
            case "48 hours":
                driver.findElement(dealine48Hours).click();
                break;
            case "3 days":
                driver.findElement(deadline3Days).click();
                break;
            case "5 days":
                driver.findElement(deadline5Days).click();
                break;
            case "7 days":
                driver.findElement(deadline7Days).click();
                break;
            case "14 days":
                driver.findElement(deadline14Days).click();
                break;
            case "30 days":
                driver.findElement(deadline30Days).click();
                break;
            default:
                System.out.println("Entered Deadline is not supported");
        }
        return this;
    }

    public RCFormPage checkDeadline() {
        String expectedDeadline = getTextFromElemnt(estimateDeadlineDateLocator);
        Assert.assertNotEquals(initialDeadline, expectedDeadline);
        return this;
    }

    public RCFormPage typeNumberOfPages(String pages) {
        typeText(pagesInoutLocator, pages);
        return this;
    }

    public RCFormPage checkPagesAndPrice(String pages, String price) {
        Assert.assertTrue(getTextFromElemnt(pagesSideWindowLocator).startsWith(pages));
        Assert.assertTrue(getTextFromElemnt(pagesPriceSideWindowLocator).contains(price));
        return this;
    }

    public RCFormPage switchToReturningCustomerTab() {
        click(returningCustomerTabLocator);
        return this;
    }

    public RCFormPage isReturningCustomerPage() {
        Assert.assertTrue(driver.findElement(forgotPasswordLocator).isDisplayed());
        return this;
    }

    public RCFormPage loginAsUser(String email, String password) {
        typeText(emailLocator, email);
        typeText(passwordLocator, password);
        click(signInButtonLocator);
        return this;
    }

    public RCFormPage isLoggedIn(String email) {
        webDriverUtils.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(succesfullSignInLocator));
        Assert.assertTrue(getTextFromElemnt(succesfullSignInLocator).contains(email));
        return this;
    }

    public RCFormPage checkTotal(String expectedResult) {
        Assert.assertTrue(getTextFromElemnt(totalPriceSideWindowLocator).contains(expectedResult));
        return this;
    }

    public RCFormPage choosePayment(String paymentSystem) {
        click(paymentMenuSideWindowLocator);
        paymentSystem = paymentSystem.toLowerCase().replaceAll("\\s+","");
        switch (paymentSystem) {
            case "paypal":
                click(payPalLocator);
                break;
            case "creditcard":
                click(creditCardLocator);
                break;
            case "skrill":
                click(skrillLocator);
                break;
            default:
                System.out.println("Entered payment method is not supported");
        }
        return this;
    }

    public RCFormPage checkChosenPayment(String expectedResult) {
        Assert.assertTrue(driver.findElement(chosenPaymentMethodSideWindowLocator).getAttribute("title").trim().contains(expectedResult));
        return this;
    }

    public RCFormPage submitOrder() {
        driver.findElement(payButtonSideWindowLocator).click();
        return this;
    }

    //Scroll page down
    public static void scrollDown(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,450)", "");
    }
}
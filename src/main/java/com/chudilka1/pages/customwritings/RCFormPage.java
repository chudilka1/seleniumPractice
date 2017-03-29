package com.chudilka1.pages.customwritings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RCFormPage extends AbstractPage {

    //locators
    private String url;
    private By typeOfPaperLocator = By.cssSelector(".Select-placeholder");
    private By disciplineLocator = By.cssSelector(".Select-placeholder");
    private By topicLocator = By.cssSelector(".UIInput.UIInput-default.UIInput-default--type-text.UIInput-default--size-m.UIInput-default--color-default.UIInput-default--oneline");
    private By instructionsLocator = By.cssSelector(".UIInput.UIInput-default.UIInput-default--type-textarea.UIInput-default--size-m.UIInput-default--color-default.UIInput-default--autosize.UIInput-default--not-resizable");
    private By uploadAddMaterialsLocator = By.cssSelector(".UIInput.UIInput-default.UIInput-default--type-file.UIInput-default--size-m.UIInput-default--color-default.UIInput-default--oneline");
    private By pagesInoutLocator = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/input");
    private By payButtonSideWindowLocator = By.cssSelector(".OrderformCheckoutInfo__checkout-button.UIButton.UIButton-default-filled.UIButton-default-filled--size-l.UIButton-default-filled--color-primary");

    //Account
    private By returningCustomerTabLocator = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[3]/div[2]/div/div[1]/button[2]");
    private By emailLocator = By.name("email");
    private By passwordLocator = By.name("password");
    private By signInButtonLocator = By.cssSelector(".UIButton.UIButton-default-ghost.UIButton-default-ghost--size-l.UIButton-default-ghost--color-primary.UIButton-default-ghost--accent");
    private By succesfullSignInLocator = By.cssSelector(".rc-message.success.plate");
    private By paymentMenuSideWindowLocator = By.xpath(".//*[@id='react-select-8--value']/div[1]");
    private By payPalLocator = By.cssSelector(".payment-method-icon.payment-method-icon--g2s_paypal");
    private By creditCardLocator = By.cssSelector(".payment-method-icon.payment-method-icon--gate2shop");
    private By skrillLocator = By.cssSelector(".payment-method-icon.payment-method-icon--skrill");


    public RCFormPage(String url, WebDriver driver) {
        super(driver);
        this.url = url;
    }

    public RCFormPage open() {
        driver.get(url);
        return this;
    }

    public RCFormPage chooseAcademicLevel(By academicLevelLocator) {
        driver.findElement(academicLevelLocator).click();
        return this;
    }

    public RCFormPage chooseTypeOfPaper(By desiredTypeOfPaper) {
        driver.findElement(typeOfPaperLocator).click();
        driver.findElement(desiredTypeOfPaper).click();
        return this;
    }

    public RCFormPage chooseNonCADiscipline(By desiredDiscipline) {
        driver.findElement(disciplineLocator).click();
        driver.findElement(desiredDiscipline).click();
        return this;
    }

    public RCFormPage typeTopic(String topic) {
        driver.findElement(topicLocator).clear();
        driver.findElement(topicLocator).sendKeys(topic);
        return this;
    }

    public RCFormPage typeInstructions(String instructions) {
        driver.findElement(instructionsLocator).clear();
        driver.findElement(instructionsLocator).sendKeys(instructions);
        return this;
    }

    public RCFormPage uploadAddMaterials(String filePath) {
        driver.findElement(uploadAddMaterialsLocator).sendKeys(filePath);
        return this;
    }

    public RCFormPage choosePaperFormat(By paperFormatLocator) {
        driver.findElement(paperFormatLocator).click();
        return this;
    }

    public RCFormPage chooseDeadline(By deadline5DaysLocator) {
        driver.findElement(deadline5DaysLocator).click();
        return this;
    }

    public RCFormPage typeNumberOfPages(String pages) {
        driver.findElement(pagesInoutLocator).clear();
        driver.findElement(pagesInoutLocator).sendKeys(pages);
        return this;
    }

    public void switchToReturningCustomerTab() {
        driver.findElement(returningCustomerTabLocator).click();
    }

    public RCFormPage typeEmail(String email) {
        driver.findElement(emailLocator).clear();
        driver.findElement(emailLocator).sendKeys(email);
        return this;
    }

    public RCFormPage typePassword(String password) {
        driver.findElement(passwordLocator).clear();
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public RCFormPage signIn() {
        driver.findElement(signInButtonLocator).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(succesfullSignInLocator));
        return this;
    }

    public RCFormPage choosePayment(String paymentSystem) {
        driver.findElement(paymentMenuSideWindowLocator).click();
        paymentSystem = paymentSystem.toLowerCase().replaceAll("\\s+","");
        switch (paymentSystem) {
            case "paypal":
                driver.findElement(payPalLocator).click();
                break;
            case "creditcard":
                driver.findElement(creditCardLocator).click();
                break;
            case "skrill":
                driver.findElement(skrillLocator).click();
                break;
            default:
                System.out.println("Entered payment method is not supported");
        }
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
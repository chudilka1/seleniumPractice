package com.chudilka1.pages.customwritings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RCForm extends AbstractPage {

    //locators
    private String url;
    private By typeOfPaperLocator = By.cssSelector(".Select-placeholder");
    private By disciplineLocator = By.cssSelector(".Select-placeholder");
    private By topicLocator = By.cssSelector(".UIInput.UIInput-default.UIInput-default--type-text.UIInput-default--size-m.UIInput-default--color-default.UIInput-default--oneline");
    private By instructionsLocator = By.cssSelector(".UIInput.UIInput-default.UIInput-default--type-textarea.UIInput-default--size-m.UIInput-default--color-default.UIInput-default--autosize.UIInput-default--not-resizable");
    private By uploadAddMaterialsLocator = By.cssSelector(".UIInput.UIInput-default.UIInput-default--type-file.UIInput-default--size-m.UIInput-default--color-default.UIInput-default--oneline");
    private By pagesInoutLocator = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/input");

    //Account
    private By returningCustomerTabLocator = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[3]/div[2]/div/div[1]/button[2]");
    private By emailLocator = By.name("email");
    private By passwordLocator = By.name("password");
    private By signInButtonLocator = By.cssSelector(".UIButton.UIButton-default-ghost.UIButton-default-ghost--size-l.UIButton-default-ghost--color-primary.UIButton-default-ghost--accent");
    private By succesfullSignInLocator = By.cssSelector(".rc-message.success.plate");


    public RCForm (String url, WebDriver driver) {
        super(driver);
        this.url = url;
    }

    public RCForm open() {
        driver.get(url);
        return this;
    }

    public RCForm chooseAcademicLevel(By academicLevelLocator) {
        driver.findElement(academicLevelLocator).click();
        return this;
    }

    public RCForm chooseTypeOfPaper(By desiredTypeOfPaper) {
        driver.findElement(typeOfPaperLocator).click();
        driver.findElement(desiredTypeOfPaper).click();
        return this;
    }

    public RCForm chooseNonCADiscipline(By desiredDiscipline) {
        driver.findElement(disciplineLocator).click();
        driver.findElement(desiredDiscipline).click();
        return this;
    }

    public RCForm typeTopic(String topic) {
        driver.findElement(topicLocator).clear();
        driver.findElement(topicLocator).sendKeys(topic);
        return this;
    }

    public RCForm typeInstructions(String instructions) {
        driver.findElement(instructionsLocator).clear();
        driver.findElement(instructionsLocator).sendKeys(instructions);
        return this;
    }

    public RCForm uploadAddMaterials(String filePath) {
        driver.findElement(uploadAddMaterialsLocator).sendKeys(filePath);
        return this;
    }

    public RCForm choosePaperFormat(By paperFormatLocator) {
        driver.findElement(paperFormatLocator).click();
        return this;
    }

    public RCForm chooseDeadline(By deadline5DaysLocator) {
        driver.findElement(deadline5DaysLocator).click();
        return this;
    }

    public RCForm typeNumberOfPages(String pages) {
        driver.findElement(pagesInoutLocator).clear();
        driver.findElement(pagesInoutLocator).sendKeys(pages);
        return this;
    }

    public void switchToReturningCustomerTab() {
        driver.findElement(returningCustomerTabLocator).click();
    }

    public RCForm typeEmail(String email) {
        driver.findElement(emailLocator).clear();
        driver.findElement(emailLocator).sendKeys(email);
        return this;
    }

    public RCForm typePassword(String password) {
        driver.findElement(passwordLocator).clear();
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public RCForm signIn() {
        driver.findElement(signInButtonLocator).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(succesfullSignInLocator));
        return this;
    }




    //Scroll page down
    public static void scrollDown(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,450)", "");
    }
}
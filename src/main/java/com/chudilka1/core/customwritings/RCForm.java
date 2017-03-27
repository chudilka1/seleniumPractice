package com.chudilka1.core.customwritings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RCForm {
    private final WebDriver driver;

    //locators
    public static String customwritingsURL = "https://www.customwritings.com";

    //Paper details
    By academicLevelLocator = By.cssSelector(".radio-button.radio-button--n-3");
    By academicLevelSideWindowLocator = By.xpath("//*[@id='root']/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]");
    By typeOfPaperLocator = By.cssSelector(".Select-placeholder");
    By desiredTypeOfPaper = By.cssSelector("#react-select-3--option-2");
    By typeOfPaperSideWindowLocator = By.xpath("//*[@id='root']/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]");
    By disciplineLocator = By.cssSelector(".Select-placeholder");
    By desiredDiscipline = By.cssSelector("#react-select-4--option-1");
    By disciplineSideWindowLocator = By.xpath("//*[@id='root']/div/div/div[2]/div/div/div/div[2]/div[2]/div[3]");
    By topicLocator = By.cssSelector(".UIInput.UIInput-default.UIInput-default--type-text.UIInput-default--size-m.UIInput-default--color-default.UIInput-default--oneline");
    By topicSideWindowLocator = By.cssSelector(".OrderformCheckoutInfo__order-topic");
    By instructionsLocator = By.cssSelector(".UIInput.UIInput-default.UIInput-default--type-textarea.UIInput-default--size-m.UIInput-default--color-default.UIInput-default--autosize.UIInput-default--not-resizable");
    By uploadAddMaterialsLocator = By.cssSelector(".UIInput.UIInput-default.UIInput-default--type-file.UIInput-default--size-m.UIInput-default--color-default.UIInput-default--oneline");
    By uploadedFileLocator = By.cssSelector(".FormFile");
    By paperFormatLocator = By.cssSelector(".radio-button.radio-button--n-1");

    //Price calculation
    By deadline5DaysLocator = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[5]/button");
    By estimateDeadlineDateLocator = By.cssSelector(".DeadlineControl__estimated-deadline__date");
    By pagesInoutLocator = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/input");
    By pagesSideWindowLocator = By.cssSelector(".OrderformCheckoutInfo__invoice__item__heading");
    By sourcesInputLocator = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[2]/div[2]/div[3]/div[1]/div[2]/div/div/input");

    //Account
    By returningCustomerTabLocator = By.xpath("//*[@id='root']/div/div/div[1]/div[3]/div/div[3]/div[2]/div/div[1]/button[2]");
    By emailLocator = By.name("email");
    By passwordLocator = By.name("password");
    By signInButtonLocator = By.cssSelector(".UIButton.UIButton-default-ghost.UIButton-default-ghost--size-l.UIButton-default-ghost--color-primary.UIButton-default-ghost--accent");
    By forgotPasswordLocator = By.cssSelector(".Auth__link");
    By succesfullSignInLocator = By.cssSelector(".rc-message.success.plate");

    //Input data
    String topic = "TESTING ORDER!!!";
    String instructions = "@TeSt \"yes\" 'no' / *b* ; select fid; ТеСт </br> eNd of' $string -";
    String title = "Order now | Custom Written Essays, Term Papers, Research Papers, Thesis Papers, Dissertation and more";
    String expectedAcademicLevel = "Undergrad. (yrs 3-4)";
    String filePath = "C:\\Users\\User\\Desktop\\array.txt";
    String pages = "10";
    String email = "test.yepishev@gmail.com";
    String password = "testyepishev";

    //logic
    public RCForm(WebDriver driver) {
        this.driver = driver;
        if (!title.equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the order page");
        }
    }

    public void chooseAcademicLevel() {
        driver.findElement(academicLevelLocator).click();
        if (!driver.findElement(academicLevelSideWindowLocator).getText().equals(expectedAcademicLevel)) {
            throw new IllegalStateException("Academic level in side-window does not correspond to the chosen one");
        }
    }

    public void chooseTypeOfPaper() {
        driver.findElement(typeOfPaperLocator).click();
        String nameOfOption = driver.findElement(desiredTypeOfPaper).getText();
        driver.findElement(desiredTypeOfPaper).click();
        if (!driver.findElement(typeOfPaperSideWindowLocator).getText().trim().equals(nameOfOption)) {
            throw new IllegalStateException("Type of paper in side-window does not correspond to the chosen one");
        }
    }

    public void chooseNonCADiscipline() {
        driver.findElement(disciplineLocator).click();
        String nameOfOption = driver.findElement(desiredDiscipline).getText();
        driver.findElement(desiredDiscipline).click();
        if (!driver.findElement(disciplineSideWindowLocator).getText().trim().equals(nameOfOption)) {
            throw new IllegalStateException("Discipline in side-window does not correspond to the chosen one");
        }
    }

    public void typeTopic() {
        driver.findElement(topicLocator).clear();
        driver.findElement(topicLocator).sendKeys(topic);
        if (!driver.findElement(topicSideWindowLocator).getText().contains(topic)) {
            throw new IllegalStateException("Topic in side-window does not correspond to the typed one");
        }
    }

    public void typeInstructions() {
        driver.findElement(instructionsLocator).clear();
        driver.findElement(instructionsLocator).sendKeys(instructions);
    }

    public void uploadAddMaterials() {
        driver.findElement(uploadAddMaterialsLocator).sendKeys(filePath);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedFileLocator));
    }

    public void choosePaperFormat() {
        driver.findElement(paperFormatLocator).click();
    }

    public void chooseDeadline() {
        String initialEstimate = driver.findElement(estimateDeadlineDateLocator).getText();
        driver.findElement(deadline5DaysLocator).click();
        String actualEstimate = driver.findElement(estimateDeadlineDateLocator).getText();
        if (actualEstimate.equals(initialEstimate)) {
            throw new IllegalStateException("Estimated Deadline did not change");
        }
    }

    public void typeNumberOfPages() {
        driver.findElement(pagesInoutLocator).clear();
        driver.findElement(pagesInoutLocator).sendKeys(pages);
        if (!driver.findElement(pagesSideWindowLocator).getText().trim().startsWith(pages)) {
            throw new IllegalStateException("Pages in side-window do not correspond to the typed ones");
        }
    }

    public void switchToReturningCustomerTab() {
        driver.findElement(returningCustomerTabLocator).click();
        if (!driver.findElement(forgotPasswordLocator).isDisplayed()) {
            throw new IllegalStateException("Did not switch to 'Returning Customer' tab");
        }
    }

    public void typeEmail() {
        driver.findElement(emailLocator).clear();
        driver.findElement(emailLocator).sendKeys(email);
        if (!driver.findElement(emailLocator).getAttribute("value").equals(email)) {
            throw new IllegalStateException("Email was not entered");
        }
    }

    public void typePassword() {
        driver.findElement(passwordLocator).clear();
        driver.findElement(passwordLocator).sendKeys(password);
        if (!driver.findElement(passwordLocator).getAttribute("value").equals(password)) {
            throw new IllegalStateException("Password was not entered");
        }
    }

    public void signIn() {
        driver.findElement(signInButtonLocator).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(succesfullSignInLocator));
        if (!driver.findElement(succesfullSignInLocator).getText().contains(email)) {
            throw new IllegalStateException("Displayed email is incorrect");
        }
    }




    //Scroll page down
    public static void scrollDown(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,450)", "");
    }
}

        /*
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(deadline5DaysLocator));*/
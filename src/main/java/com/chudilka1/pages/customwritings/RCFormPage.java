package com.chudilka1.pages.customwritings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.File;

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
    private By returningCustomerTabLocator = By.xpath(".//*[@id='root']/div/div/div[1]/div[3]/div/div[3]/div[2]/div/div[1]/button[2]");
    private By forgotPasswordLocator = By.cssSelector(".Auth__link");
    private By emailLocator = By.name("email");
    private By passwordLocator = By.name("password");
    private By signInButtonLocator = By.xpath(".//*[@id='root']/div/div/div[1]/div[3]/div/div[3]/div[2]/div/div[2]/form/div/div[3]/button");
    private By succesfullSignInLocator = By.cssSelector(".rc-message.success.plate");

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
    private By paymentMenuSideWindowLocator = By.xpath(".//*[@id='root']/div/div/div[2]/div/div/div/div[2]/div[4]/div/div/div/span[2]");
    private By payPalLocator = By.cssSelector(".payment-method-icon.payment-method-icon--g2s_paypal");
    private By creditCardLocator = By.cssSelector(".payment-method-icon.payment-method-icon--gate2shop");
    private By skrillLocator = By.cssSelector(".payment-method-icon.payment-method-icon--skrill");
    private By paymentMenuHolderSideWindowLocator = By.xpath("//*[@id='root']/div/div/div[2]/div/div/div/div[2]/div[4]/div/div/div[2]");

    public RCFormPage(String url, WebDriver driver) {
        super(driver);
        this.url = url;
    }

    @Step("Открытие страницы")
    public RCFormPage open() {
        driver.get(url);
        return this;
    }

    @Step("Проверка: открытая страница - {0}")
    public RCFormPage checkPage(String pageTitle) {
        Assert.assertTrue(driver.getTitle().contains(pageTitle));
        return this;
    }

    @Step("Выбор академического уровня - {0}")
    public RCFormPage chooseAcademicLevel(String academicLevel) {
        academicLevel = academicLevel.toLowerCase().replaceAll("\\s+","");
        switch (academicLevel) {
            case "highschool":
                click(highSchoolLocator);
                break;
            case "undergraduate12":
                click(undegrad12Locator);
                break;
            case "undergraduate34":
                jsClick(undergrad34Locator);
                break;
            case "masters":
                click(mastersLocator);
                break;
            case "phd":
                click(phDLocator);
                break;
            default:
                System.out.println("Entered Academic Level is not supported");
        }
        return this;
    }

    @Step("Проверка: выбранный кадемический уровень - {0}")
    public RCFormPage checkAcademicLevel(String expectedResult){
        Assert.assertEquals(getTextFromElement(academicLevelSideWindowLocator).trim(), expectedResult);
        return this;
    }

    @Step("Выбор типа реферата - {0}")
    public RCFormPage chooseTypeOfPaper(String typeOfPaper) {
        typeOfPaper = typeOfPaper.toLowerCase().trim();
        click(typeOfPaperLocator);
        //в случае необходимости добавить различные типы рефератов
        switch (typeOfPaper) {
            case "research paper":
                click(researchPaper);
                break;
            default:
                System.out.println("Entered Type of Paper is not supported");
        }
        return this;
    }

    @Step("Проверка: тип реферата - {0}")
    public RCFormPage checkTypeOfPaper(String expectedResult) {
        Assert.assertEquals(getTextFromElement(typeOfPaperSideWindowLocator).trim(), expectedResult);
        return this;
    }

    @Step("Выбор дисциплины - {0}")
    public RCFormPage chooseNonCADiscipline(String discipline) {
        discipline = discipline.toLowerCase().trim();
        click(disciplineLocator);
        //в случае необходимости добавить новые дисциплины
        switch (discipline) {
            case "english literature":
                click(englishLiterature);
                break;
            default:
                System.out.println("Entered Discipline is not supported");
        }
        return this;
    }

    @Step("Проверка: выбранная дисциплина - {0}")
    public RCFormPage checkDiscipline(String expectedResult) {
        Assert.assertEquals(getTextFromElement(disciplineSideWindowLocator).trim(), expectedResult);
        return this;
    }

    @Step("Ввод темы - {0}")
    public RCFormPage typeTopic(String topic) {
        typeText(topicLocator, topic);
        return this;
    }

    @Step("Проверка: введенная тема - {0}")
    public RCFormPage checkTopic(String expectedResult) {
        Assert.assertEquals(getTextFromElement(topicSideWindowLocator).trim(), expectedResult);
        return this;
    }

    @Step("Ввод инструкций")
    public RCFormPage typeInstructions(String instructions) {
        typeText(instructionsLocator, instructions);
        return this;
    }

    @Step("Подгрузка материалов")
    public RCFormPage uploadAddMaterials(String fileName) {
        File file = new File("src/test/resources/RCForm/" + fileName);
        String filePath = file.getAbsolutePath();
        driver.findElement(uploadAddMaterialsLocator).sendKeys(filePath);
        return this;
    }

    @Step("Проверка: материалы подгружены")
    public RCFormPage checkUploadedMaterials(){
        webDriverUtils.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(uploadedFileLocator));
        return this;
    }

    @Step("Выбор формата работы")
    public RCFormPage choosePaperFormat(String paperFormat, String customFormat) {
        paperFormat = paperFormat.toLowerCase().trim();
        switch (paperFormat) {
            case "mla":
                click(mlaFormatLocator);
                break;
            case "apa":
                click(apaFormatLocator);
                break;
            case "chicago":
                click(chicagoFormatLocator);
                break;
            case "not applicable":
                click(notApplicableLocator);
                break;
            case "other":
                click(otherFormatLocator);
                webDriverUtils.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(customFormatFieldLocator));
                typeText(customFormatFieldLocator, customFormat);
                break;
            default:
                System.out.println("Entered Paper Format is not supported");
        }
        return this;
    }

    //необходимо добавить id для кнопок, возможно делать проверку нажата ли кнопка (статус active, если нажата, изменить локаторы)
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

    @Step("Выбор дедлайна - {0}")
    public RCFormPage chooseDeadline(String deadline) {
        initialDeadline = driver.findElement(estimateDeadlineDateLocator).getText();
        deadline = deadline.toLowerCase().trim();
        switch (deadline) {
            case "8 hours":
                click(dealine8Hours);
                break;
            case "24 hours":
                click(dealine24Hours);
                break;
            case "48 hours":
                click(dealine48Hours);
                break;
            case "3 days":
                click(deadline3Days);
                break;
            case "5 days":
                click(deadline5Days);
                break;
            case "7 days":
                click(deadline7Days);
                break;
            case "14 days":
                click(deadline14Days);
                break;
            case "30 days":
                click(deadline30Days);
                break;
            default:
                System.out.println("Entered Deadline is not supported");
        }
        return this;
    }

    @Step("Проверка: изменение дедлайна")
    public RCFormPage checkDeadline() {
        String expectedDeadline = getTextFromElement(estimateDeadlineDateLocator);
        Assert.assertNotEquals(initialDeadline, expectedDeadline);
        return this;
    }

    @Step("Выбор {0} страниц")
    public RCFormPage typeNumberOfPages(String pages) {
        typeText(pagesInoutLocator, pages);
        return this;
    }

    @Step("Проверка: количество страниц - {0}, стоимость - {1}")
    public RCFormPage checkPagesAndPrice(String pages, String price) {
        Assert.assertTrue(getTextFromElement(pagesSideWindowLocator).startsWith(pages));
        Assert.assertTrue(getTextFromElement(pagesPriceSideWindowLocator).contains(price));
        return this;
    }

    @Step("Переход на вкладку 'Returning customer'")
    public RCFormPage switchToReturningCustomerTab() {
        click(returningCustomerTabLocator);
        return this;
    }

    @Step("Проверка: вкладке 'Returning Customer'")
    public RCFormPage isReturningCustomerPage() {
        Assert.assertTrue(driver.findElement(forgotPasswordLocator).isDisplayed());
        return this;
    }

    @Step("Вход пользователя")
    public RCFormPage loginAsUser(String email, String password) {
        typeText(emailLocator, email);
        typeText(passwordLocator, password);
        click(signInButtonLocator);
        return this;
    }

    @Step("Залогирован: отображается - {0}")
    public RCFormPage isLoggedIn(String email) {
        webDriverUtils.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(succesfullSignInLocator));
        Assert.assertTrue(getTextFromElement(succesfullSignInLocator).contains(email));
        return this;
    }

    @Step("Проверка: итоговая стоимость - {0}")
    public RCFormPage checkTotal(String expectedResult) {
        Assert.assertTrue(getTextFromElement(totalPriceSideWindowLocator).contains(expectedResult));
        return this;
    }

    @Step("Выбор пеймент метода - {0}")
    public RCFormPage choosePayment(String paymentSystem) {
        click(paymentMenuSideWindowLocator);
        webDriverUtils.waitForExpectedCondition(ExpectedConditions.visibilityOfAllElementsLocatedBy(paymentMenuHolderSideWindowLocator));
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

    @Step("Проверка: выбранный пеймент метод - {0}")
    public RCFormPage checkChosenPayment(String expectedResult) {
        Assert.assertTrue(driver.findElement(chosenPaymentMethodSideWindowLocator).getAttribute("title").trim().contains(expectedResult));
        return this;
    }

    @Step("Проплата (To checkout)")
    public RCFormPage submitOrder() {
        driver.findElement(payButtonSideWindowLocator).click();
        return this;
    }

    //Scroll page down
    public static void scrollDown(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,450)", "");
    }
}
package bdd.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EnterpreneurSteps {
    protected WebDriver driver;
    private WebElement fieldFio;
    private WebElement fieldCity;
    private WebElement fieldPhone;
    private WebElement fieldEmail;
    private WebElement fieldPassword;
    private WebElement checkBox;
    private WebElement proceedFurther;
    private WebElement nextPageName;
    private By fieldFioLocator = By.xpath(".//*[@id='fio']");
    private By fieldCityLocator = By.xpath(".//*[@id='city']");
    private By fieldPhoneLocator = By.id ("tel");
    private By fieldEmailLocator = By.id ("mail");
    private By fieldPassLocator = By.id ("pass");
    private By checkBoxLocator = By.xpath(".//*[@id='entrepreneur-register-form']/div[1]/div/div[2]/form/div[5]/div[3]/div/label");
    private By proceedFurtherLocator = By.xpath(".//*[@id='entrepreneur-register-form']/div[1]/div/div[2]/form/div[6]/button");
    private By nextPageNameLocator = By.xpath(".//*[@id='entrepreneur-register-form']/div[1]/div/div[2]/form/div[1]/label");

    @Given("^I am on new project registration page \"([^\"]*)\"$")
    public void setup(String url) {
//        System.setProperty("webdriver.gecko.driver", "C:\\KIT\\AboutTheCodeAutomationE2E\\e2e_automation\\src\\test\\resources\\geckodriver\\geckodriver.exe")
        System.setProperty("webdriver.chrome.driver", "D:\\Dropbox\\Documents\\Books\\QA\\QA_automation\\GitHub\\seleniumPractice\\src\\test\\resources\\browserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("^I fill my First Name \"([^\"]*)\" and Last Name \"([^\"]*)\" into Full Name field$")
    public void iFillMyFirstNameAndLastNameIntoFullNameField(String firstName, String lastName) throws Throwable {
        String fullName = firstName + " " + lastName;
        fieldFio = driver.findElement(fieldFioLocator);
        Thread.sleep(2000);
        fieldFio.clear();
        fieldFio.sendKeys(fullName);
        Assert.assertEquals(fieldFio.getAttribute("value"), fullName);
    }

    @And("^I fill my City \"([^\"]*)\" into City field$")
    public void IFillmyCityintoCityfield(String city) throws Throwable {
        String cityE = city;
        fieldCity = driver.findElement(fieldCityLocator);
        fieldCity.clear();
        fieldCity.sendKeys(cityE);
        Assert.assertEquals(fieldCity.getAttribute("value"), cityE);
    }

    @And("^I fill my phone number \"([^\"]*)\" into Phone field$")
    public void iFillMyPhoneIntoPhoneField(String phone) throws Throwable {
        String phoneE = phone;
        fieldPhone = driver.findElement(fieldPhoneLocator);
        fieldPhone.clear();
        fieldPhone.sendKeys(phoneE);
        Assert.assertEquals(fieldPhone.getAttribute("placeholder"), "+380507863421");
    }

    @And("^I fill my email address \"([^\"]*)\" into Email field$")
    public void iFillMyEmailIntoEmailField(String email) throws Throwable {
        String emailE = email;
        fieldEmail = driver.findElement(fieldEmailLocator);
        fieldEmail.clear();
        fieldEmail.sendKeys(emailE);
        Assert.assertEquals(fieldEmail.getAttribute("value"), emailE);
    }

    @And("^I fill my desired password \"([^\"]*)\" into Password field$")
    public void iFillMyPassIntoPassField(String pass) throws Throwable {
        String passE = pass;
        fieldPassword = driver.findElement(fieldPassLocator);
        fieldPassword.clear();
        fieldPassword.sendKeys(passE);
        Assert.assertEquals(fieldPassword.getAttribute("value"), passE);
    }

    @And("^I set checkbox to show my password$")
    public void iCheckCheckBox(){
        checkBox = driver.findElement(checkBoxLocator);
        checkBox.click();
    }

    @And("^I go next to second project registration page$")
    public void iClickProceedFurther(){
        proceedFurther = driver.findElement(proceedFurtherLocator);
        proceedFurther.click();
    }

    @Then("^I should see form field with \"([^\"]*)\" title$")
    public void isSecondPageRegistration(String name) throws Throwable {
        Thread.sleep(3000);
        String nameE = name;
        nextPageName = driver.findElement(nextPageNameLocator);
        System.out.println(nextPageName.getText());
        Assert.assertTrue (nextPageName.getText().contains(nameE));
    }

    @And("^I close browser$")
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}

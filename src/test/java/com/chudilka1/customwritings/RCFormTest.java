package com.chudilka1.customwritings;

import com.chudilka1.core.WebDriverTestBase;
import com.chudilka1.pages.customwritings.RCFormPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Listeners({com.chudilka1.core.TestListener.class})
public class RCFormTest extends WebDriverTestBase {

    @Title("Заполнение RCForm")
    @Description("Оформление ордера без Complex Assignment, презентаций, таблиц, допсервисов + существующий пользователь")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void submitOrderForm() {
        RCFormPage rcForm = new RCFormPage("https://customwritings.com/order.html", driver);
        rcForm.open()
                .checkPage("Order now");

        //Filling up 'Paper Details'

        rcForm.chooseAcademicLevel("Undergraduate 3 4")
                .checkAcademicLevel("Undergrad. (yrs 3-4)")
                .chooseTypeOfPaper("Research Paper")
                .checkTypeOfPaper("Research paper")
                .chooseNonCADiscipline("English literature")
                .checkDiscipline("Classic English Literature")
                .typeTopic("TESTING ORDER!!!")
                .checkTopic("TESTING ORDER!!!")
                .typeInstructions("@TeSt \"yes\" 'no' / *b* ; select fid; ТеСт </br> eNd of' $string -")
                .uploadAddMaterials("uploadMaterial1.txt")
                .checkUploadedMaterials()
                .choosePaperFormat("Other", "my custom format");

        //Filling up 'Price calculation'
        rcForm.chooseDeadline("5 days")
                .checkDeadline()
                .typeNumberOfPages("10")
                .checkPagesAndPrice("10", "190");

        //Filling up 'Account'
        rcForm.switchToReturningCustomerTab()
                .isReturningCustomerPage()
                .loginAsUser("test.yepishev@gmail.com", "testyepishev")
                .isLoggedIn("test.yepishev@gmail.com");

        //Choosing payment system
        rcForm.checkTotal("190.00")
                .choosePayment("skrill")
                .checkChosenPayment("");

        //rcForm.submitOrder();
        //mvn clean install site jetty:run
    }
}
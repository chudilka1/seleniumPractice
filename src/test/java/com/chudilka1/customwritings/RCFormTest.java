package com.chudilka1.customwritings;

import com.chudilka1.core.WebDriverTestBase;
import com.chudilka1.core.customwritings.RCForm;
import org.testng.annotations.Test;

public class RCFormTest extends WebDriverTestBase {
    @Test
    public void submitOrderForm() {
        driver.get(RCForm.customwritingsURL + "/order.html");
        RCForm rcForm = new RCForm(driver);
        rcForm.chooseAcademicLevel();
        rcForm.chooseTypeOfPaper();
        rcForm.chooseNonCADiscipline();
        rcForm.typeTopic();
        rcForm.typeInstructions();
        rcForm.uploadAddMaterials();
        rcForm.choosePaperFormat();
        rcForm.chooseDeadline();
        rcForm.typeNumberOfPages();
        rcForm.switchToReturningCustomerTab();
        rcForm.typeEmail();
        rcForm.typePassword();
        rcForm.signIn();
    }
}

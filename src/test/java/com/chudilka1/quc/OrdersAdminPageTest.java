package com.chudilka1.quc;

import com.chudilka1.core.WebDriverTestBase;
import com.chudilka1.pages.quc.NewPaidPage;
import com.chudilka1.pages.quc.OrdersAdminPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.chudilka1.core.TestListener.class})
public class OrdersAdminPageTest extends WebDriverTestBase {
    private String orderID = "183785393";

    @Test (enabled = false)
    public void findOrder() {
        OrdersAdminPage oAdmin = new OrdersAdminPage("https://q.uvocorp.com/orders_admin", driver);
        oAdmin.open()
                .checkPage("Orders Admin")
                .typerOrderID(orderID)
                .searchOrders()
                .checkSearchResult(orderID);

        NewPaidPage newPaid = oAdmin.openOrder();

        newPaid.checkPage(orderID)
                .openAssignWriterDialog();
    }

}

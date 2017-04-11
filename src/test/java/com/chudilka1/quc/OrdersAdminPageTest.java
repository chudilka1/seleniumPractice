package com.chudilka1.quc;

import com.chudilka1.core.WebDriverTestBase;
import com.chudilka1.pages.quc.NewPaidPage;
import com.chudilka1.pages.quc.OrdersAdminPage;
import org.testng.annotations.Test;

public class OrdersAdminPageTest extends WebDriverTestBase {
    private String orderID = "183785393";

    @Test
    //@Description("Оформление ордера без Complex Assignment, презентаций, таблиц, допсервисов + существующий пользователь")
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

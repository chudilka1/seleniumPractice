package com.chudilka1.quc;

import com.chudilka1.core.WebDriverTestBase;
import com.chudilka1.pages.quc.OrdersAdminPage;
import com.sun.org.glassfish.gmbal.Description;
import org.testng.annotations.Test;

public class OrdersAdminPageTest extends WebDriverTestBase {
    @Test
    @Description("Оформление ордера без Complex Assignment, презентаций, таблиц, допсервисов + существующий пользователь")
    public void findOrder() {
        OrdersAdminPage oAdmin = new OrdersAdminPage("https://q.uvocorp.com/orders_admin", driver);
        oAdmin.open()
                .checkPage("Orders Admin")
                .typerOrderID("183780823")
                .searchOrders()
                .checkSearchResult("183780823");
    }
}

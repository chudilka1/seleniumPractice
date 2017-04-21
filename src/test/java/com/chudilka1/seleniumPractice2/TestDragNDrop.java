package com.chudilka1.seleniumPractice2;

import com.chudilka1.core.WebDriverTestBase;
import com.chudilka1.pages.seleniumPractice2.DragNDrop;
import org.testng.annotations.Test;

public class TestDragNDrop extends WebDriverTestBase {

    @Test
    public void DragDrop () {
        DragNDrop dragNDrop = new DragNDrop("http://www.dhtmlx.com/docs/products/dhtmlxTree/index.shtml", driver);

        dragNDrop.open()
                .dragImage();
    }
}

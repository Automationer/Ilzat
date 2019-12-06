package com.homedepot.pageObjects.sections;

import com.homedepot.common.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderSection {

    private Library library;

    public HeaderSection() {
        library = new Library();
    }

    public List<WebElement> getHeaderTaskLinks() {
        List<WebElement> header_task_links = library.findAll("Header task links", By.cssSelector("#TasklinkList>li>a"));
        return header_task_links;
    }

    public List<WebElement> getHeaderTabs() {
        List<WebElement> header_tabs = library.findAll("Header Tabs", By.cssSelector(".ShoppingLinks>li"));
        return header_tabs;
    }


}

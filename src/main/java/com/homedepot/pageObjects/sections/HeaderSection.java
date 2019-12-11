package com.homedepot.pageObjects.sections;

import com.homedepot.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderSection {

    @FindBy(css = "#TasklinkList>li>a") List<WebElement> headerTask_links;
    @FindBy(css = ".ShoppingLinks>li") List<WebElement> header_tabs;

    public HeaderSection() {

        PageFactory.initElements(Base.getDriver(), this);
    }

    public List<WebElement> getHeaderTaskLinks() {
        return headerTask_links;
    }

    public List<WebElement> getHeaderTabs() {
        return header_tabs;
    }


}

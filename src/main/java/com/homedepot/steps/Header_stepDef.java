package com.homedepot.steps;

import com.homedepot.pageObjects.sections.HeaderSection;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Header_stepDef {

    private HeaderSection header_task_links = new HeaderSection();

    private static ArrayList<String> hrefList = new ArrayList<>();

    @When("^User click on the top header links$")
    public void user_click_on_the_top_header_links() {
        List<WebElement> headerTaskLinks = header_task_links.getHeaderTaskLinks();
        for (WebElement temp : headerTaskLinks) {
            String href = temp.getAttribute("href");
            hrefList.add(href);
        }
    }

    @Then("^Then they should open correct pages$")
    public void then_they_should_open_correct_pages() {
        for (String href : hrefList) {
            Assert.assertNotNull(href);
        }
    }

}

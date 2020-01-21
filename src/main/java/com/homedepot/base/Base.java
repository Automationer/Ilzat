package com.homedepot.base;

import com.homedepot.common.Library;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class Base {

    public Library library;
    public static WebDriver driver;

    @Before
    public void setup() {
        library = new Library();
        driver = library.openBrowser();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}











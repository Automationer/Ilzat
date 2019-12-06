package com.homedepot.common;

import com.homedepot.pageObjects.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Library {

    public static WebDriver driver;
    public CustomWait wait = new CustomWait();

    public WebDriver openBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/yilizatiabudusaimaiti/IdeaProjects/Cyram_Automation/StartOver/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.homedepot.com/");
        driver.manage().window().setSize(new Dimension(1600, 1300));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new HomePage().getDriver();
    }

    public void enter(String elementName, String value, By by) {
        if (by instanceof By.ByXPath || by instanceof By.ByCssSelector || by instanceof By.ById) {
            WebElement element = wait.waitUntilPresent(by);
            element.clear();
            element.sendKeys(value);
        } else
            System.err.println("Locator is not implemented");
    }

    public void click(String elementName, By by) {
        if (by instanceof By.ByXPath || by instanceof By.ByCssSelector || by instanceof By.ById)
            wait.waitUntilClickable(by).click();
        else
            System.err.println("Locator is not implemented");
    }

    public void click(String elementName, WebElement element) {
        wait.waitUntilClickable(element);
        element.click();
    }

    public WebElement find(String elementName, By by) {
        WebElement element = wait.waitUntilPresent(by);
        return element;
    }

    public List<WebElement> findAll(String elementName, By by) {
        List<WebElement> webElements = wait.waitUntilAllPresent(by);
        return webElements;
    }

    public void selectDropdownByValue(By by, String value) {
        if (by instanceof By.ByXPath || by instanceof By.ByCssSelector || by instanceof By.ById) {
            WebElement dropdown = wait.waitUntilPresent(by);
            Select select = new Select(dropdown);
            select.selectByValue(value);
        }
    }

    public void selectDropdownByText(String elementName, String value, By by) {
        if (by instanceof By.ByXPath || by instanceof By.ByCssSelector || by instanceof By.ById) {
            WebElement dropdown = wait.waitUntilPresent(by);
            Select select = new Select(dropdown);
            select.selectByVisibleText(value);
        }
    }

    public void waitFor(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollDown(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(" + x + "," + ") ");
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitFor(1);
    }

    public void switchToIframe(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void hoverOver(String elementName, By by) {
        WebElement element = wait.waitUntilVisible(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void hoverOver(String elementName, WebElement element) {
        WebElement element1 = wait.waitUntilVisible(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element1).build().perform();
        waitFor(1);
    }

    public void switchTab() {
        String windowHandle = driver.getWindowHandle();
        for (String s : driver.getWindowHandles()) {
            if (!s.equals(windowHandle)) {
                driver.switchTo().window(s);
            }
        }
        waitFor(1);
    }

}

package org.opensource.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
    // ThreadLocal driver for parallel execution
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Get driver instance
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Initialize driver
    public static void initDriver(String browser) {
        WebDriver webDriver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            webDriver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.set(webDriver);
        getDriver().manage().window().maximize();
    }

    // Quit driver
    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove(); // very important for parallel runs
        }
    }
}

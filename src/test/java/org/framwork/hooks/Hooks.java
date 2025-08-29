package org.framwork.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.opensource.base.BaseClass;
import org.opensource.utils.ScenarioContext;

public class Hooks {
    @Before
    public void setUp(Scenario sc) {
        BaseClass.initDriver("chrome");
        BaseClass.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        ScenarioContext.setScenario(sc);
    }
    public static void takeScreenshot(String name){
        Scenario scenario = ScenarioContext.getScenario();
        final byte[] screenshot = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png",name);
        ScenarioContext.removeScenario();
    }
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take screenshot
            final byte[] screenshot = ((TakesScreenshot) BaseClass.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            // Attach to Cucumber Report
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        BaseClass.quitDriver();
    }
}

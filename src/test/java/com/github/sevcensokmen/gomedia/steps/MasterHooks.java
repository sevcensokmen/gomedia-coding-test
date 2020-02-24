package com.github.sevcensokmen.gomedia.steps;

import com.github.sevcensokmen.gomedia.utils.BaseSteps;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class MasterHooks extends BaseSteps {

    @Before
    public void setUp() {
        init();

    }

    @After()
    public void LogoutAndTakeScreenshotOnFailure(Scenario scenario) throws Throwable {
        if (getDriver() != null && scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
            Thread.sleep(3000);
        }
        Thread.sleep(2000);
        cleanup();
    }


}

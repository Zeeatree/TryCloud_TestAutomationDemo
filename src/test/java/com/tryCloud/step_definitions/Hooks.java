package com.tryCloud.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.tryCloud.utilities.ConfigurationReader;
import com.tryCloud.utilities.Driver;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    private static final Logger logger = LogManager.getLogger();

    @Before(order = 1)
    public void setupMethod() {
        logger.info("Setting up browser and navigating to the URL");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigurationReader.getLong("implicit_wait")));
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @After
    public void teardownMethod(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                logger.error("Scenario '{}' failed: {}", scenario.getName(), scenario.getStatus());
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", getScreenshotName(scenario));
            }
        } catch (Exception e) {
            logger.error("Exception occurred: {}", e.getMessage());
        } finally {
            logger.info("Closing the driver");
            Driver.closeDriver();
        }
    }

    private String getScreenshotName(Scenario scenario) {
        LocalDateTime now = LocalDateTime.now();
        String dateTime = now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        return String.format("%s_%s_%s", scenario.getName(), dateTime, ConfigurationReader.getProperty("environment"));
    }
}
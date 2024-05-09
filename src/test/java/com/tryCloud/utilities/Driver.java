package com.tryCloud.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public final class Driver {

    private static final Logger logger = LogManager.getLogger(Driver.class);

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    private static InheritableThreadLocal<Actions> actionPool = new InheritableThreadLocal<>();

    private Driver() {
        // Prevent instantiation
    }

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browserType = ConfigurationReader.getProperty("browser");
            try {
                switch (browserType) {
                    case "chrome":
                        //WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        break;
                    case "firefox":
                        //WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        break;
                    default:
                        throw new RuntimeException("Invalid browser type: " + browserType);
                }
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            } catch (Exception e) {
                logger.error("Error creating driver instance", e);
                throw new RuntimeException("Error creating driver instance", e);
            }
        }
        return driverPool.get();
    }

    public static Actions getActions() {
        if (actionPool.get() == null) {
            actionPool.set(new Actions(getDriver()));
        }
        return actionPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            try {
                driverPool.get().quit();
            } catch (Exception e) {
                logger.error("Error closing driver instance", e);
            } finally {
                driverPool.remove();
                actionPool.remove();
            }
        }
    }

    public static String getBrowserType() {
        return ConfigurationReader.getProperty("browser");
    }

    public static void resetDriver() {
        closeDriver();
        driverPool.set(null);
        actionPool.set(null);
    }
}
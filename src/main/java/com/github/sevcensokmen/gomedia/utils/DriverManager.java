package com.github.sevcensokmen.gomedia.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class DriverManager {
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 50;

    private static DriverManager instance = null;

    private WebDriver driver;
    private WebDriverWait waitDriver;

    public static FileInputStream fis;
    public static Logger log = Logger.getLogger("devpinoyLogger");

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public void init() {
        Properties config = new Properties();

        FileInputStream fis = null;
        String osName;
        String browser;
        String geckoDriverDirectory = "";
        String chromeDriverDirectory = "";

        try {
            fis = new FileInputStream(Constant.CONFIG_PROPERTIES_DIRECTORY);
            config.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        browser = config.getProperty("browser");
        osName = config.getProperty("OS");

        if (osName.equals("Windows")) {
            geckoDriverDirectory = Constant.GECKO_DRIVER_DIRECTORY_WINDOWS;
            chromeDriverDirectory = Constant.CHROME_DRIVER_DIRECTORY_WINDOWS;
        } else if (osName.equals("Mac")) {
            geckoDriverDirectory = Constant.GECKO_DRIVER_DIRECTORY;
            chromeDriverDirectory = Constant.CHROME_DRIVER_DIRECTORY;
        } else {
            throw new IllegalArgumentException("OS not supported:" + osName);
        }

        if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", geckoDriverDirectory);
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromeDriverDirectory);
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported:" + browser);
        }

        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);

        waitDriver = new WebDriverWait(driver, 10);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeAndQuit() {
        driver.close();
        driver.quit();
    }

}

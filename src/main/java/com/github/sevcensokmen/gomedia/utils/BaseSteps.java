package com.github.sevcensokmen.gomedia.utils;

import org.openqa.selenium.WebDriver;

public class BaseSteps {


    private String url = "https://skyronic.github.io/vue-spa/#/";

    public void init() {
        DriverManager.getInstance().init();
    }

    public void cleanup() {
        DriverManager.getInstance().closeAndQuit();
    }

    public WebDriver getDriver() {
        return DriverManager.getInstance().getDriver();
    }

    public void invokeNavigateToPage(String url) {
        DriverManager.getInstance().getDriver().get(url);

    }

    public String getUrl() {
        return url;
    }
}


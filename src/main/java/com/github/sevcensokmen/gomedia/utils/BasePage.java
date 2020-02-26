package com.github.sevcensokmen.gomedia.utils;

import com.github.sevcensokmen.gomedia.pages.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class BasePage {

    protected WebDriver driver = null;
    protected TopMenu toolBar;


    public BasePage() {
        this.toolBar = new TopMenu();
        this.driver = DriverManager.getInstance().getDriver();
    }


    public boolean isElementPresent(By by) {

        try {

            driver.findElement(by);
            return true;

        } catch (NoSuchElementException e) {

            return false;

        }

    }


}

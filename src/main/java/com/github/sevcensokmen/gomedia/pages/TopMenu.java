package com.github.sevcensokmen.gomedia.pages;

import com.github.sevcensokmen.gomedia.utils.DriverManager;
import org.openqa.selenium.By;

public class TopMenu {

    private final String KEY_GO_TO_HOME = "//a[@class='router-link-active']";
    private final String KEY_GO_TO_CARTS = "div.header > div > a:nth-child(2)";
    private final String KEY_GO_TO_CARTS_VALUE = "div.header > div > a:nth-child(2)";

    private int cartNumberAttr;

    public int getCartNumberAttr() {
        return cartNumberAttr;
    }

    public void setCartNumberAttr(int cartNumberAttr) {
        this.cartNumberAttr = cartNumberAttr;
    }

    public void gotoHome() {

        DriverManager.getInstance().getDriver().findElement(By.xpath(KEY_GO_TO_HOME)).click();

    }

    public void gotoCarts() {

        DriverManager.getInstance().getDriver().findElement(By.cssSelector(KEY_GO_TO_CARTS)).click();

    }


    public int getCartValueFromPage() {
        String cartValue = DriverManager.getInstance().getDriver().findElement(By.cssSelector(KEY_GO_TO_CARTS_VALUE)).getText();
        int val = cartValue.indexOf("(");
        int lenght = cartValue.length();
        int value = Integer.parseInt(cartValue.substring(val + 1, lenght - 1));
        return value;
    }


}

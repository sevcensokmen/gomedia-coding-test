package com.github.sevcensokmen.gomedia.pages;

import com.github.sevcensokmen.gomedia.utils.BasePage;
import com.github.sevcensokmen.gomedia.utils.DriverManager;
import com.github.sevcensokmen.gomedia.utils.Product;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ProductDetailsPage extends BasePage {

    //region 'elements'
    private final String  KEY_ADD_TO_CART_BUTTON = "add-button";
    private final String  KEY_IN_STOCK = "inventory";
    private final String  KEY_PRODUCT_NAME ="product-title";

    private String productName;
    private int inStockAttr = 0;


public ProductDetailsPage(String productName) {
    this.productName = productName;
}

    public String getProductName() {
        return productName;
    }

    public int getInStockFromProductDetailPage() {

        boolean inStockBoolean = false;
        String valueOfStock;
        valueOfStock = driver.findElement(By.className(KEY_IN_STOCK)).getText();
        int i = valueOfStock.indexOf(": ");
        int lenght = valueOfStock.length();
        valueOfStock = valueOfStock.substring(i + 2, lenght);
        return Integer.parseInt(valueOfStock);


    }

    public boolean addToCartButtonEnable() {

        boolean addToCartButton = false;
        if (isElementPresent(By.className(KEY_ADD_TO_CART_BUTTON))) {
            if (driver.findElement(By.className(KEY_ADD_TO_CART_BUTTON)).isEnabled())
                addToCartButton = true;
            else
                addToCartButton = false;

        }
        return addToCartButton;
    }


    public boolean addToCartButtonVisible() {

        boolean addToCartButton = false;
        if (isElementPresent(By.className(KEY_ADD_TO_CART_BUTTON))) {
            if (driver.findElement(By.className(KEY_ADD_TO_CART_BUTTON)).getText().equals("Add to cart"))
                            addToCartButton = true;
                    else
                            addToCartButton = false;

        }
        return addToCartButton;
    }

    public boolean outOfStockButtonVisible() {

        boolean addToCartButton = false;
        if (isElementPresent(By.className(KEY_ADD_TO_CART_BUTTON))) {
            if (driver.findElement(By.className(KEY_ADD_TO_CART_BUTTON)).getText().equals("Out Of Stock"))
                addToCartButton = true;
            else
                addToCartButton = false;

        }
        return addToCartButton;
    }
    public boolean outOfStockButtonEnabled() {

        boolean addToCartButton = false;
        if (isElementPresent(By.className(KEY_ADD_TO_CART_BUTTON))) {
            if (!driver.findElement(By.className(KEY_ADD_TO_CART_BUTTON)).isEnabled())
                addToCartButton = true;
            else
                addToCartButton = false;

        }
        return addToCartButton;
    }


    public boolean productNameVisible(){
        boolean productNameVisible = false;
        if(isElementPresent(By.className(KEY_PRODUCT_NAME)))
            if (driver.findElement(By.className(KEY_PRODUCT_NAME)).getText().equals(getProductName())) {
                productNameVisible = true;
            }
            else
                productNameVisible = false;

        return productNameVisible;

    }


    public boolean inStockVisible() {
        boolean inStockVisible = false;
        if (isElementPresent(By.className(KEY_IN_STOCK)))

            inStockVisible = true;

        return inStockVisible;

    }

    public CartPage addToCartButtonClick(){

        driver.findElement(By.className(KEY_ADD_TO_CART_BUTTON)).click();
        return new CartPage();
    }

    public int getToolBarCartValueFromPage(){
        return toolBar.getCartValueFromPage();

    }

    public void setToolBarCartAttr(){

        toolBar.setCartNumberAttr( getToolBarCartValueFromPage());

    }

    public int getToolBarCartAttr(){
        return toolBar.getCartNumberAttr();

    }
    public void setInStockAttr(){

        this.inStockAttr = getInStockFromProductDetailPage();

    }

    public int getInStockAttr(){
        return inStockAttr;
    }




}

package com.github.sevcensokmen.gomedia.pages;

import com.github.sevcensokmen.gomedia.utils.BasePage;
import com.github.sevcensokmen.gomedia.utils.DriverManager;
import com.github.sevcensokmen.gomedia.utils.Product;
import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductListPage extends BasePage {

    private final String  KEY_LIST_PRODUCT = "//div[@class='product-container']//div[@class='product']";
    private final String  KEY_PRODUCT_NAME = "title";
    private final String  KEY_PRODUCT_PRICE = "price";

    private String name;


    public ArrayList<Product> getParameterItemsList(DataTable dt) {

        List<Product> productExpectedlist = new ArrayList<Product>();
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            productExpectedlist.add(new Product(list.get(i).get("Product Name"),list.get(i).get("Price")));
        }
        return (ArrayList<Product>) productExpectedlist;
    }


    public List<Product> getItemsList() {

        List<Product> productActuallist = new ArrayList<Product>();
        List<WebElement> rowResult = driver.findElements(By.xpath(KEY_LIST_PRODUCT));
        for (WebElement result : rowResult) {

            productActuallist.add(new Product(result.findElement(By.className(KEY_PRODUCT_NAME)).getText(),
                    result.findElement(By.className(KEY_PRODUCT_PRICE)).getText()));
        }
        return productActuallist;
    }


    public ProductDetailsPage gotoProductDetails(String productName) {

        WebElement productElement = driver.findElement(By.linkText(productName));
        productElement.click();
        return new ProductDetailsPage(productName);

    }





}

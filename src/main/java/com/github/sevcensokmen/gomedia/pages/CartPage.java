package com.github.sevcensokmen.gomedia.pages;

import com.github.sevcensokmen.gomedia.utils.BasePage;
import com.github.sevcensokmen.gomedia.utils.DriverManager;
import com.github.sevcensokmen.gomedia.utils.Product;
import com.github.sevcensokmen.gomedia.utils.ProductInCart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class CartPage extends BasePage {


    Set<ProductInCart> productListExpectedInCart = new HashSet<>();
    Map<String,ProductInCart> productListExpectedInCart2 = new HashMap<>();
    private final String KEY_ROW_RESULT = "//div[@class='checkout-table']//tr";
    private final String KEY_CHECK_OUT_BUTTON = "//div[@class='checkout-table']//tr";



    public CartPage() {

        driver = DriverManager.getInstance().getDriver();

    }

    public void clickCheckOut() {

        driver.findElement(By.cssSelector(KEY_CHECK_OUT_BUTTON)).click();

    }

    public void getActualList() {


        List<WebElement> rowResult = driver.findElements(By.xpath(KEY_ROW_RESULT));

        List<ProductInCart> productListActualInCart = new ArrayList<ProductInCart>();

        for (WebElement result : rowResult) {
            List<WebElement> rowCol = driver.findElements(By.xpath("//td"));


            productListActualInCart.add(new ProductInCart(rowCol.get(0).getText(),
                    Double.parseDouble(rowCol.get(1).getText()),
                    Integer.parseInt(rowCol.get(2).getText()),
                    Double.parseDouble(rowCol.get(3).getText())));
        }


    }

    public void addProductListInCart(Product p){


        if(productListExpectedInCart2.containsKey(p.getName())){
            int perUnit = productListExpectedInCart2.get(p.getName()).getPerUnit();
            perUnit = perUnit +1;
            productListExpectedInCart2.get(p.getName()).setPerUnit(perUnit);

        }else{
            String price = p.getPrice();
            price = price.substring(2,price.length());
            productListExpectedInCart2.put(p.getName(), new ProductInCart(p.getName(), Double.parseDouble(price),
                   1, Double.parseDouble(price)));


        }

    }

}

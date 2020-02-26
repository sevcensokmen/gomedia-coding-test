package com.github.sevcensokmen.gomedia.steps;


import com.github.sevcensokmen.gomedia.utils.BaseSteps;
import com.github.sevcensokmen.gomedia.pages.CartPage;
import com.github.sevcensokmen.gomedia.pages.ProductDetailsPage;
import com.github.sevcensokmen.gomedia.pages.ProductListPage;
import com.github.sevcensokmen.gomedia.utils.DriverManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPageSteps extends BaseSteps {

    ProductListPage productList = new ProductListPage();
    ProductDetailsPage productDetailsPage = null;
    CartPage cartPage = null;


    @Given("^User navigates to url$")
    public void user_navigates_to_url() throws Throwable {
        invokeNavigateToPage(getUrl());
    }

    @When("^User clicks the product \"([^\"]*)\"$")
    public void user_clicks_the_product(String productName) throws Throwable {
        productDetailsPage = productList.gotoProductDetails(productName);
    }

    @Then("^The add to cart button should be visible$")
    public void the_add_to_cart_button_should_be_visible() throws Throwable {
        Assert.assertTrue("The add to cart button should be visible", productDetailsPage.addToCartButtonVisible());
    }

    @Then("^Product name should be visible$")
    public void product_name_should_be_visible() throws Throwable {
        Assert.assertTrue("product_name_should_be_visible", productDetailsPage.productNameVisible());
    }


    @Then("^The stock information should be shown$")
    public void the_stock_information_should_be_shown() throws Throwable {
        Assert.assertTrue("the_stock_information_should_be_shown", productDetailsPage.inStockVisible());
    }

    @When("^User clicks the product \"([^\"]*)\" when it is in stock$")
    public void user_clicks_the_product_when_it_is_in_stock(String productName) throws Throwable {
        productDetailsPage = productList.gotoProductDetails(productName);
    }

    @Then("^The stock in \"([^\"]*)\" should be visible$")
    public void the_stock_in_should_be_visible(String stockin) throws Throwable {
        int stockInPage = productDetailsPage.getInStockFromProductDetailPage();

    }

    @Then("^The add to cart button should be disabled$")
    public void the_add_to_cart_button_should_be_disabled() throws Throwable {
        Assert.assertEquals("The add to cart button should be disabled", productDetailsPage.outOfStockButtonEnabled());

    }

    @Then("^The add to cart button should be written out of Stock$")
    public void the_add_to_cart_button_should_be_written_out_of_Stock() throws Throwable {
        Assert.assertEquals("The add to cart button should be written out of Stock", productDetailsPage.outOfStockButtonVisible());
    }


    @And("^User clicks add to cart button$")
    public void user_clicks_add_to_cart_button() throws Throwable {

        productDetailsPage.setToolBarCartAttr();
        productDetailsPage.setInStockAttr();
        productDetailsPage.addToCartButtonClick();

    }

    @Then("^The cart number should be increased$")
    public void the_cart_number_should_be_increased() throws Throwable {
        int toolbarCartAfterClick = productDetailsPage.getToolBarCartValueFromPage();

        Assert.assertTrue("The cart number should be increased", productDetailsPage.getToolBarCartAttr() + 1 == toolbarCartAfterClick);


    }

    @Then("^The stock information should be updated$")
    public void the_stock_information_should_be_updated() throws Throwable {

        int inStockAfterClick = productDetailsPage.getInStockFromProductDetailPage();
        Assert.assertTrue("The stock information should be updated.", productDetailsPage.getInStockAttr() == inStockAfterClick + 1);

    }

    @Then("^User clicks the product \"([^\"]*)\" when it is out of stock \"([^\"]*)\"$")
    public void user_clicks_the_product_when_it_is_out_of_stock(String productName, String stockInParam) throws Throwable {
        productDetailsPage = productList.gotoProductDetails(productName);
        int inStock = Integer.parseInt(stockInParam);
        for (int a = 0; a < inStock; a++) {

            productDetailsPage.addToCartButtonClick();
            productDetailsPage.setToolBarCartAttr();
            productDetailsPage.setInStockAttr();

        }
    }

    @Then("^The add to cart button should be enabled$")
    public void the_add_to_cart_button_should_be_enabled() throws Throwable {

        Assert.assertTrue("The add to cart button should be disabled", productDetailsPage.outOfStockButtonEnabled());

    }


    @Then("^In stock value is equal to zero$")
    public void in_stock_value_is_equal_to_zero() throws Throwable {
        Assert.assertTrue("n stock value is equal to zero", productDetailsPage.getInStockFromProductDetailPage() == 0);

    }


}

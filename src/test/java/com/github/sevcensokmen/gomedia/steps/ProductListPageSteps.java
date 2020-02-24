package com.github.sevcensokmen.gomedia.steps;

import com.github.sevcensokmen.gomedia.utils.BaseSteps;
import com.github.sevcensokmen.gomedia.pages.CartPage;
import com.github.sevcensokmen.gomedia.pages.ProductDetailsPage;
import com.github.sevcensokmen.gomedia.pages.ProductListPage;
import com.github.sevcensokmen.gomedia.utils.BaseSteps;
import com.github.sevcensokmen.gomedia.utils.DriverManager;
import com.github.sevcensokmen.gomedia.utils.Product;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductListPageSteps extends BaseSteps {

    ProductListPage productList = null;

    @When("^I navigate to url$")
    public void i_navigate_to_url() throws Throwable {
        productList = PageFactory.initElements(DriverManager.getInstance().getDriver(), ProductListPage.class);
        invokeNavigateToPage(getUrl());
    }

    @Then("^Items should be displayed$")
    public void items_should_be_displayed(DataTable dt) throws Throwable {
        List<Product> productActuallist = new ArrayList<Product>();
        List<Product> productExpectedlist = new ArrayList<Product>();
        productExpectedlist = productList.getParameterItemsList(dt);
        productActuallist = productList.getItemsList();
        Assert.assertEquals("When the page loads, parametric items should be displayed", productExpectedlist, productActuallist);

    }
}

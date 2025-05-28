package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchSteps {

    private WebDriver driver;
    private int countOfMenuItems = 0;
    private int countOfSearchResultItems = 0;

    public SearchSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^Open page: \"([^\"]*)\"$")
    public void openPage(String pageValue) throws Throwable {
        driver.get("https://demowebshop.tricentis.com/" + pageValue);
    }

    @Given("^Open page home page$")
    public void openHomePage() throws Throwable {
        driver.get("https://demowebshop.tricentis.com/");
    }

    @Then("^Find search field$")
    public void findSearchField() throws Throwable {
        assertTrue(driver.findElement(By.cssSelector(".search-box-text#small-searchterms")).isDisplayed());
    }

    @And("^Count elements in the item menu$")
    public void countElementsInTheItemMenu() throws Throwable {
        countOfMenuItems = driver.findElements(By.className("ui-menu-item")).size();
    }
    @And("^Count elements in the search result page$")
    public void countElementsInTheItemSearchResultPage() throws Throwable {
        countOfSearchResultItems = driver.findElements(By.cssSelector(".search-results > .product-grid > .item-box")).size();
    }

    @When("^Type \"([^\"]*)\" in the search Text-Field$")
    public void typeValueInTheSearchTextField(String searchValue) throws Throwable {
        driver.findElement(By.cssSelector(".search-box-text#small-searchterms")).sendKeys(searchValue);
    }

    @When("^Press search button$")
    public void pressSearchButton() throws Throwable {
        driver.findElement(By.cssSelector(".search-box-button")).click();
    }

    @Then("^I see founded items with name \"([^\"]*)\"$")
    public void iSeeFoundedItemsWithName(String searchValue) throws Throwable {
        List<WebElement> listOfItems = driver.findElements(By.cssSelector(".search-results > .product-grid > .item-box"));
        for (WebElement item : listOfItems) {
            assertTrue(driver.findElement(By.cssSelector(".details")).getText().contains(searchValue));
        }
    }
    @Then("^Compare count results$")
    public void compareCountResult() throws Throwable {
        assertEquals(countOfSearchResultItems, countOfMenuItems);
    }

}

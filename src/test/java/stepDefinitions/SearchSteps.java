package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchSteps {

    private WebDriver driver;
    private int countOfMenuItems = 0;
    private int countOfSearchResultItems = 0;
    List<String> listToSort = new ArrayList<>();

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

    @When("^Type \"([^\"]*)\" in the search Text-Field$")
    public void typeValueInTheSearchTextField(String searchValue) throws Throwable {
        driver.findElement(By.cssSelector(".search-box-text#small-searchterms")).sendKeys(searchValue);
    }

    @When("^Press search button$")
    public void pressSearchButton() throws Throwable {
        assertTrue(driver.findElement(By.cssSelector(".search-box-button")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".search-box-button")).isEnabled());
        driver.findElement(By.cssSelector(".search-box-button")).click();
    }

    @And("^Count elements in the item menu$")
    public void countElementsInTheItemMenu() throws Throwable {
        countOfMenuItems = driver.findElements(By.className("ui-menu-item")).size();
    }

    @And("^Count elements in the search result page$")
    public void countElementsInTheItemSearchResultPage() throws Throwable {
        countOfSearchResultItems = driver.findElements(By.cssSelector(".search-results > .product-grid > .item-box")).size();
    }

    @And("^Check checkbox - Advanced search$")
    public void checkCheckboxAdvancedSearch() throws Throwable {
        assertTrue(driver.findElement(By.cssSelector("#As")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("#As")).isEnabled());
        driver.findElement(By.cssSelector("#As")).click();
    }

    @And("^Check checkbox - Search in product description$")
    public void checkCheckboxSearchInProductDescription() throws Throwable {
        assertTrue(driver.findElement(By.cssSelector("#Sid")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("#Sid")).isEnabled());
        driver.findElement(By.cssSelector("#Sid")).click();
    }

    @And("^Press search button in search box$")
    public void pressSearchButtonInSearchBox() throws Throwable {
        assertTrue(driver.findElement(By.cssSelector(".buttons > .search-button")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".buttons > .search-button")).isEnabled());
        driver.findElement(By.cssSelector(".buttons > .search-button")).click();
    }

    @And("^In Sort By option choose Name: A to Z$")
    public void inSortByOptionChooseNameAToZ() throws Throwable {
        WebElement sortByDropdown = driver.findElement(By.id("products-orderby"));
        assertTrue(sortByDropdown.isEnabled());
        assertTrue(sortByDropdown.isDisplayed());
        Select dropdown = new Select(sortByDropdown);

        dropdown.selectByValue("https://demowebshop.tricentis.com/search?q=and&as=true&cid=0&isc=false&mid=0&pf=&pt=&sid=true&orderby=5");
    }

    @Then("^Find search field$")
    public void findSearchField() throws Throwable {
        assertTrue(driver.findElement(By.cssSelector(".search-box-text#small-searchterms")).isDisplayed());
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

    @Then("^Check that items are in alphabetical order$")
    public void checkThatItemsAreInAlphabeticOrder() throws Throwable {
        while (true) {
            List<WebElement> list = driver.findElements(By.cssSelector(".product-title"));

            for (WebElement title : list) {
                listToSort.add(title.getText());
            }

            List<WebElement> nextPage = driver.findElements(By.cssSelector(".next-page"));
            if (!nextPage.isEmpty() && nextPage.get(0).isDisplayed()) {
                nextPage.get(0).click();
            } else {
                break;
            }
        }
        List<String> expectedList = listToSort;
        Collections.sort(listToSort);
        assertEquals(expectedList, listToSort);
    }

}

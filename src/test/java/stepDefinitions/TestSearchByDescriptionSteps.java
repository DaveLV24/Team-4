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

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class TestSearchByDescriptionSteps {
    private WebDriver driver;

    public TestSearchByDescriptionSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() {
        driver.get("https://demowebshop.tricentis.com/");
    }

    @When("^I enter the sample: \"([^\"]*)\"$")
    public void iEnterSample(String sample) {
        driver.findElement(By.xpath("//*[@id='small-searchterms']")).clear();
        driver.findElement(By.xpath("//*[@id='small-searchterms']")).sendKeys(new String(sample));
    }

    @When("^I enter the values:$")
    public void iEnterTheValues(Map<String, String> valuesToEnter) {
        driver.findElement(By.xpath("//*[@id='small-searchterms']")).clear();
        driver.findElement(By.xpath("//*[@id='small-searchterms']")).sendKeys(valuesToEnter.get("keyword"));
    }

    @Then("^I click the search button$")
    public void iClickTheSearchButton() {
        driver.findElement(By.xpath("//form//input[2]")).click();
        assertTrue(driver.findElement(By.className("search-input")).isDisplayed());
    }

    @Then("^I choose Advanced search$")
    public void iChooseAdvancedSearch() {
        driver.findElement(By.xpath("//*[@id='As']")).click();
        assertTrue(driver.findElement(By.className("search-input")).isDisplayed());
    }

    @Then("^I choose Search In product descriptions$")
    public void iChooseSearchInProductDescriptions() {
        driver.findElement(By.xpath("//*[@id='Sid']")).click();
    }

    @Then("^I click the search button in a search block$")
    public void iClickTheSearchButtonInASearchBlock() {
        driver.findElement(By.xpath("//div[@class='search-input']//form/div[@class='buttons']/input")).click();
    }

    @Then("^Click on first product which is displayed$")
    public void clickOnFirstProductWhichIsDisplayed() {
        List<WebElement> product = driver.findElements(By.className("product-title"));
        product.get(0).click();
        String text = driver.findElement(By.className("full-description")).getText();
        assertTrue("Expected text to contain 'BrightView'", text.contains("BrightView"));
    }
    @Then("^In Advanced search block select a parent category Electronics$")
    public void inAdvancedSearchBlockSelectAParentCategoryElectronics() {
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='Cid']")));
        dropdown.selectByValue("value7");
    //        dropdown.selectByVisibleText("Electronics");
        }
    @Then("^In Advanced search block choose the box Automatically search subcategories$")
    public void inAdvancedSearchBlockChooseTheBoxAutomaticallySearchSubcategories() {
        driver.findElement(By.xpath("//*[@id='Isc']")).click();
    }
    @Then("^In advanced search block select a subcategory Electronics Cell phones$")
    public void inAdvancedSearchBlockSelectASubcategoryElectronicsCellPhones() {
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='Cid']")));
        dropdown.selectByValue("value9");
    //        dropdown.selectByVisibleText("Electronics >> Cell phones");
        }

    @And("^Products with sample \"([^\"]*)\" in the title should be displayed$")
    public void productsWithSampleWordInTheTitleShouldBeDisplayed(String keyword) {
        List<WebElement> productTitles = driver.findElements(By.className("product-title"));
        assertTrue("No products found.", productTitles.size() > 0);
        for (WebElement title : productTitles) {
            String titleText = title.getText().toLowerCase();
            assertTrue("Title does not contain sample word: " + titleText, titleText.contains(keyword.toLowerCase()));
        }
    }
}
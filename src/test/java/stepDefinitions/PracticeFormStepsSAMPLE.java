package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PracticeFormStepsSAMPLE {

    private WebDriver driver;
    private String itemExpectedUrl;

    public PracticeFormStepsSAMPLE() {this.driver = Hooks.driver;}

    @Given ("I navigate to the \"Book\" section page")
    public void INavigateToTheBookSectionPage() {
        driver.get("https://demowebshop.tricentis.com/books");
    }
    @Given ("I navigate to subsection \"Desktop\" page")
    public void INavigateToTheDesktopSubsectionPage() {
        driver.get("https://demowebshop.tricentis.com/desktops");
    }

    @When("I open a {int}")
    public void i_open_a_product(int ind) {
        String xpath = String.format("(//div[@class='item-box'])[%d]//a", ind);
        WebElement actualProduct = driver.findElement(By.xpath(xpath));
       itemExpectedUrl = actualProduct.getAttribute("href");
       actualProduct.click();
    }
    @And("I am redirected to the product page")
    public void iAmRedirectedToTheProductPage(){
        assertEquals(itemExpectedUrl, driver.getCurrentUrl());
       }

    @Then("I can see all required information about this product")
    public void iSeeAllRequiredInformation() {
        try{
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product-name']")).isDisplayed());
        } catch (Exception e) { System.out.println("This product " + driver.findElement(By.xpath("//div[@class='product-name']")).getText() + "has no name");
        }
        try {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='short-description']")).isDisplayed());
        } catch (Exception e){
            System.out.println("This product " + driver.findElement(By.xpath("//div[@class='product-name']")).getText() + "has no description");
        }
        try {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product-reviews-overview']")).isDisplayed());
        } catch (Exception e) {
            System.out.println("This product " + driver.findElement(By.xpath("//div[@class='product-name']")).getText() + "has no review");
          }
        try {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product-price']")).isDisplayed());
        } catch (Exception e) {
            System.out.println("This product " + driver.findElement(By.xpath("//div[@class='product-name']")).getText() + "has no price");
        }
        try {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='full-description']")).isDisplayed());
        } catch (Exception e) {
            System.out.println("This product " + driver.findElement(By.xpath("//div[@class='product-name']")).getText() + " has no specification");
        }
    }
    @Then("I can see \"Add to compare list\" button is displayed")
    public void iSeeAddToCompareListButtonIsDisplayed() {
        try {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='compare-products']")).isDisplayed());
        } catch (Exception e) {
            System.out.println("For this product  " + driver.findElement(By.xpath("//div[@class='product-name']")).getText() + "\" Add to compare list\" button is not displayed");
        }
    }
    @And("I can see \"Add to Cart\" button is displayed")
    public void iSeeAddToCartButtonIsDisplayed() {
        try {
            Assert.assertTrue(driver.findElement(By.cssSelector(".button-1.add-to-cart-button")).isDisplayed());
        } catch (Exception e) {
            System.out.println("For this product  " + driver.findElement(By.xpath("//div[@class='product-name']")).getText() + "\" Add to Cart \" button is not displayed");
        }
    }
    @And("I can see \"Add to Wish List\" button is displayed")
    public void iSeeAddToWishListButtonIsDisplayed() {
        try {
            Assert.assertTrue(driver.findElement(By.cssSelector(".button-2.add-to-wishlist-button")).isDisplayed());
        } catch (Exception e) {
            System.out.println("For this product  " + driver.findElement(By.xpath("//div[@class='product-name']")).getText() + "\" Add to Wishlist \" button is not displayed");
        }
    }
     @And("I can see \"Available options\" attributes are displayed")
    public void iSeeAvaliableOptionsAttributesAreDisplayed() {
        try {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"attributes\"]")).isDisplayed());
        } catch (Exception e) {
            System.out.println("For this product: " + driver.findElement(By.xpath("//div[@class='product-name']")).getText() + " " + " Available option attributes are  not displayed");
        }
    }

}
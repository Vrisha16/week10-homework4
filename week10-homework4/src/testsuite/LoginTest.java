package testsuite;
/*Create the package ‘testsuite’ and create the following
class inside the ‘testsuite’ package.

        1. LoginTest*/

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseurl = "https://www.saucedemo.com/";

    @Before
    public void setup() {openBrowser(baseurl);}
    @Test
    public void test1()  throws InterruptedException {
        //enter username and id
        WebElement usernameid = driver.findElement(By.id("Username"));
        usernameid.sendKeys(("standard_user"));
        WebElement passwordkey = driver.findElement(By.id("password"));
        passwordkey.sendKeys("secret_sauce");
        WebElement loginLink = driver.findElement(By.className("login_button"));
        loginLink.click();
        WebElement productsText = driver.findElement(By.className("product_label"));
        String actualMessage = productsText.getText();
        String expectedMessage = "Products";
        Assert.assertEquals("Verifying WelcomeMessage",actualMessage, expectedMessage);
    }

    /* Write down the following test into ‘LoginTest’ class

1. userSholdLoginSuccessfullyWithValid
        Credentials

        * Enter “standard_user” username
        * Enter “secret_sauce” password
        * Click on ‘LOGIN’ button
        * Verify the text “PRODUCTS”*/

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Open the URL
        driver.get("https://www.saucedemo.com/");

        // Enter username and password
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Click on LOGIN button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify the text "PRODUCTS" on the page
        WebElement productsText = driver.findElement(By.className("product_label"));
        String actualText = productsText.getText();
        String expectedText = "Products";
        Assert.assertEquals(actualText, expectedText);
    }


    @Test
    public void verifyThatSixProductsAreDisplayedOnPage () {
        // Open the URL
        driver.get("https://www.saucedemo.com/");

        // Enter username and password
        WebElement usernameid = driver.findElement(By.id("usernameid"));
        usernameid.sendKeys("standard_user");
        WebElement passwordkey = driver.findElement(By.id("passwordkey"));
        passwordkey.sendKeys("secret_sauce");

        // Click on LOGIN button
        WebElement loginButton = driver.findElement(By.id("id :login-button"));
        loginButton.click();

        // Verify the text "PRODUCTS" on the page
        WebElement productsText = driver.findElement(By.className("product_label"));
        String actualText = productsText.getText();
        String expectedText = "Products";
        Assert.assertEquals(actualText, expectedText);

        // Verify that six products are displayed on the page
        List<WebElement> productItems = driver.findElements(By.className("inventory_item"));
        int actualProductCount = productItems.size();
        int expectedProductCount = 6;
        Assert.assertEquals(actualProductCount, expectedProductCount);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }


    }























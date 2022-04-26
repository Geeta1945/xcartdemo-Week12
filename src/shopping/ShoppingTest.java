package shopping;

import homepage.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class ShoppingTest extends Utility {
    String BaseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(BaseUrl);
    }
    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForOllieTheAppControlled() throws InterruptedException{

//        1.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='header-area']/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/span[1]"));

//        1.2 Mouse hover on the “Bestsellers”  link and click
        mouseHoverAndClick(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]/span[1]"));

//        1.3 Verify the text “Bestsellers”
        String expectedMessage ="Bestsellers";
        String actualMessage = getTextFromElement(By.id("page-title"));
        Assert.assertEquals(actualMessage,expectedMessage);

//        1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));

        //select “Name A-Z”
        mouseHoverAndClick(By.partialLinkText("Name A - Z"));
        Thread.sleep(3000);

//        1.5 Click on “Add to cart” button of the product “Ollie - The App Controlled Robot”
        mouseHoverToElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[2]/div[4]/div[1]/button[1]/span[1]"));
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[2]/div[4]/div[1]/button[1]/span[1]"));

//        1.6 Verify the message “Product has been added to your cart” display in  green bar
        String expectedMessage2 ="Product has been added to your cart";
        String actualMessage2 = getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        Assert.assertEquals(actualMessage2,expectedMessage2);
//
//        1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//a[@class='close']"));

//        1.8 Click on “Your cart” icon and Click on “View cart” button
        Thread.sleep(3000);
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));

//        1.9 Verify the text “Your shopping cart - 1 item”
        String expectedMessage3 ="Your shopping cart - 1 item";
        String actualMessage3 = getTextFromElement(By.id("page-title"));
        Assert.assertEquals(actualMessage3,expectedMessage3);

//        1.10 Verify the Subtotal $99.00  (Subtotal: $299.00)
        Thread.sleep(1000);
        String expectedMessage4 ="Subtotal: $299.00";
        String actualMessage4 = getTextFromElement(By.xpath("//ul[@class='sums']//li[@class='subtotal']"));
        Assert.assertEquals(actualMessage4,expectedMessage4);

//        1.11 Verify the total $106.23 ($309.73)
        String expectedMessage5 ="$309.73";
        String actualMessage5 = getTextFromElement(By.xpath("//li[@class='total']"));
        Assert.assertEquals(actualMessage5,expectedMessage5);

//        1.12 Click on “Go to checkout” button
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[5]/button[1]"));

//        1.13 Verify the text “Log in to your account”
        String expectedMessage6 ="Log in to your account";
        String actualMessage6 = getTextFromElement(By.xpath("//h3[contains(text(),'Log in to your account')]"));
        Assert.assertEquals(actualMessage6,expectedMessage6);

//        1.14 Enter Email address
        sendTextToElement(By.id("email"),"rlobo3@gamil.com");

//        1.15 Click on “Continue” Button
        clickOnElement(By.xpath("//tbody/tr[2]/td[1]/button[1]"));

//        1.16 Verify the text “Secure Checkout”
        String expectedMessage7 ="Secure Checkout";
        String actualMessage7 = getTextFromElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/h1[1]"));
        Assert.assertEquals(actualMessage7,expectedMessage7);
        Thread.sleep(3000);

//        1.17 Fill all the mandatory fields
        //Enter first name
        sendTextToElement(By.id("shippingaddress-firstname"), "Ron");

        // Enter last name
        sendTextToElement(By.id("shippingaddress-lastname"), "Jira");

        // Enter Address
        sendTextToElement(By.id("shippingaddress-street"), "105 london street");
        Thread.sleep(1000);

        // Enter State
        sendTextToElement(By.id("shippingaddress-custom-state"), "Middlesex");

        // Zip C
        Thread.sleep(1000);
        clearValue(By.xpath("//input[@id='shippingaddress-zipcode']"));
        sendTextToElement(By.xpath("//input[@id='shippingaddress-zipcode']"), "Ub10 10BU");

        //phone number
        sendTextToElement(By.id("shippingaddress-phone"),"07412348678");
        Thread.sleep(2000);


        Thread.sleep(3000);

//        1.18 Check the check box “Create an account for later use”
        clickOnElement(By.id("create_profile"));

//        1.19 Enter the password
        sendTextToElement(By.id("password"),"Rlobo1993?");

//        1.20 Select the Delivery Method to “Local Shipping”
        clickOnElement(By.id("method130"));

//        1.21 Select Payment Method “COD”
        clickOnElement(By.id("pmethod6"));

//        1.22 Verify the total $99.00 ($299.00)
        Thread.sleep(2000);
        String expectedMessage8 ="$299.00";
        String actualMessage8 = getTextFromElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]"));
        Assert.assertEquals(actualMessage8,expectedMessage8);

//        1.23 Click on “Place Order” Button
        mouseHoverToElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[4]/button[1]"));
        clickOnElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[4]/button[1]"));


//        1.24 Verify the text “Thank you for your order”
        String expectedMessage9 ="Thank you for your order";
        String actualMessage9 = getTextFromElement(By.id("page-title"));
        Assert.assertEquals(actualMessage9,expectedMessage9);

    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {

//    1.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='header-area']/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/span[1]"));

//    1.2 Mouse hover on the “Bestseller”  link and click
        mouseHoverAndClick(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]/span[1]"));

//    1.3 Verify the text “Bestsellers”
        String expectedMessage ="Bestsellers";
        String actualMessage = getTextFromElement(By.id("page-title"));
        Assert.assertEquals(actualMessage,expectedMessage);

//    1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));

        //select “Name A-Z”
        mouseHoverAndClick(By.partialLinkText("Name A - Z"));
        Thread.sleep(3000);

//    1.5 Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”
        mouseHoverToElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[9]/div[1]/div[2]/div[4]/div[1]/button[1]/span[1]"));
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[9]/div[1]/div[2]/div[4]/div[1]/button[1]/span[1]"));

//    1.6 Verify the message “Product has been added to your cart” display in  green bar
        String expectedMessage2 ="Product has been added to your cart";
        String actualMessage2 = getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        Assert.assertEquals(actualMessage2,expectedMessage2);

//    1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//a[@class='close']"));

//    1.8 Click on “Your cart” icon and Click on “View cart” button
        Thread.sleep(3000);
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));

//    1.9 Verify the text “Your shopping cart - 1 item”
        String expectedMessage3 ="Your shopping cart - 1 item";
        String actualMessage3 = getTextFromElement(By.id("page-title"));
        Assert.assertEquals(actualMessage3,expectedMessage3);
        Thread.sleep(2000);

//    1.10 Click on “Empty your cart” link
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));
        Thread.sleep(1000);


//    1.11 Verify the text “Are you sure you want to clear your cart?” on alert
        Alert alert = driver.switchTo().alert();
        String expectedMessage4 ="Are you sure you want to clear your cart?";
        String actualMessage4 = alert.getText();
        Assert.assertEquals(actualMessage4,expectedMessage4);

//    1.12 Click “Ok” on alert
        acceptAlert();
        Thread.sleep(1000);

//    1.13 Verify the message “Item(s) deleted from your cart”
        String expectedMessage5 ="Item(s) deleted from your cart";
        String actualMessage5 = getTextFromElement(By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"));
        Assert.assertEquals(actualMessage5,expectedMessage5);


//    1.15 Verify the text “Your cart is empty”
        String expectedMessage6 ="Your cart is empty";
        String actualMessage6 = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals(actualMessage6,expectedMessage6);
    }




    @After
    public void tearDown(){
        closeBrowser();
    }







}

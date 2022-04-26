package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility{
    public String cartUrl ="https://mobile.x-cart.com/";

    @Before
    public void loadUrl(){

    openBrowser(cartUrl);

    }

/*
1 - verifyUserShouldNavigateToShippingPageSuccessfully()
		1.1 Click on the “Shipping” link
		1.2 Verify the text “Shipping”

 */
    @Test

    public void verifyUserShouldNavigateToShippingPageSuccessfully()
    {
        // calling method from utility calss to find element and click on it
        clickOnElement(By.xpath("//a[text()='Shipping']"));
       // calling method to get text from utility class and passing it as argument in Assert
        Assert.assertEquals("Shipping",getTextFromElement(By.xpath("//h1[text()='Shipping']")));


    }
    /*
    2 - verifyUserShouldNavigateToNewPageSuccessfully()
		2.1 Click on the “New!” link
		2.2 Verify the text “New arrivals”

     */
    @Test

    public void verifyUserShouldNavigateToNewPageSuccessfully(){
        clickOnElement(By.xpath("(//span[contains(text(),'New!')])[2]"));

        System.out.println(getTextFromElement(By.xpath("//h1[text()='New arrivals']")));

        Assert.assertEquals("New arrivals",getTextFromElement(By.xpath("//h1[text()='New arrivals']")));
    }
    /*
    3 - verifyUserShouldNavigateToComingsoonPageSuccessfully()
		3.1 Click on the “Coming soon” link
		3.2 Verify the text “Coming soon”
     */

    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully(){
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//descendant::li[7]"));
        getTextFromElement(By.id("page-title"));
    }

    /*
    4 - verifyUserShouldNavigateToContactUsPageSuccessfully()
		4.1 Click on the “Contact us” link
		4.2 Verify the text “Contact us”

     */

    @Test

    public void verifyUserShouldNavigateToContactUsPageSuccessfully()
    {
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//descendant::li[@class='leaf last']"));
        Assert.assertEquals("Contact us",getTextFromElement(By.id("page-title")));
    }

@After

    public void closeAllUrl(){

        //closeBrowser();// it will quit all browser opened when performing automation
}
}

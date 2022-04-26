package hotdeals;

import homepage.Utility;
import io.netty.handler.codec.spdy.SpdyWindowUpdateFrame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HotDealsTest extends Utility {
    public String cartUrl ="https://mobile.x-cart.com/";

   @Before

    public void loadMyUrl(){
       openBrowser(cartUrl);

   }

   /*
   1 - verifySaleProductsArrangeAlphabetically()
		1.1 Mouse hover on the “Hot deals” link
		1.2 Mouse hover on the “Sale”  link and click
		1.3 Verify the text “Sale”
		1.4 Mouse hover on “Sort By” and select “Name A-Z”
		1.5 Verify that the product arrange alphabetically

    */
   @Test

    public void verifySaleProductsArrangeAlphabetically()
   {
       Actions action = new Actions(driver);
       //click on hot deals -----WebElement hotDeals =
       WebElement hotDeals = driver.findElement(By.xpath("//div[@id='header']/preceding::div[@class='collapse navbar-collapse']/child::ul[@class='nav navbar-nav top-main-menu']/child::li[@class='leaf has-sub']"));

       WebElement sale = driver.findElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));

       // -extra WebElement hotDeals= driver.findElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/child::li[@class='leaf has-sub']"));
      action.moveToElement(hotDeals).moveToElement(sale).click().build().perform();
       Assert.assertEquals("Sale",getTextFromElement(By.id("page-title")));
        WebElement sortBy = driver.findElement(By.xpath("//span[@class='sort-by-value']"));
        WebElement nameATOZ =   driver.findElement(By.xpath("//a[normalize-space()='Name A - Z']"));

        action.moveToElement(sortBy).moveToElement(nameATOZ).click().build().perform();

   }
   /*2 - verifySaleProductsPriceArrangeLowToHigh()
		2.1 Mouse hover on the “Hot deals” link
		2.2 Mouse hover on the “Sale”  link and click
		2.3 Verify the text “Sale”
		2.4 Mouse hover on “Sort By” and select “Price Low-High”
		2.5 Verify that the product’s price arrange Low to High

       */
    @ Test
    public void verifySaleProductsPriceArrangeLowToHigh(){

        clickSortElement(By.xpath("//a[normalize-space()='Price Low - High']"));


    }
    /*
    3 - verifySaleProductsArrangeByRates()
		3.1 Mouse hover on the “Hot deals” link
		3.2 Mouse hover on the “Sale”  link and click
		3.3 Verify the text “Sale”
		3.4 Mouse hover on “Sort By” and select “Rates”
		3.5 Verify that the product’s arrange Rates

     */

    @Test
    public void verifySaleProductsArrangeByRates(){


        //clickSortElement(By.xpath("//a[@data-sort-by='r.rating']"));
        //driver.findElement(By.xpath("//span[@class='sort-by-label'][1]" ));
       // System.out.println(getTextFromElement(By.xpath("//span[@class='sort-by-value'][1]" )));
        /*
        WebElement dropDown = driver.findElement(By.xpath("//span[@class='sort-by-label']"));

         */

        selectOptionFromDropDown(By.xpath("//a[@data-sort-by='r.rating']"));



    }








}

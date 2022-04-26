package homepage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
// Click on your cart icon and click on your cart buttton
        mouseHoverActionClick(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='header-area']/div[1]/div[1]/div[5]/div[4]"));
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"))
 */

public class Utility {
    public static WebDriver driver;





    public void openBrowser(String baseUrl){ // public no return type with String parameter method declared
        // we will provide Url link to this method when called from any of the child class

        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe"); // setting up driver's property
        driver = new ChromeDriver(); // Chrome Webbrowser driver object has been created
        driver.get(baseUrl); // launch the Url
        driver.manage().window().maximize();// once open the url - maximising the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));// we give implicit waiting time to driver



    }

    public void closeBrowser(){

        driver.quit();//
    }

    //This method will click on element

    public void clickOnElement(By xpath){

        // finding the element and clicking on it
        driver.findElement(xpath).click();
    }

    // this method will find the element and get the text

    public String getTextFromElement(By xpath){

        return driver.findElement(xpath).getText();

    }

    // this method will find the element and send keys to the one
    public void sendTextToElement(By xpath,String sendText){

        driver.findElement(xpath).sendKeys(sendText);

    }
    public int getNumberFromElement(By by) {
        List<WebElement> actualNumberElement = driver.findElements(by);
        int actualNumber = actualNumberElement.size();
        return actualNumber;
    }

    public String getSubstringTextElement(By by, double i) {
        WebElement actualMessageElement = driver.findElement(by);
        String actualMessage = actualMessageElement.getText().substring((int) i);
        return actualMessage;
    }

    // this method will select element based on xpath provided

    public void clickSortElement(By option){

        Actions action = new Actions(driver);
        //click on hot deals -----WebElement hotDeals =
        WebElement hotDeals = driver.findElement(By.xpath("//div[@id='header']/preceding::div[@class='collapse navbar-collapse']/child::ul[@class='nav navbar-nav top-main-menu']/child::li[@class='leaf has-sub']"));

        WebElement sale = driver.findElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));

        action.moveToElement(hotDeals).moveToElement(sale).click().build().perform();
        Assert.assertEquals("Sale",getTextFromElement(By.id("page-title")));
        WebElement sortBy = driver.findElement(By.xpath("//span[@class='sort-by-value']"));
        WebElement optionSelected = driver.findElement(option);

        action.moveToElement(sortBy).moveToElement(optionSelected).click().build().perform();
        System.out.println(getTextFromElement(By.xpath("//span[@class='sort-by-value'][1]" )));


         }

    /**
     * This method will switch to alert
     */
    public void switchToAlert(){
        driver.switchTo().alert();
    }
    /**
     * This method will accept to alert
     */

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    /**
     * This method will dismissto alert
     */

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

         public void selectOptionFromDropDown(By option){
             Actions action = new Actions(driver);
             //click on hot deals -----WebElement hotDeals =
             WebElement hotDeals = driver.findElement(By.xpath("//div[@id='header']/preceding::div[@class='collapse navbar-collapse']/child::ul[@class='nav navbar-nav top-main-menu']/child::li[@class='leaf has-sub']"));

             WebElement sale = driver.findElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));

             action.moveToElement(hotDeals).moveToElement(sale).click().build().perform();
             Assert.assertEquals("Sale",getTextFromElement(By.id("page-title"))); // checking the text on the page is equal to 'Sale'
            /* WebElement sortBy = driver.findElement(By.xpath("//span[@class='sort-by-value']"));
             WebElement optionSelected = driver.findElement(option);

             action.moveToElement(sortBy).moveToElement(optionSelected).click().build().perform();
             System.out.println(getTextFromElement(By.xpath("//span[@class='sort-by-value'][1]" )));*/

            WebElement dropDown = driver.findElement(By.xpath("//span[@class='sort-by-label'][1]"));
             System.out.println(dropDown);
             Select select = new Select(dropDown); // creating new Select object with dropDown Webelement
             select.selectByValue("Rates "); // select by value - this select statement will select option rates from dropdown
             List<WebElement> allOptions = select.getOptions(); // defining list with datatype -Webelement
             System.out.println(allOptions.size());




         }

    /**
     * This method will select the option by visible text
     */
    public void selectByVisibleFromDropDown(By by , String text){
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }
    /**
     * This method will select the option by Index
     */

    public void selectByIndexFromDropDown(By by, int i ) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByIndex(i);
    }

    /**
     * This method will select the option by Value
     */

    public void selectByValueFromDropDown(By by , String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(text);
    }
//*****************************mouse hover************************************//

    public void mouseHoverToElement(By by ){
        Actions actions = new Actions(driver);
        WebElement move = driver.findElement(by);
        actions.moveToElement(move).build().perform();
    }


    public void mouseHoverAndClick(By by){
        Actions actions = new Actions(driver);
        WebElement select = driver.findElement(by);
        actions.moveToElement(select).build().perform();
        actions.moveToElement(select).click().build().perform();
    }




    public void productArrangeAlphabetically(By by){
        ArrayList<String> list = new ArrayList<>();
        List<WebElement> elementsList = driver.findElements(by);
        for (WebElement we:elementsList) {
            list.add(we.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>();
        for (String s: list){
            sortedList.add(s);
        }
        Collections.sort(sortedList);
        Assert.assertTrue(sortedList.equals(list));
    }

    public void clearValue(By by){
        driver.findElement(by).clear();
    }




}

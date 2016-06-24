package tests;

import functions.HotelApp_BusinessFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by a on 6/18/2016.
 */
public class FunctionCallingTest extends HotelApp_BusinessFunctions {

    private String baseurl;
    private boolean accepNextAlert=true;
    private StringBuffer verificationErrors=new StringBuffer();
   // public Properties prop;

    @BeforeMethod
    public void setUp() throws Exception{
        prop =new Properties();
        prop.load(new FileInputStream("C:\\Users\\a\\udemyAutomation\\Hotel_App\\src\\main\\SharedUIMap\\SharedUIMap.properties"));
        driver=new FirefoxDriver();
        baseurl="http://www.adactin.com";
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

   @Test
    public void testMyFirstWebDriver() throws Exception{
       driver.get(baseurl+"/HotelApp/");
       HA_BF_Login(driver,"adactin123","adactin123");
       new Select(driver.findElement(By.id(prop.getProperty("Lst_SearchHotel_Location")))).selectByVisibleText("Sydney");
       driver.findElement(By.id(prop.getProperty("Btn_SearchHotel_Search"))).click();


   }



}

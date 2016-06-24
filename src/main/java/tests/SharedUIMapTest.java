package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by a on 6/18/2016.
 */
public class SharedUIMapTest {
    private WebDriver driver;
    private String baseurl;
    private boolean accepNextAlert=true;
    private StringBuffer verificationErrors=new StringBuffer();
    public Properties prop;


    @BeforeMethod
    public void setUp() throws Exception{
        prop=new Properties();
        prop.load(new FileInputStream("C:\\Users\\a\\udemyAutomation\\Hotel_App\\src\\main\\SharedUIMap\\SharedUIMap.properties"));
        driver=new FirefoxDriver();
        baseurl="http://www.adactin.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void testMyFirstWebDriver() throws Exception{
        driver.get(baseurl+"/HotelApp");
      driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).sendKeys("adactin123");

        driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).clear();
        driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).sendKeys("adactin123");
        driver.findElement(By.id(prop.getProperty("Btn_Login_Login"))).click();
        new Select(driver.findElement(By.id(prop.getProperty("Lst_SearchHotel_Location")))).selectByVisibleText("Sydney");


        driver.findElement(By.id(prop.getProperty("Btn_SearchHotel_Search"))).click();


        driver.findElement(By.id(prop.getProperty("Rad_SelectHotel_RadioButton_1"))).click();
        driver.findElement(By.id(prop.getProperty("Btn_SelectHotel_Continue"))).click();

        driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_FirstName"))).clear();
        driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_FirstName"))).sendKeys("test");
        driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_LastName"))).clear();
        driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_LastName"))).sendKeys("test");
        driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_Address"))).clear();
        driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_Address"))).sendKeys("test");
        driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCNumber"))).clear();
        driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCNumber"))).sendKeys("1212121212121212");
        new Select(driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCType")))).selectByVisibleText("American Express");
        new Select(driver.findElement(By.id(prop.getProperty("Lst_BookingHotel_CCExpMonth")))).selectByVisibleText("March");
        new Select(driver.findElement(By.id(prop.getProperty("Lst_BookingHotel_CCExpYear")))).selectByVisibleText("2015");


        driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCCvvNumber"))).clear();
        driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCCvvNumber"))).sendKeys("111");
        driver.findElement(By.id(prop.getProperty("Btn_BookingHotel_BookNow"))).click();
        driver.findElement(By.linkText(prop.getProperty("Lnk_BookingHotel_Logout"))).click();
        driver.findElement(By.linkText(prop.getProperty("Lnk_Logout_ClickHeretoLoginAgain"))).click();


    }


}

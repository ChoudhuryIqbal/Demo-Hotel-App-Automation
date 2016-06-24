package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by a on 6/18/2016.
 */
public class MyFirstWebDriverTest {
    private WebDriver driver;
    private String baseurl;
    private boolean accepNextAlert=true;
    private StringBuffer verificationErrors=new StringBuffer();

    @BeforeMethod
    public void setUp() throws Exception{
        driver=new FirefoxDriver();
        baseurl="http://www.adactin.com/";
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void testMyFirstWebDriver() throws Exception{
        driver.get(baseurl+"/HotelApp");
      driver.findElement(By.xpath(".//*[@id='username']")).clear();
        driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("adactin123");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("adactin123");
        driver.findElement(By.id("login")).click();
        new Select(driver.findElement(By.id("location"))).selectByVisibleText("Sydney");
        driver.findElement(By.id("Submit")).click();
        driver.findElement(By.id("radiobutton_1")).click();
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("first_name")).clear();
        driver.findElement(By.id("first_name")).sendKeys("test");
        driver.findElement(By.id("last_name")).clear();
        driver.findElement(By.id("last_name")).sendKeys("test");
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys("test");
        driver.findElement(By.id("cc_num")).clear();
        driver.findElement(By.id("cc_num")).sendKeys("1212121212121212");
        new Select(driver.findElement(By.id("cc_type"))).selectByVisibleText("American Express");
        new Select(driver.findElement(By.id("cc_exp_month"))).selectByVisibleText("March");
        new Select(driver.findElement(By.id("cc_exp_year"))).selectByVisibleText("2015");
        driver.findElement(By.id("cc_cvv")).clear();
        driver.findElement(By.id("cc_cvv")).sendKeys("111");
        driver.findElement(By.id("book_now")).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.linkText("Click here to login again")).click();


    }


}

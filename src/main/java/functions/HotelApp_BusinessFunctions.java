package functions;


import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;


import mx4j.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Locale;
import java.util.Properties;

/**
 * Created by a on 6/20/2016.
 */
public class HotelApp_BusinessFunctions {

    public static Properties prop;
    public static WebDriver driver;

    ///Method Body
    public void HA_BF_Login(WebDriver driver,String sUserName, String sPassword){
        driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).sendKeys(sUserName);

        driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).clear();
        driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).sendKeys(sPassword);
        driver.findElement(By.id(prop.getProperty("Btn_Login_Login"))).click();

    }


    public static String HA_GF_readXL(int row, String column,String strFilePath) {
        jxl.Cell c=null;

        int reqCol = 0;

        WorkbookSettings ws = null;
        Workbook workbook = null;
        Sheet sheet = null;
        FileInputStream fs = null;


        try{
            fs =new FileInputStream(new File(strFilePath));
            ws=new WorkbookSettings();
            ws.setLocale(new Locale("en","EN"));

            //oepning the work book and sheet for reading data
            workbook=Workbook.getWorkbook(fs,ws);
            sheet=workbook.getSheet(0);
            //sanitise given data
            String col=column.trim();
            //loop for going though the given row
            for(int j=0;j<sheet.getColumns();j++){
                //Cell cell=sheet.getCell(j,0);
                jxl.Cell cell=sheet.getCell(j,0);
                if((cell.getContents().trim().equalsIgnoreCase(col))){
                    reqCol=cell.getColumn();
                    //System.out.println("column NO"+reqCol);

                    c=sheet.getCell(reqCol,row);
                    fs.close();
                    return  c.getContents();


                }

            }

        }
        catch(BiffException be){

            //Log(be.getMessage().toString());
           // Log(be.getMessage().toString());
            System.out.println("The given file should have .xls extension");
        }
        catch (Exception e){
            e.printStackTrace();

         //  Log(e.getMessage().toString());

           // Log(e.getMessage().toString());

        }
      //4  Log("NO Match Found IN Given File: PROBLEM IS COMING FROM DATA FILE");

    return null;

    }



}

package com.guru99.testcases;

import com.guru99.utilities.readConfig;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;

public class BaseCLass_Test {


    readConfig readconfig=new readConfig();

    public String baseUrl = readconfig.getBaseUrl();
    public String username = readconfig.getUsername();
    public String password = readconfig.getPassword();

    public static WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br) {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        logger = LogManager.getLogger("guru99_framework");
        if(br.equals("chrome"))
        {
            driver = new ChromeDriver();
            logger.info("chrome driver initialized");
        }
        else if(br.equals("firefox"))
        {
            driver=new FirefoxDriver();
            logger.info("firefox driver initialized");

        }
        else if(br.equals("edge"))
        {
            driver=new EdgeDriver();
            logger.info("Edge    driver initialized");
        }
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

    public void capture_screen(WebDriver driver, String test_name) throws IOException {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        File target= new File("ScreenShot/" + test_name + ".png");
        FileUtils.copyFile(source,target);
        System.out.println("screen shot taken");
        logger.info("screen shot captured at"+target);
    }

    public String GenerateRandomText()
    {
        String randomtext=RandomStringUtils.randomAlphabetic(5);
        return randomtext;
    }

    public boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e)
        {
            return false;
        }

    }

}
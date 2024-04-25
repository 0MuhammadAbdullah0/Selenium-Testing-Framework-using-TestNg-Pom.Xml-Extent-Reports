package com.guru99.testcases;

import com.guru99.pageObjects.AddCostumerPage;
import com.guru99.pageObjects.loginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration
public class TC_AddCustomer_001_Test extends BaseCLass_Test {

    @Test
    public void Add_Newcustomer() throws InterruptedException, IOException {

        loginPage lp = new loginPage(driver);
        Thread.sleep(1000);
        logger.info("login page opened");
        lp.setUsername(username);
        logger.info("username entered");
        lp.setPassword(password);
        logger.info("password entered");
        lp.clickLoginButton();
        logger.info("login done");

        Thread.sleep(1000);


        AddCostumerPage addCostumerPage = new AddCostumerPage(driver);
        addCostumerPage.open_add_cust_page();
        Thread.sleep(5000);

        if (isAdPresent()) {
            // Wait for the ad element to be visible
            WebDriverWait wait;
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement adElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ad-class")));

            // Handle the ad (e.g., close it by clicking a close button)
            adElement.findElement(By.className("close-button")).click();

            // Switch back to the main page
            driver.switchTo().defaultContent();
        }

        addCostumerPage.SetNewCustName("Abdullah");
        addCostumerPage.setNewCustGender("male");
        addCostumerPage.AddDOb("05", "10", "2002");
        Thread.sleep(1000);
        addCostumerPage.AddAddress("karachi");
        addCostumerPage.AddCity("karachi");
        addCostumerPage.AddState("sindh");
        addCostumerPage.AddPIN("123456");
        addCostumerPage.AddMobile("03232100000");

        String email=GenerateRandomText()+"@gmail.com";
        addCostumerPage.AddEmail(email);


        addCostumerPage.AddPassword("abcdef");
        addCostumerPage.Submit();

        logger.info("customer details entered");

        if (driver.getPageSource().contains("Customer Registered Successfully!!!")) {
            logger.info("Customer Registered Successfully!!!");
            Capture_user_id();
            Assert.assertTrue(true);

        } else {
            logger.info("Customer Cant be registered");
            capture_screen(driver, "Add_Newcustomer");
            Assert.fail();

        }

}
        private static boolean isAdPresent (){
            try {
                driver.findElement(By.className("ad-class"));
                return true;
            } catch (org.openqa.selenium.NoSuchElementException e) {
                return false;
            }
        }

        public void Capture_user_id()
        {
            WebElement cell_data = driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]"));
            String user_id=cell_data.getText();
            System.out.println("The User id is "+user_id);
            logger.info("The User id is "+user_id);

        }
    }

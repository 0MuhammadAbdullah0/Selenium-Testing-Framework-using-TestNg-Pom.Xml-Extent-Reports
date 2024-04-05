package com.guru99.testcases;

import com.guru99.pageObjects.loginPage;
import com.guru99.utilities.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

@Test
public class TC_logintestDDT_002_Test extends BaseCLass {


    @Test(dataProvider = "loginData")
    public void login_DDT(String username,String password) throws IOException, InterruptedException {

//        driver.get(baseUrl);
//        logger.info("url opened");

        loginPage lp=new loginPage(driver);
        Thread.sleep(100);

        lp.setUsername(username);
        logger.info("username entered");
        lp.setPassword(password);
        logger.info("password entered");
        lp.clickLoginButton();
        logger.info("login button pressed");

        if(isAlertPresent()==true)
        {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            logger.warn("login failed");
            Assert.assertTrue(false);
        }

        else
        {
            logger.info("login pass");
            Assert.assertTrue(true);
            lp.clickLogout();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }
    }





    @DataProvider(name = "loginData")
    String [][] get_data() throws IOException {
        String path="src/test/java/com/guru99/testData/LoginData.xlsx";
        int rownum= XLUtils.getRowCount(path,"Sheet1");
        int colcount=XLUtils.getCellCount(path,"Sheet1",1);

        String [][] logindata =new String[rownum][colcount];

        for(int i=1; i<=rownum;i++)
        {
            for(int j=0; j<colcount;j++)
            {
                logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
            }
        }

        return logindata;
    }




}

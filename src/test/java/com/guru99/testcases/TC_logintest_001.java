    package com.guru99.testcases;

    import com.beust.ah.A;
    import com.guru99.pageObjects.loginPage;
    import org.openqa.selenium.By;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import org.testng.Assert;
    import org.testng.annotations.Test;

    import java.io.IOException;

    public class TC_logintest_001 extends BaseCLass {

        @Test
        public void login() throws InterruptedException, IOException {

    //            driver.get(baseUrl);
                logger.info("url opened");
                loginPage loginPage1 = new loginPage(driver);

                Thread.sleep(100);

                // Fill in username, password, and click login button
                loginPage1.setUsername(username);
                loginPage1.setPassword(password);
                logger.info("username and password set");
                loginPage1.clickLoginButton();


                if(driver.getTitle().contentEquals("Guru99 Bank Manage HomePage"))
                {
                    Assert.assertTrue(true);
                    logger.info("login done");
                }

                else
                {

                    logger.warn("login failed");
                    capture_screen(driver,"login");
                    Assert.assertTrue(false);
                }


    }
    }

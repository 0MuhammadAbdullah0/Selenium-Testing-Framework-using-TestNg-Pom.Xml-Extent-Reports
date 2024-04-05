package com.guru99.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    WebDriver driver;

    @FindBy(name="uid")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(name="btnLogin")
    WebElement loginButton;

    @FindBy(xpath ="/html/body/div[3]/div/ul/li[15]/a")
    @CacheLookup
    WebElement logoutlink;

    // Constructor
    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String uname) {
        username.sendKeys(uname);
    }

    public void setPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickLogout() {
        logoutlink.click();


    }
}

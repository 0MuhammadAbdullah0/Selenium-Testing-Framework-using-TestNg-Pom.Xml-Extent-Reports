package com.guru99.pageObjects;

import com.guru99.testcases.BaseCLass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;

public class AddCostumerPage{

    WebDriver driver;
    public AddCostumerPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH,using = "/html/body/div[3]/div/ul/li[2]/a")
    WebElement Customerpagelink;

    @CacheLookup@FindBy(how=How.NAME,using="name")
    WebElement NewCustname;

    @CacheLookup
    @FindBy(how=How.NAME,using = "rad1")
    WebElement NewCustGender;

    @CacheLookup
    @FindBy(how=How.ID_OR_NAME,using = "dob")
    WebElement NewCustDOB;

    @CacheLookup@FindBy(how=How.NAME,using = "addr")
    WebElement NewCustAdd;

    @CacheLookup@FindBy(how=How.NAME,using = "city")
    WebElement NewCustCity;

    @CacheLookup@FindBy(how=How.NAME,using = "state")
    WebElement NewCustState;

    @CacheLookup@FindBy(how=How.NAME,using = "pinno")
    WebElement NewCustPIN;

    @CacheLookup@FindBy(how=How.NAME,using = "telephoneno")
    WebElement NewCustPhone;

    @CacheLookup@FindBy(how=How.NAME,using = "emailid")
    WebElement NewCustEmail;

    @CacheLookup@FindBy(how=How.NAME,using = "password")
    WebElement NewCustPassword;

    @CacheLookup@FindBy(how=How.NAME,using = "sub")
    WebElement NewCustSubmit;
    @CacheLookup@FindBy(how=How.NAME,using = "res")
    WebElement NewCustReset;

    public void open_add_cust_page()
    {
        Customerpagelink.click();
    }
    public void SetNewCustName(String name)
    {
        NewCustname.sendKeys(name);
    }
    public void setNewCustGender(String gender)
    {
        NewCustGender.click();
    }
    public void AddDOb(String mm,String dd,String yyyy)
    {
        NewCustDOB.sendKeys(mm);
        NewCustDOB.sendKeys(dd);
        NewCustDOB.sendKeys(yyyy);

    }
    public void AddAddress(String address)
    {
        NewCustAdd.sendKeys(address);
    }
    public void AddCity(String city)
    {
        NewCustCity.sendKeys(city);
    }
    public void AddState(String state)
    {
        NewCustState.sendKeys(state);
    }
    public void AddPIN(String pin)
    {
        NewCustPIN.sendKeys(pin);
    }
    public void AddMobile(String mobile)
    {
        NewCustPhone.sendKeys(mobile);
    }
    public void AddEmail(String email)
    {
        NewCustEmail.sendKeys(email);
    }
    public void AddPassword(String password)
    {
        NewCustPassword.sendKeys(password);
    }
    public void Submit()
    {
        NewCustSubmit.click();
    }
    public void Reset()
    {
        NewCustReset.click();
    }

}

package com.friday.pages;

import com.friday.utilities.BrowserUtils;
import com.friday.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterRegistrationDate {

    public EnterRegistrationDate(){ //Constructor
        PageFactory.initElements(Driver.getDriver(),this); //initilize to PageFactory
    }

    //when was the car register
    @FindBy(xpath = "//input[@name='monthYearOwnerRegistered']")
    public WebElement carRegisterDate;

    //when was the first registration
    @FindBy(xpath = "//input[@name='monthYearFirstRegistered']")
    public WebElement firstRegisterDate;

    //verify page link
    public void verifyUrl(){
        BrowserUtils.waitFor(1);
        String actualUrl = "https://hello.friday.de/quote/enterRegistrationDate";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);
    }

    public void registerDate(String arg){
        if(arg.length()<=7 & arg.length()>=7){
            firstRegisterDate.sendKeys(arg);
        }else {
            System.out.println("wrong check your register number !");
        }
    }

    public void registerToYou(String arg){
        if(arg.length()<=7 & arg.length()>=7){

            carRegisterDate.sendKeys(arg);

        }else {
            System.out.println("wrong check your register number !");
        }
    }

}

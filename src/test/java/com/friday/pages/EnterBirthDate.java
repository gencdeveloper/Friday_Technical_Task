package com.friday.pages;

import com.friday.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterBirthDate {

    public EnterBirthDate(){ //Constructor
        PageFactory.initElements(Driver.getDriver(),this); //initilize to PageFactory
    }


    //when were you born
    @FindBy(xpath = "//input[@name='birthDate']")
    public WebElement birthDay;

    //verify page link
    public void verifyBirthdateUrl(){
        String actualUrl = "https://hello.friday.de/quote/enterBirthDate";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);
    }

}

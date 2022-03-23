package com.friday.pages;

import com.friday.utilities.BrowserUtils;
import com.friday.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectModel {

    public SelectModel(){ //Constructor
        PageFactory.initElements(Driver.getDriver(),this); //initilize to PageFactory
    }

    //Type for car model
    @FindBy(xpath = "//input[@name='modelFilter']")
    public WebElement carModel;

    @FindBy(xpath = "//div[@class='SingleClickListField__infoBlock--IEVkY']")
    public WebElement mdlList;


    //verify page link
    public void verifyUrl(){
        BrowserUtils.waitFor(1);
        String actualUrl = "https://hello.friday.de/quote/selectModel";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);
    }



}

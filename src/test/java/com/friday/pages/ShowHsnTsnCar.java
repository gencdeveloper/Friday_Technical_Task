package com.friday.pages;

import com.friday.utilities.BrowserUtils;
import com.friday.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowHsnTsnCar {
    public ShowHsnTsnCar() { //Constructor
        PageFactory.initElements(Driver.getDriver(), this); //initilize to PageFactory
    }

    //car name
    @FindBy(xpath = "//div[@data-test-id='carLabel']")
    public WebElement carLabel;

    public void verifyCarBrand(){
        //verify Car brand
        String actualString = carLabel.getText();
        String expectedString = actualString;
        Assert.assertTrue(actualString.contains(expectedString));

        System.out.println("actual Brand and Model  = "    + actualString);
        System.out.println("expected Brand and Model = " + expectedString);

    }



    //verify page link
    public void verifyUrl(){
        BrowserUtils.waitFor(1);
        String actualUrl = "https://hello.friday.de/quote/showHsnTsnCar";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);
    }











}
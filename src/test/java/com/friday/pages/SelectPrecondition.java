package com.friday.pages;

import com.friday.utilities.BrowserUtils;
import com.friday.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPrecondition {

    public SelectPrecondition(){ //Constructor
        PageFactory.initElements(Driver.getDriver(),this); //initilize to PageFactory
    }

    //The car is already Insured Radio Button
    @FindBy(xpath = "//label[@data-testid='quoting.selectPrecondition.keepingCarquoting.selectPrecondition.keepingCar.subLine']//div[@class='css-16lh4m5']")
    public WebElement alreadyInsured;

    //The car is Re_Register
    @FindBy(xpath = "//label[@data-testid='quoting.selectPrecondition.buyingCarquoting.selectPrecondition.buyingCar.subLine']//div[@class='css-16lh4m5']")
    public WebElement carRe_Register;

    //Friday Insurance start
    @FindBy(xpath = "//input[@name='inceptionDate']")
    public WebElement insuranceStartDate;

    //verify page link
    public void verifyPreconditionPage(){
        String actualUrl = "https://hello.friday.de/quote/selectPrecondition";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);
    }

    public void enteredDate(String arg){
        BrowserUtils.waitFor(1);
        insuranceStartDate.clear();
        insuranceStartDate.sendKeys(arg);
        BrowserUtils.waitFor(3);
    }

    public void insurerType(String arg){
        String already_Insured = "The car is already insured";
        String carRegisterText = "The car will still be registered";

        if (already_Insured.equals(arg)){
            System.out.println(arg);
            alreadyInsured.click();
            BrowserUtils.waitFor(5);
            Assert.assertTrue(alreadyInsured.isDisplayed());
        } else if(carRegisterText.equals(arg)){
            carRe_Register.click();
            BrowserUtils.waitForPageToLoad(10);
            Assert.assertTrue(carRe_Register.isDisplayed());
        }else {
            Assert.assertEquals(already_Insured,carRegisterText,"not equal");
            System.out.println("Text is not correct!");
        }
    }


}

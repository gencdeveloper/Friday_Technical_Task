package com.friday.pages;

import com.friday.utilities.BrowserUtils;
import com.friday.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectRegisterOwner {

    public SelectRegisterOwner(){ //Constructor
        PageFactory.initElements(Driver.getDriver(),this); //initilize to PageFactory
    }
    BasePageForWebElement basePage = new BasePageForWebElement();

    //Are you owner of the car YES
    @FindBy(xpath = "//label[@data-testid='shared.yes']")
    public WebElement yesCarOwner;


    //Are you owner of the car NO
    @FindBy(xpath = "//label[@data-testid='shared.no']")
    public WebElement noCarOwner;


    //The car was used at purchase
    @FindBy(xpath = "//label[@data-testid='quoting.selectRegisteredOwner.used']")
    public WebElement usedPurchased;

    //The car was used at when buying new
    @FindBy(xpath = "//label[@data-testid='quoting.selectRegisteredOwner.brandNew']")
    public WebElement brandNew;

    //verify page link
    public void verifSelectRegisterPage(){
        String actualUrl = "https://hello.friday.de/quote/selectRegisteredOwner";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);
    }

    public void areYouOwnerCar(String arg){
        String yes = "yes";
        String no = "no";
        if (yes.equals(arg.toLowerCase())){
            yesCarOwner.click();
            Assert.assertTrue("not True",yesCarOwner.isDisplayed());
            BrowserUtils.waitFor(2);
        }else if (no.equals(arg.toLowerCase())){
            noCarOwner.click();
            Assert.assertTrue("not True",noCarOwner.isDisplayed());
            BrowserUtils.waitFor(2);
        }else {
            System.out.println("Text is not correct!");
            Assert.assertFalse(true);
        }
    }


    public void userCarWas(String arg){
        String second = "used at purchase";
        String brand = "when buying new";

        if (second.equals(arg.toLowerCase())){
            BrowserUtils.waitFor(2);
            Assert.assertTrue("not Truer",usedPurchased.isDisplayed());
            basePage.setFurtherButton();
        }else if (brand.equals(arg.toLowerCase())){
            brandNew.click();
            BrowserUtils.waitFor(3);
            Assert.assertTrue("not True",brandNew.isDisplayed());
            basePage.setFurtherButton();
        }else {
            System.out.println("Text is not correct!");
        }
    }


}

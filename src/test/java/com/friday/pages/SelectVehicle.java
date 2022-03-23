package com.friday.pages;

import com.friday.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectVehicle {

    public SelectVehicle(){ //Constructor
        PageFactory.initElements(Driver.getDriver(),this); //initilize to PageFactory
    }

    //Choose your car withmonthYear
    @FindBy(xpath = "//input[@name='monthYear']")
    public WebElement monthYear;

    //Choose your car with hsn
    @FindBy(xpath = "//input[@name='hsn']")
    public WebElement hsn;

    //Choose your car with tsn value
    @FindBy(xpath = "//input[@name='tsn']")
    public WebElement tsn;

    //Find by make & model
    @FindBy(xpath = "//button[@name='list']")
    public WebElement searchButton;

    //Type for car brand
    @FindBy(xpath = "//input[@name='makeFilter']")
    public WebElement carBrand;


    public void verifyUrl(){
        //verify page link
        String actualUrl = "https://hello.friday.de/quote/selectVehicle";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);
    }

    public void credantialType(String my,String hsnVal,String tsnVal){
        //check to type size for first registration
        if(my.length()<=7 & my.length()>=7){
            monthYear.sendKeys(my);
        }else {
            System.out.println("ywrong check your month and year date!");
        }

        //check to type size for HSN number
        if(hsnVal.length()<=4 & hsnVal.length()>=4){
            hsn.sendKeys(hsnVal);
        }else {
            System.out.println("ywrong check your hsn number !");
        }

        //check to type size for tsn number
        if(tsnVal.toLowerCase().length()<=3 & tsnVal.toLowerCase().length()>=3){
            tsn.sendKeys(tsnVal);

        }else {
            System.out.println("ywrong check tsn value!");
        }
    }




}

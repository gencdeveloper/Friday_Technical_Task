package com.friday.pages;

import com.friday.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectEngine {

    public SelectEngine(){ //Constructor
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//button[@name='engine']")
    public WebElement firstCar;




}

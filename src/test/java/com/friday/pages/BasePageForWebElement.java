package com.friday.pages;

import com.friday.utilities.BrowserUtils;
import com.friday.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageForWebElement {

    public BasePageForWebElement(){ //Constructor
        PageFactory.initElements(Driver.getDriver(),this); //initilize to PageFactory
    }




    @FindBy(xpath = "//button[@slicetype='half-width_teaser'][1]")
    public WebElement calculateInsuranceButton;


    //Further Button
    @FindBy(css= "button[type='submit'] span font font")
    public WebElement furtherButton;

    //Further Button
    @FindBy(xpath= "//button[@type='submit']")
    public WebElement further;

    public void setFurtherButton(){
        Actions action = new Actions(Driver.getDriver());
        WebElement further = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));

        action.moveToElement(further).click().build().perform();

        BrowserUtils.waitFor(3);
    }

    public void furtherButtonIsEnable(){
        if (further.isEnabled()){
            setFurtherButton();
        }else {
            System.out.println("Oops, unfortunately that didn't work. Please check your entry.");
            Assert.assertFalse(false);
        }
    }




}

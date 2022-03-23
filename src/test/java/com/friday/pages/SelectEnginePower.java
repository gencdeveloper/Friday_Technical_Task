package com.friday.pages;

import com.friday.utilities.BrowserUtils;
import com.friday.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectEnginePower {
    public SelectEnginePower(){ //Constructor
        PageFactory.initElements(Driver.getDriver(),this); //initilize to PageFactory
    }


    @FindBy(xpath = "//button[@name='enginePower']")
    List<WebElement> listElement;


    //verify page link
    public void verifyUrl(){
        BrowserUtils.waitFor(1);
        String actualUrl = "https://hello.friday.de/quote/selectEnginePower";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);
    }

    public void listTextforEnginePower(String arg ) {

        for (int i = 0; i < listElement.size(); i++) {
            String elementText = listElement.get(i).getText();

            System.out.println(elementText);

            if (elementText.toLowerCase().contentEquals(arg.toLowerCase())) {
                BrowserUtils.waitFor(2);
                listElement.get(i).click();
                System.out.println(i);
                BrowserUtils.waitFor(2);
                break;

            } else {
                System.out.println("not yet found!");
            }

        }
    }
}

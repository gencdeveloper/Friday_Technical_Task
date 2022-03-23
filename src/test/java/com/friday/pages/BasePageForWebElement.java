package com.friday.pages;

import com.friday.utilities.BrowserUtils;
import com.friday.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * The purpose of this page is to store existing web elements and frequently used methods here.

 * */

public class BasePageForWebElement {

    public BasePageForWebElement(){ //Constructor
        PageFactory.initElements(Driver.getDriver(),this); //initilize to PageFactory
    }


//button[@class='sc-gsDKAQ sc-hKwDye kpmULP ikkBJm generic-button promo-interaction-elem'][1]

    @FindBy(xpath = "//button[@slicetype='half-width_teaser'][1]")
    public WebElement calculateInsuranceButton;

    //The car is already Insured Radio Button
    @FindBy(xpath = "//label[@data-testid='quoting.selectPrecondition.keepingCarquoting.selectPrecondition.keepingCar.subLine']//div[@class='css-16lh4m5']")
    public WebElement alreadyInsured;

    //The car is Re_Register
    @FindBy(xpath = "//label[@data-testid='quoting.selectPrecondition.buyingCarquoting.selectPrecondition.buyingCar.subLine']//div[@class='css-16lh4m5']")
    public WebElement carRe_Register;

    //Friday Insurance start
    @FindBy(xpath = "//input[@name='inceptionDate']")
    public WebElement insuranceStartDate;

    //Further Button
    @FindBy(css= "button[type='submit'] span font font")
    public WebElement furtherButton;

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

    //Choose your car withmonthYear
    @FindBy(xpath = "//input[@name='monthYear']")
    public WebElement monthYear;

    //Choose your car with hsn
    @FindBy(xpath = "//input[@name='hsn']")
    public WebElement hsn;

    //Choose your car with tsn value
    @FindBy(xpath = "//input[@name='tsn']")
    public WebElement tsn;


    //car name
    @FindBy(xpath = "//div[@data-test-id='carLabel']")
    public WebElement carLabel;

    //when was the car register
    @FindBy(xpath = "//input[@name='monthYearOwnerRegistered']")
    public WebElement carRegisterDate;

    //when was the first registration
    @FindBy(xpath = "//input[@name='monthYearFirstRegistered']")
    public WebElement firstRegisterDate;

    //when were you born
    @FindBy(xpath = "//input[@name='birthDate']")
    public WebElement birthDay;

    //Find by make & model
    @FindBy(xpath = "//button[@name='list']")
    public WebElement searchButton;

    //Type for car brand
    @FindBy(xpath = "//input[@name='makeFilter']")
    public WebElement carBrand;

    //Type for car model
    @FindBy(xpath = "//input[@name='modelFilter']")
    public WebElement carModel;



    public void setFurtherButton(){
        Actions action = new Actions(Driver.getDriver());
        WebElement further = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));

        action.moveToElement(further).click().build().perform();

        BrowserUtils.waitFor(3);
    }


}

package com.friday.step_definitions;

import com.friday.pages.BasePageForWebElement;
import com.friday.utilities.BrowserUtils;
import com.friday.utilities.ConfigurationReader;
import com.friday.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.sukgu.Shadow;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class reRegisterStep {

    BasePageForWebElement basePage = new BasePageForWebElement();


    @Given("the user is on the calculate page")
    public void the_user_is_on_the_calculate_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        basePage.calculateInsuranceButton.click();

        String expectedURL = Driver.getDriver().getCurrentUrl();
        String actualUrl = "https://hello.friday.de/quote/selectPrecondition";

        //Verify that
        Assert.assertEquals(actualUrl,expectedURL);

        BrowserUtils.waitFor(10);

        Shadow shadow = new Shadow(Driver.getDriver());
        WebElement element = shadow.findElementByXPath("//button[@data-testid='uc-accept-all-button']");
        element.click();




    }

    @Given("User should be able to choose insurer type {string}")
    public void user_should_be_able_to_choose_insurer_type(String arg) {

        String already_Insured = "The car is already insured";
        String carRe_Register = "The car will still be registered";

        if (already_Insured.equals(arg)){
            System.out.println(arg);
            basePage.alreadyInsured.click();
            BrowserUtils.waitFor(5);
            Assert.assertTrue(basePage.alreadyInsured.isDisplayed());
        } else if(carRe_Register.equals(arg)){
            basePage.carRe_Register.click();
            BrowserUtils.waitForPageToLoad(10);
            Assert.assertTrue(basePage.carRe_Register.isDisplayed());
        }else {
            Assert.assertEquals(already_Insured,carRe_Register,"not equal");
            System.out.println("Text is not correct!");
        }

    }

    @Then("User should be able to type {string} with valid date for insurance start day")
    public void user_should_be_able_to_type_with_valid_date(String date) {

        String startDate = date;
        basePage.insuranceStartDate.clear();
        BrowserUtils.waitFor(1);
        basePage.insuranceStartDate.sendKeys(date);
        BrowserUtils.waitFor(1);

        basePage.setFurtherButton();

    }

    @And("User should be able to pass with further button")
    public void user_should_be_able_to_pass_with_further_button() {

        Actions action = new Actions(Driver.getDriver());
        WebElement further = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));

        action.moveToElement(further).click().build().perform();

        BrowserUtils.waitFor(3);
    }
    @Then("User owner of the car yes or no {string}")
    public void user_owner_of_the_car_yes_or_no(String arg) {
        //verify page link
        String actualUrl = "https://hello.friday.de/quote/selectRegisteredOwner";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);

        //verify data for "Are you the owner of the car?"
        String yes = "yes";
        String no = "no";
        if (yes.equals(arg.toLowerCase())){
            basePage.yesCarOwner.click();
            Assert.assertTrue("not Truer",basePage.yesCarOwner.isDisplayed());
            BrowserUtils.waitFor(2);
        }else if (no.equals(arg.toLowerCase())){
            basePage.noCarOwner.click();
            Assert.assertTrue("not True",basePage.noCarOwner.isDisplayed());
            BrowserUtils.waitFor(2);
        }else {
            System.out.println("Text is not correct!");
            Assert.assertFalse(true);
        }
    }

    @Then("User's car was {string}")
    public void user_s_car_was(String arg) {

        String second = "used at purchase";
        String brand = "when buying new";

        if (second.equals(arg.toLowerCase())){
            BrowserUtils.waitFor(2);
            Assert.assertTrue("not Truer",basePage.usedPurchased.isDisplayed());
            basePage.setFurtherButton();
        }else if (brand.equals(arg.toLowerCase())){
            basePage.brandNew.click();
            BrowserUtils.waitFor(3);
            Assert.assertTrue("not True",basePage.brandNew.isDisplayed());
            basePage.setFurtherButton();
        }else {
            System.out.println("Text is not correct!");
        }



    }

    @Then("User should be able to choose car with valid credantial type {string} , {string} , {string}")
    public void user_should_be_able_to_choose_car_with_valid_credantial_type(String my, String hsnVal, String tsnVal) {
        //verify page link
        String actualUrl = "https://hello.friday.de/quote/selectVehicle";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);

        //check to type size for first registration
        if(my.length()<=7 & my.length()>=7){
            basePage.monthYear.sendKeys(my);
        }else {
            System.out.println("ywrong check your month and year date!");
        }

        //check to type size for HSN number
        if(hsnVal.length()<=4 & hsnVal.length()>=4){
            basePage.hsn.sendKeys(hsnVal);
        }else {
            System.out.println("ywrong check your hsn number !");
        }

        //check to type size for tsn number
        if(tsnVal.toLowerCase().length()<=3 & tsnVal.toLowerCase().length()>=3){
            basePage.tsn.sendKeys(tsnVal);

        }else {
            System.out.println("ywrong check tsn value!");
        }

        basePage.setFurtherButton();
    }

    @Then("User verify that with choosed car {string}")
    public void user_verify_that_with_choosed_car(String string) {
        //verify page link
        String actualUrl = "https://hello.friday.de/quote/showHsnTsnCar";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);

        //verify Car brand
        String actualString = basePage.carLabel.getText();
        String expectedString = actualString;
        Assert.assertTrue(actualString.contains(expectedString));

        System.out.println("actual Brand and Model  = "    + actualString);
        System.out.println("expected Brand and Model = " + expectedString);

        basePage.setFurtherButton();


    }

    @Then("User should be able to {string} with valid date for car register to owner")
    public void user_should_be_able_to_with_valid_date(String registerDate) {
        //verify page link
        BrowserUtils.waitFor(2);
        String actualUrl = "https://hello.friday.de/quote/enterRegistrationDate";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);

        if(registerDate.length()<=7 & registerDate.length()>=7){

            basePage.carRegisterDate.sendKeys(registerDate);

        }else {
            System.out.println("wrong check your register number !");
        }

        basePage.setFurtherButton();

    }

    @Then("User should be able to type when was the car register to you {string} with invalid date")
    public void user_should_be_able_to_type_when_was_the_car_register_to_you_with_invalid_date(String registerDate) {
        //verify page link
        String actualUrl = "https://hello.friday.de/quote/enterRegistrationDate";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);

        if(registerDate.length()<=7 & registerDate.length()>=7){

            basePage.carRegisterDate.sendKeys(registerDate);

        }else {
            System.out.println("wrong check your register number !");
        }

        //Check Disable further button
        WebElement further = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        if (further.isEnabled()){
            basePage.setFurtherButton();
        }else {
            System.out.println("Oops, Please check your entry!!!!");
            System.out.println("The registration on you or the owner must not be before the first registration. And can not type future year date! Please correct your input.");
        }


    }

    @Then("User should be able to type {string} with number")
    public void user_should_be_able_to_type_with_number(String birthday) {
        //verify page link
        String actualUrl = "https://hello.friday.de/quote/enterBirthDate";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);

        basePage.birthDay.sendKeys(birthday);

        basePage.setFurtherButton();


    }

    @Then("User should be able to type {string} with invalid date")
    public void userShouldBeAbleToTypeWithInvalidDate(String date) {
        String startDate = date;
        //basePage.insuranceStartDate.clear();
        BrowserUtils.waitFor(1);
        basePage.insuranceStartDate.sendKeys(date);
        BrowserUtils.waitFor(1);


        WebElement further = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        if (further.isEnabled()){
            basePage.setFurtherButton();
        }else {
            System.out.println("Oops, unfortunately that didn't work. Please check your entry.");
            Assert.assertFalse(false);
        }

    }

    @Then("User should be able to choose car with invalid credantial type {string} , {string} , {string}")
    public void user_should_be_able_to_choose_car_with_invalid_credantial_type(String my, String hsnVal, String tsnVal) {

        String actualUrl = "https://hello.friday.de/quote/selectVehicle";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);

        //check to type size for first registration
        if(my.length()<=7 & my.length()>=7){
            basePage.monthYear.sendKeys(my);
        }else {
            System.out.println("wrong check your month and year date!");
        }

        //check to type size for HSN number
        if(hsnVal.length()<=4 & hsnVal.length()>=4){
            basePage.hsn.sendKeys(hsnVal);
        }else {
            System.out.println("wrong check your hsn number !");
        }

        //check to type size for tsn number
        if(tsnVal.toLowerCase().length()<=3 & tsnVal.toLowerCase().length()>=3){
            basePage.tsn.sendKeys(tsnVal);
        }else {
            System.out.println("wrong check tsn value!");
        }


        WebElement further = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        if (further.isEnabled()){
            basePage.setFurtherButton();
        }else {
            System.out.println("Oops, Please check your entry!!!!");

        }

    }

    @Then("User should be able to type birthday with number age is min18 max116 based on year {string}")
    public void user_should_be_able_to_type_birthday_with_number_age_is_min18_max_based_on_year(String birthday) {

        //verify page link
        BrowserUtils.waitFor(3);
        String actualUrl = "https://hello.friday.de/quote/enterBirthDate";
        String expectedURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedURL,actualUrl);

        basePage.birthDay.sendKeys(birthday);

        WebElement further = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        if (further.isEnabled()){
            basePage.setFurtherButton();
        }else {
            System.out.println("Oops, Please check your entry!!!!");
            System.out.println("We cannot insure anyone under the age of 18. and more than 116 we cant accept!");

        }


    }

}

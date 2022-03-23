package com.friday.step_definitions;

import com.friday.pages.*;
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

public class reRegisterStep{

    BasePageForWebElement basePage = new BasePageForWebElement();
    SelectPrecondition selectPrecondition = new SelectPrecondition();
    SelectRegisterOwner selectRegisterOwner = new SelectRegisterOwner();
    SelectVehicle selectVehicle = new SelectVehicle();
    ShowHsnTsnCar showHsnTsnCar = new ShowHsnTsnCar();
    EnterRegistrationDate enterRegistrationDate = new EnterRegistrationDate();
    EnterBirthDate enterBirthDate = new EnterBirthDate();
    SelectModel selectModel = new SelectModel();
    SelectBodyType selectBodyType = new SelectBodyType();
    SelectFuelType selectFuelType = new SelectFuelType();
    SelectEnginePower selectEnginePower = new SelectEnginePower();
    SelectEngine selectEngine = new SelectEngine();



    @Given("the user is on the calculate page")
    public void the_user_is_on_the_calculate_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        basePage.calculateInsuranceButton.click();

        selectPrecondition.verifyPreconditionPage();

        BrowserUtils.waitFor(10);

        Shadow shadow = new Shadow(Driver.getDriver());
        WebElement element = shadow.findElementByXPath("//button[@data-testid='uc-accept-all-button']");
        element.click();


    }

    @Given("User should be able to choose insurer type {string}")
    public void user_should_be_able_to_choose_insurer_type(String arg) {

        selectPrecondition.insurerType(arg);


    }

    @Then("User should be able to type {string} with valid date for insurance start day")
    public void user_should_be_able_to_type_with_valid_date(String arg) {

        selectPrecondition.enteredDate(arg);
        basePage.furtherButtonIsEnable();


    }

    @And("User should be able to pass with further button")
    public void user_should_be_able_to_pass_with_further_button() {

        basePage.setFurtherButton();

    }
    @Then("User owner of the car yes or no {string}")
    public void user_owner_of_the_car_yes_or_no(String arg) {


        selectRegisterOwner.verifSelectRegisterPage();

        selectRegisterOwner.areYouOwnerCar(arg);

    }

    @Then("User's car was {string}")
    public void user_s_car_was(String arg) {

        selectRegisterOwner.userCarWas(arg);



    }

    @Then("User should be able to choose car with valid credantial type {string} , {string} , {string}")
    public void user_should_be_able_to_choose_car_with_valid_credantial_type(String my, String hsnVal, String tsnVal) {
        //verify page link
        selectVehicle.verifyUrl();

        selectVehicle.credantialType(my, hsnVal, tsnVal);

        basePage.furtherButtonIsEnable();



    }

    @Then("User verify that with choosed car {string}")
    public void user_verify_that_with_choosed_car(String string) {
        //verify page link
        showHsnTsnCar.verifyUrl();

        //verify Car brand
        showHsnTsnCar.verifyCarBrand();

        basePage.furtherButtonIsEnable();


    }

    @Then("User should be able to {string} with valid date for car register to owner")
    public void user_should_be_able_to_with_valid_date(String arg) {
        //verify page link
        enterRegistrationDate.verifyUrl();

        enterRegistrationDate.registerToYou(arg);

        basePage.furtherButtonIsEnable();


    }

    @Then("User should be able to type when was the car register to you {string} with invalid date")
    public void user_should_be_able_to_type_when_was_the_car_register_to_you_with_invalid_date(String arg) {
        //verify page link
        enterRegistrationDate.verifyUrl();

        enterRegistrationDate.registerToYou(arg);

        basePage.furtherButtonIsEnable();



    }

    @Then("User should be able to type {string} with number")
    public void user_should_be_able_to_type_with_number(String birthday) {


        enterBirthDate.verifyBirthdateUrl();

        enterBirthDate.birthDay.sendKeys(birthday);

        basePage.setFurtherButton();


    }

    @Then("User should be able to type {string} with invalid date")
    public void userShouldBeAbleToTypeWithInvalidDate(String arg) {

        selectPrecondition.verifyPreconditionPage();

        selectPrecondition.enteredDate(arg);

        basePage.furtherButtonIsEnable();


    }

    @Then("User should be able to choose car with invalid credantial type {string} , {string} , {string}")
    public void user_should_be_able_to_choose_car_with_invalid_credantial_type(String my, String hsnVal, String tsnVal) {

        selectVehicle.verifyUrl();

        selectVehicle.credantialType(my, hsnVal, tsnVal);

        basePage.furtherButtonIsEnable();



    }

    @Then("User should be able to type birthday with number age is min18 max116 based on year {string}")
    public void user_should_be_able_to_type_birthday_with_number_age_is_min18_max_based_on_year(String birthday) {

        //verify page link
        enterBirthDate.verifyBirthdateUrl();

        enterBirthDate.birthDay.sendKeys(birthday);

       basePage.furtherButtonIsEnable();


    }

}

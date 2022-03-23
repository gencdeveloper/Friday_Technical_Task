package com.friday.step_definitions;

import com.friday.pages.*;
import com.friday.utilities.BrowserUtils;
import com.friday.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DifferentPathStepDef {

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


    @Then("User should be able to click for find by make & model")
    public void user_should_be_able_to_click_for_find_by_make_model() {

        selectVehicle.searchButton.click();
        Assert.assertTrue(selectVehicle.searchButton.isDisplayed());

    }

    @Then("User should be able to type car brand, {string} and choose it")
    public void user_should_be_able_to_type_car_brand_and_choose_it(String arg) {

        selectVehicle.verifyUrl();

        selectVehicle.carBrand.sendKeys(arg);
        WebElement list = Driver.getDriver().findElement(By.cssSelector("#root > div > div:nth-child(2) > div > div.WizardTransitionContainer__transitionGroupWrapper--BwlEY > div > div:nth-child(2) > div > form > div:nth-child(2) > div:nth-child(2) > div.SingleClickListField__container--nJMNk > button > div > div.SingleClickListField__infoBlock--IEVkY > label"));
        String listText = list.getText();
        System.out.println("Car Brand = " + listText);

        Assert.assertEquals(arg.toUpperCase(),listText);

        list.click();

    }

    @Then("User should be able to type car model, {string} and choose it")
    public void user_should_be_able_to_type_car_model_and_choose_it(String arg) {
        //verify current url
        selectModel.verifyUrl();

        //take to parameter
        selectModel.carModel.sendKeys(arg);

        //click try to passed parameter
        selectModel.mdlList.click();

        //show selected car
        String modelListText = selectModel.mdlList.getText();
        System.out.println("Car Model = " + modelListText);

        Assert.assertEquals(arg.toUpperCase(),modelListText.toUpperCase());





    }

    @Then("User should be able to choose which type of use fueling {string}")
    public void user_should_be_able_to_choose_which_type_of_use_fueling(String arg) {
        //verify page
        selectFuelType.verifyUrl();

        //verify the list and catch to argument
        selectFuelType.listTextforFuelType(arg);


    }

    @Then("User should be able to choose how many hp does your car have {string}")
    public void user_should_be_able_to_choose_how_many_hp_does_your_car_have(String arg) {

        //verify page
        selectEnginePower.verifyUrl();

        //verify the list for engine power and catch to argument
        selectEnginePower.listTextforEnginePower(arg);



    }

    @Then("User should be able to check and select which car inclued for him")
    public void user_should_be_able_to_check_and_select_which_car_inclued_for_him() {

        System.out.println("firstCar = " + selectEngine.firstCar.getText());

        selectEngine.firstCar.click();

    }

    @Then("User should be able to type when was the first registration {string}")
    public void user_should_be_able_to_type_when_was_the_first_registration(String arg) {
        //verify the page
        enterRegistrationDate.verifyUrl();

        enterRegistrationDate.registerDate(arg);

    }

    @Then("User should be able to chose what kind of shape is {string}")
    public void user_should_be_able_to_chose_what_kind_of_shape_is(String arg) {
        //verify the page
        selectBodyType.verifyUrl();

        //verify the list and cath to argument
        selectBodyType.listText(arg);


    }


}

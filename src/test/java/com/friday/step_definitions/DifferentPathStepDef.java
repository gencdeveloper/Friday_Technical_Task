package com.friday.step_definitions;

import com.friday.pages.BasePageForWebElement;
import com.friday.utilities.BrowserUtils;
import com.friday.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DifferentPathStepDef {

    BasePageForWebElement basePage = new BasePageForWebElement();

    @Then("User should be able to click for find by make & model")
    public void user_should_be_able_to_click_for_find_by_make_model() {

        basePage.searchButton.click();
        Assert.assertTrue(basePage.searchButton.isDisplayed());

    }

    @Then("User should be able to type car brand, {string} and choose it")
    public void user_should_be_able_to_type_car_brand_and_choose_it(String arg) {

        //verify page link
        String actualUrl = "https://hello.friday.de/quote/selectVehicle";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);

        basePage.carBrand.sendKeys(arg);
        WebElement list = Driver.getDriver().findElement(By.cssSelector("#root > div > div:nth-child(2) > div > div.WizardTransitionContainer__transitionGroupWrapper--BwlEY > div > div:nth-child(2) > div > form > div:nth-child(2) > div:nth-child(2) > div.SingleClickListField__container--nJMNk > button > div > div.SingleClickListField__infoBlock--IEVkY > label"));
        String listText = list.getText();
        System.out.println("Car Brand = " + listText);

        Assert.assertEquals(arg.toUpperCase(),listText);

        list.click();

    }

    @Then("User should be able to type car model, {string} and choose it")
    public void user_should_be_able_to_type_car_model_and_choose_it(String arg) {
        //verify page link
        BrowserUtils.waitFor(3);
        String actualUrl = "https://hello.friday.de/quote/selectModel";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);

        basePage.carModel.sendKeys(arg);
        WebElement mdlList = Driver.getDriver().findElement(By.xpath("//div[@class='SingleClickListField__infoBlock--IEVkY']"));
        String modelListText = mdlList.getText();
        System.out.println("Car Model = " + modelListText);

        Assert.assertEquals(arg.toUpperCase(),modelListText.toUpperCase());

        mdlList.click();


    }

    @Then("User should be able to choose which type of use fueling {string}")
    public void user_should_be_able_to_choose_which_type_of_use_fueling(String arg) {
        BrowserUtils.waitFor(3);
        String actualUrl = "https://hello.friday.de/quote/selectFuelType";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);

        List<WebElement> listElement = Driver.getDriver().findElements(By.xpath("//button[@name='fuelType']"));
        for(int i =0;i<listElement.size();i++) {
            String elementText = listElement.get(i).getText();
            System.out.println(elementText);

            if (elementText.toLowerCase().contentEquals(arg.toLowerCase())){
                BrowserUtils.waitFor(2);
                listElement.get(i).click();
                System.out.println(i);
                BrowserUtils.waitFor(2);
                break;

            }else {
                System.out.println("not yet found!");
            }

        }




    }

    @Then("User should be able to choose how many hp does your car have {string}")
    public void user_should_be_able_to_choose_how_many_hp_does_your_car_have(String arg) {
        BrowserUtils.waitFor(3);
        List<WebElement> listElement = Driver.getDriver().findElements(By.xpath("//button[@name='enginePower']"));
        for(int i =0;i<listElement.size();i++) {
            String elementText = listElement.get(i).getText();
            System.out.println(elementText);

            if (elementText.contentEquals(arg)){
                BrowserUtils.waitFor(2);
                listElement.get(i).click();
                System.out.println(i);
                BrowserUtils.waitFor(2);
                break;

            }else {
                System.out.println("not yet found!");
            }

        }

    }

    @Then("User should be able to check and select which car inclued for him")
    public void user_should_be_able_to_check_and_select_which_car_inclued_for_him() {

        WebElement firstCar = Driver.getDriver().findElement(By.xpath("//button[@name='engine']"));

        System.out.println("firstCar = " + firstCar.getText());

        firstCar.click();

    }

    @Then("User should be able to type when was the first registration {string}")
    public void user_should_be_able_to_type_when_was_the_first_registration(String registerDate) {
        //verify page link
        BrowserUtils.waitFor(2);
        String actualUrl = "https://hello.friday.de/quote/enterRegistrationDate";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);


        if(registerDate.length()<=7 & registerDate.length()>=7){
            basePage.firstRegisterDate.sendKeys(registerDate);
        }else {
            System.out.println("wrong check your register number !");
        }

        basePage.setFurtherButton();

    }

    @Then("User should be able to chose what kind of shape is {string}")
    public void user_should_be_able_to_chose_what_kind_of_shape_is(String arg) {
        //verify page link
        BrowserUtils.waitFor(2);
        String actualUrl = "https://hello.friday.de/quote/selectBodyType";
        String expectedtURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedtURL,actualUrl);

        List<WebElement> listElement = Driver.getDriver().findElements(By.xpath("//button[@name='bodyType']"));

        for(int i =0;i<listElement.size();i++) {
            String elementText = listElement.get(i).getText();

            System.out.println(elementText);

            if (elementText.toLowerCase().contentEquals(arg.toLowerCase())){
                BrowserUtils.waitFor(2);
                listElement.get(i).click();
                System.out.println(i);
                BrowserUtils.waitFor(2);
                break;

            }else {
                System.out.println("not yet found!");
            }

        }
    }


}

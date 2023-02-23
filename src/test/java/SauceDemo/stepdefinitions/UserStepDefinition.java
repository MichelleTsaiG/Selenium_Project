package SauceDemo.stepdefinitions;

import SauceDemo.steps.UserSauceDemo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class UserStepDefinition {

    @Steps(shared = true)
    UserSauceDemo user;
    public static String usernameHere;

    public static String passwordHere;

    @Given("^user navigates to https://www.saucedemo.com/$")
    public void userNavigatesToPage(){
        user.navigateTo();
        Serenity.takeScreenshot();
    }

    @Given("^user inputs (.*) and (.*)$")
    public void userInputsUserAndPass(String username, String password){
        usernameHere = username;
        passwordHere = password;
        user.inputUserAndPass(username, password);
        Serenity.takeScreenshot();
    }

    @And("^selects Login$")
    public void selectsLogin(){
        user.selectsLogin();
        Serenity.takeScreenshot();
    }

    @Then("^User selects About tab$")
    public void selectsAbout(){
        user.selectsAbout();
        Serenity.takeScreenshot();
    }

    @Given("^returns to items page$")
    public void returnToItems(){
        user.navigateTo();
        user.inputUserAndPass(usernameHere, passwordHere);
        user.selectsLogin();
        Serenity.takeScreenshot();
    }

    @When("^filters items from least to most expensive$")
    public void filterItems(){
        user.filterItems();
        Serenity.takeScreenshot();
    }

    @And("^adds the four most expensive items from the list to the cart$")
    public void addItems(){
        user.addItems();
        Serenity.takeScreenshot();
    }

    @Then("^go to the checkout cart$")
    public void goToCart() throws InterruptedException {
        user.goToCart();
        Serenity.takeScreenshot();
    }

    @Then("^go to the user input page$")
    public void goToCheckout(){
        user.goToCheckout();
        Serenity.takeScreenshot();
    }

    @Then("^input (.*), (.*), and (.*)$")
    public void inputCheckout(String firstName, String lastName, String postalCode){
        user.inputCheckout(firstName, lastName, postalCode);
        Serenity.takeScreenshot();
    }

    @Then("^check and verify information$")
    public void continueAndVerify() throws InterruptedException {
        user.continueAndVerify();
        Serenity.takeScreenshot();
    }

    @Then("^finalize checkout$")
    public void finishAndVerify() throws InterruptedException {
        user.finishAndVerify();
        Serenity.takeScreenshot();
    }


}

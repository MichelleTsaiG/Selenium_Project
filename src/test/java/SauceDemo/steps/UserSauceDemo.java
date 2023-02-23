package SauceDemo.steps;

import SauceDemo.pageobject.MainPage;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Steps;

public class UserSauceDemo extends ScenarioActor {

    @Steps(shared = true)
    MainPage mainPage;

    public void navigateTo(){
        mainPage.setDefaultBaseUrl("https://www.saucedemo.com/");
        mainPage.open();
    }

    public void inputUserAndPass(String username, String password){
        mainPage.inputUserAndPass(username, password);
    }

    public void selectsLogin(){
        mainPage.loginToSite();
    }

    public void selectsAbout(){
        mainPage.selectAbout();
    }

    public void filterItems(){
        mainPage.filterItems();
    }

    public void addItems(){
        mainPage.addItems();
    }

    public void goToCart() throws InterruptedException {
        mainPage.goToCart();
    }

    public void goToCheckout(){
        mainPage.goToCheckout();
    }

    public void inputCheckout(String firstName, String lastName, String postalCode){
        mainPage.inputCheckout(firstName, lastName, postalCode);
    }

    public void continueAndVerify() throws InterruptedException {
        mainPage.continueAndVerify();
    }

    public void finishAndVerify() throws InterruptedException {
        mainPage.finishAndVerify();
    }

}

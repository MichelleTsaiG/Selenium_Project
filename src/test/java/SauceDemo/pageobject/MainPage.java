package SauceDemo.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends PageObject {

    @FindBy(id = "user-name")
    WebElementFacade inputUsername;

    @FindBy(id = "password")
    WebElementFacade inputPassword;

    @FindBy(id = "login-button")
    WebElementFacade loginBttn;

    @FindBy(id = "react-burger-menu-btn")
    WebElementFacade menuBttn;

    @FindBy(id = "about_sidebar_link")
    WebElementFacade aboutBttn;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")
    WebElementFacade selectFilter;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElementFacade addFirst;

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    WebElementFacade addSecond;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElementFacade addThird;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElementFacade addFourth;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    WebElementFacade checkCart;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElementFacade cartBttn;

    @FindBy(xpath = "//*[@id=\"item_1_title_link\"]/div")
    WebElementFacade firstItem;

    @FindBy(xpath = "//*[@id=\"item_3_title_link\"]/div")
    WebElementFacade secondItem;

    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    WebElementFacade thirdItem;

    @FindBy(xpath = "//*[@id=\"item_5_title_link\"]/div")
    WebElementFacade fourthItem;

    @FindBy(id = "checkout")
    WebElementFacade checkoutBttn;

    @FindBy(id = "first-name")
    WebElementFacade firstName;

    @FindBy(id = "last-name")
    WebElementFacade lastName;

    @FindBy(id = "postal-code")
    WebElementFacade postalCode;

    @FindBy(id = "continue")
    WebElementFacade continueBttn;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    WebElementFacade firstPrice;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")
    WebElementFacade secondPrice;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[5]/div[2]/div[2]/div")
    WebElementFacade thirdPrice;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[6]/div[2]/div[2]/div")
    WebElementFacade fourthPrice;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[2]")
    WebElementFacade payment;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[4]")
    WebElementFacade shipping;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]")
    WebElementFacade totalPrice;

    @FindBy(id = "finish")
    WebElementFacade finishBttn;

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]")
    WebElementFacade successMsg;

    public void inputUserAndPass(String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
    }

    public void loginToSite(){
        loginBttn.click();
    }

    public void selectAbout(){
        menuBttn.click();
        aboutBttn.click();
    }

    public void returnToItems(String username, String password){
        inputUserAndPass(username, password);
        loginToSite();
    }

    public void filterItems(){
        selectFilter.click();
    }

    public void addItems(){
        addFirst.click();
        addSecond.click();
        addThird.click();
        addFourth.click();
        String expectedValue = "4";
        Assert.assertEquals(expectedValue, checkCart.getText());
        System.out.println("The amount of items in the cart match the expected value");
    }

    public void goToCart() throws InterruptedException {
        cartBttn.click();
        Thread.sleep(3000);
        String firstItemDetails = "The first item is: " + firstItem.getText();
        String secondItemDetails = "The second item is: " + secondItem.getText();
        String thirdItemDetails = "The third item is: " + thirdItem.getText();
        String fourthItemDetails = "The fourth item is: " + fourthItem.getText();
        String details = firstItemDetails + "\n" + secondItemDetails + "\n" + thirdItemDetails + "\n" + fourthItemDetails;
        Serenity.recordReportData().withTitle("Names of the Items in the Cart").andContents(details);
    }

    public void goToCheckout(){
        checkoutBttn.click();
    }

    public void inputCheckout(String firstN, String lastN, String postalC){
        firstName.sendKeys(firstN);
        lastName.sendKeys(lastN);
        postalCode.sendKeys(postalC);
    }

    public void continueAndVerify() throws InterruptedException {
        continueBttn.click();
        Thread.sleep(3000);
        String firstItemPrice = firstItem.getText() + " is: " + firstPrice.getText();
        String secondItemPrice = secondItem.getText() + " is: " + secondPrice.getText();
        String thirdItemPrice = thirdItem.getText() + " is: " + thirdPrice.getText();
        String fourthItemPrice = fourthItem.getText() + " is: " + fourthPrice.getText();
        String paymentInfo = "Payment Information: " + payment.getText();
        String shippingInfo = "Shipping Information: " + shipping.getText();
        String totalPriceInfo = totalPrice.getText();
        String details = firstItemPrice + "\n" + secondItemPrice + "\n" + thirdItemPrice + "\n" + fourthItemPrice +
                "\n" + paymentInfo + "\n" + shippingInfo + "\n" + totalPriceInfo;
        String expectedPrice = "Total: $120.92";
        Assert.assertEquals(expectedPrice, totalPriceInfo);
        System.out.println("The total price is what is expected");
        Serenity.recordReportData().withTitle("Full Checkout Cart Details").andContents(details);
    }

    public void finishAndVerify() throws InterruptedException {
        finishBttn.click();
        Thread.sleep(3000);
        Assert.assertTrue(successMsg.isPresent());
        System.out.println("The success message is visible!");
    }

}

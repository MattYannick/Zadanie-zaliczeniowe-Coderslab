package ZadanieZaliczeniowe2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement submitTotal;

    @FindBy(name = "confirm-addresses")
    private WebElement submitAddresses;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmDeliveryOption;

    @FindBy(id = "payment-option-1")
    private WebElement paymentOption;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement agreeToTheTermsOfService;

    @FindBy(xpath = "//button[@class='btn btn-primary center-block']")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//span[@class='value']")
    private WebElement totalPriceInCart;

    public void shoppingCart() throws InterruptedException {
        submitTotal.click();
        submitAddresses.click();
        confirmDeliveryOption.click();
        paymentOption.click();
        agreeToTheTermsOfService.click();
        placeOrderButton.click();
    }
}

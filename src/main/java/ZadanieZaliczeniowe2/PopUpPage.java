package ZadanieZaliczeniowe2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopUpPage {
    private WebDriver driver;

    public PopUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement proceedToCheckoutButton;

    public void proceedToCheckout(){
        proceedToCheckoutButton.click();
    }
}

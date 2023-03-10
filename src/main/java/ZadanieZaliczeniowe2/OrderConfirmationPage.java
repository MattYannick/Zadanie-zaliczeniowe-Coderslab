package ZadanieZaliczeniowe2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

        private WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='price']")
    private WebElement totalPriceInOrderConfirmation;

    @FindBy(className = "account")
    private WebElement userAccountField;

    public String getTotalPriceInOrderConfirmation(){
    return totalPriceInOrderConfirmation.getText();
    }

    public void goToUserAccount(){
        userAccountField.click();
        }
    }



package ZadanieZaliczeniowe1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {

    private WebDriver driver;

    public YourAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Addresses']")
    private WebElement addressesButtton;

    public void clickAddressesButton(){
        addressesButtton.click();
    }
}

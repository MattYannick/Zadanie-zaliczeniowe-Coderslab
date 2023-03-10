package ZadanieZaliczeniowe1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddresses {

    private WebDriver driver;

    public YourAddresses(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//article[@class='alert alert-success']")
    private WebElement addressData;

    @FindBy(xpath = "//div[2]/article/div[2]//a[2]")
    private WebElement deleteButton;

    @FindBy(xpath = "//article[@class='alert alert-success']")
    private WebElement succesDeleteBanner;

    @FindBy(xpath = "//a[@data-link-action='add-address']")
    private WebElement addAddress;

    public void clickAddAddress() {
        addAddress.click();
    }

    public String showAddressData(){
        return addressData.getText();
    }

    public void deleteAddress(){
        deleteButton.click();
    }

    public String deleteAddressInformation(){
        return succesDeleteBanner.getText();
    }
}

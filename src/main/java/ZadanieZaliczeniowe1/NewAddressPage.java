package ZadanieZaliczeniowe1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage {

    private WebDriver driver;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="field-alias")
    private WebElement aliasField;

    @FindBy(id="field-address1")
    private WebElement addressField;

    @FindBy(id="field-city")
    private WebElement cityField;

    @FindBy(id="field-postcode")
    private WebElement postalCodeField;

    @FindBy(id="field-id_country")
    private WebElement countryField;



    @FindBy(id="field-phone")
    private WebElement phoneField;

    @FindBy(xpath = "//button[@class='btn btn-primary form-control-submit float-xs-right']")
    private WebElement saveButton;

    public void addNewAddresses(String aliasUser, String addressUser, String cityUser, String postalCodeUser, String countryUser, String phoneUser) {
        aliasField.clear();
        aliasField.sendKeys(aliasUser);

        addressField.clear();
        addressField.sendKeys(addressUser);

        cityField.clear();
        cityField.sendKeys(cityUser);

        postalCodeField.clear();
        postalCodeField.sendKeys(postalCodeUser);

        Select myCountry = new Select(countryField);
        myCountry.selectByVisibleText(countryUser);


        phoneField.clear();
        phoneField.sendKeys(phoneUser);


        saveButton.click();
    }

}

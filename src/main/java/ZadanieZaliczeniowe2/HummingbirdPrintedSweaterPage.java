package ZadanieZaliczeniowe2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HummingbirdPrintedSweaterPage {

    private WebDriver driver;

    public HummingbirdPrintedSweaterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[@class='discount discount-percentage']")
    private WebElement saleBanner;

    @FindBy(id = "group_1")
    private WebElement sizeButton;

    @FindBy(xpath = "//button[@class='btn btn-touchspin js-touchspin bootstrap-touchspin-up']")
    private WebElement quantityButton;

    @FindBy(xpath = "//button[@data-button-action='add-to-cart']")
    private WebElement addToCartButton;

    public String saleInformation() {
        return saleBanner.getText();
    }

    public void yourSweater(String userSize, String userQuantity) {

        Select selectSize = new Select(sizeButton);
        selectSize.selectByVisibleText(userSize);

        int quantutyToInt = Integer.parseInt(userQuantity);
        for (int i = 1; i < quantutyToInt; i++) {
            quantityButton.click();
        }

        addToCartButton.click();


    }
}




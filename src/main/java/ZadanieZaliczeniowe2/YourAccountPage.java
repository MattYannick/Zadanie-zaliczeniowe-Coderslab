package ZadanieZaliczeniowe2;

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

    @FindBy(xpath = "//a[@data-depth='0']")
    private WebElement clothesButton;

    @FindBy(xpath = "//a[3]/span[@class='link-item']")
    private WebElement orderHistoryAndDetailsButton;

    public void chooseClothes(){
        clothesButton.click();
    }

    public void goToOrderHistoryAndDetails(){
        orderHistoryAndDetailsButton.click();
    }

}

package ZadanieZaliczeniowe2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClothesPage {

    private WebDriver driver;

    public ClothesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@alt='Brown bear printed sweater']")
    private WebElement hummungbirdPrintedSweater;

    public void chooseSweater() {
        hummungbirdPrintedSweater.click();
    }
}

package ZadanieZaliczeniowe2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHIstoryPage {
    private WebDriver driver;

    public OrderHIstoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='label label-pill bright']")
    private WebElement inoviceField;

    @FindBy(xpath = "//td[@class='text-xs-right']")
    private WebElement totalPriceField;

    public String getInvoice(){
       return inoviceField.getText();
    }

    public String getTotalPrice(){
        return totalPriceField.getText();
    }
}

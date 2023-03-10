package ZadanieZaliczeniowe1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInToYourAccountPage {

    private WebDriver driver;

    public LogInToYourAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "field-email")
    private WebElement email;

    @FindBy(id = "field-password")
    private WebElement password;

    @FindBy(id = "submit-login")
    private WebElement submitLogin;

    public void userLogin(String emailToLog, String passToLog){
        email.clear();
        email.sendKeys(emailToLog);

        password.clear();
        password.sendKeys(passToLog);

        submitLogin.click();
    }
}

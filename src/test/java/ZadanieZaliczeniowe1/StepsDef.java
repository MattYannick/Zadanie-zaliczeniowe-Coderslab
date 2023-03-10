package ZadanieZaliczeniowe1;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class StepsDef {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        // wgrywanie sterowników dla przeglądarki Chrome
        System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/msedgedriver.exe");
        driver = new EdgeDriver();


        // maksymalizowanie okna przeglądarki
        driver.manage().window().maximize();

        // ustawianie czasu (w sekundach) oczekiwania na ładowanie elementów strony
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ustawianie stroy od której zaczyna się test - w naszym przypadku jest to strona główna MyStore
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @After
    // ustawianie zamknięcia testu po pozytywnym zakończeniu testu
    public void cleanUp(){driver.quit();}

    @When("the user logs in to his account by entering {} and {}")
    public void logIn(String email, String password) {
        // przejście ze strony głownej na strone logowania
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignInButton();

        // logowanie się poprawnymi danymi (email & password) na konta klienta
        LogInToYourAccountPage logInToYourAccountPage = new LogInToYourAccountPage(driver);
        logInToYourAccountPage.userLogin(email, password);

        // przejście do postrony "Your account"
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.clickAddressesButton();

        // przejście do posdtrony zawierającej możliwośc dodania nowego adresu
        YourAddresses yourAddressesPage = new YourAddresses(driver);
        yourAddressesPage.clickAddAddress();
    }

    @When("the user adds a new address by completing the required fields: {}, {}, {}, {}, {}, {}")
    public void addFirstAddress(String alias, String address, String city, String postalCode, String country, String phone) {
        // dodanie nowego adresu poprzez wypełnienia formularza poprawnymi danymi
        NewAddressPage newAddressPage = new NewAddressPage(driver);
        newAddressPage.addNewAddresses(alias, address, city, postalCode, country, phone );
    }

    @When("the user checks whether the address has been added correctly, then removes it by checking whether it has been removed correctly")
    public void check() {
        // sprawdzenie czy dane w dodanym adresie są poprawne
        YourAddresses yourAddressesWithAdress = new YourAddresses(driver);
        Assert.assertEquals("Address successfully added!", yourAddressesWithAdress.showAddressData());
        // usunięcie dodanego adresu oraz sprawdzenie czy adres został usunięty
        yourAddressesWithAdress.deleteAddress();
        Assert.assertEquals("Address successfully deleted!", yourAddressesWithAdress.deleteAddressInformation());
    }
}

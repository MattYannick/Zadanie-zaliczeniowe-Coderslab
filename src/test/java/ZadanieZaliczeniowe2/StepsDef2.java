package ZadanieZaliczeniowe2;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class StepsDef2 {
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
    public void logIn(String email, String password){
        // przejście ze strony głownej na strone logowania
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignInButton();

        // logowanie się poprawnymi danymi (email & password) na konta klienta
        LogInToYourAccountPage logInToYourAccountPage = new LogInToYourAccountPage(driver);
        logInToYourAccountPage.userLogin(email, password);
    }

    @When("the user selects the product, parameterizes it with {} and {} goes through the entire product purchase process")
    public void addOrder(String size, String quantity) throws IOException, InterruptedException {
        // przejśćie z podstrony "Your account" do podstrony z ubraniami
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.chooseClothes();

        // przejście z podstrony z ubraniami do podstrony z wybranym produktem, w tym przypadku produkt to: HUMMINGBIRD PRINTED SWEATER
        ClothesPage clothesPage = new ClothesPage(driver);
        clothesPage.chooseSweater();

        // spawrdzenie czy na produkt HUMMINGBIRD PRINTED SWEATER obowiązuje zniżka 20%
        HummingbirdPrintedSweaterPage hummingbirdPrintedSweaterPage = new HummingbirdPrintedSweaterPage(driver);
        Assert.assertEquals("SAVE 20%", hummingbirdPrintedSweaterPage.saleInformation());

        // personalizacja produktu poprzez wybranie rozmiaru (size) oraz ilości (quantity), a nastepnie dodanie produktu do koszyka
        hummingbirdPrintedSweaterPage.yourSweater(size, quantity);

        // poczekanie na pojawienie się popUp-a z informacją o powterdzeniu dodania produktu do koszyka
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModalLabel")));

        // przejście z popUp-u do podstrony z dokończeniem płatności
        PopUpPage popUpPage = new PopUpPage(driver);
        popUpPage.proceedToCheckout();

        // przejście przez całą procedurę dokończenia zakupu - wybranie opcji checkout, potwerdzenie adresu,
        // wybranie sposobu dostawy produktu, wybranie metody płatności oraz potwerdzenie warunków usługi oraz złożenie zamówienia
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.shoppingCart();

        // wykonanie screenshot-a (nazwa: screen.png) z powterdzeniem zamówienia i kwotą, zapisanie go w folderze "screenshot"
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshot/screen.png"));

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        // pobranie kwoty zamówienia z podstrony z potwerdzeniem złożenia zamówienia
        String price1 = orderConfirmationPage.getTotalPriceInOrderConfirmation();

        // przejście do podstrony konta użytkownika
        orderConfirmationPage.goToUserAccount();

        // przejście do podstrony z historią oraz szczegółami zamówień danegi klineta
        yourAccountPage.goToOrderHistoryAndDetails();

        OrderHIstoryPage orderHIstoryPage = new OrderHIstoryPage(driver);
        // spawrdzenie czy zamówienie jest ze statutem "Awaiting check payment"
        Assert.assertEquals("Awaiting check payment", orderHIstoryPage.getInvoice());
        // prównanie kwoty zamówienia z podstron: z potwerdzeniem złożenia zamówienia oraz ze szczegółami zamówienia
        Assert.assertEquals(price1, orderHIstoryPage.getTotalPrice());





    }


}

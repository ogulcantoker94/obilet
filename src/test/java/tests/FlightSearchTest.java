package tests;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.FlightPage;
import pages.HomePage;
import pages.PaymentPage;

import java.time.Duration;

public class FlightSearchTest extends BaseTest{

    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    HomePage home = new HomePage(driver, wait);
    FlightPage flight = new FlightPage(driver,js,wait);
    PaymentPage payment = new PaymentPage(driver,js,wait);
    String departureCode;
    String arrivalCode;

    @Test
    public void flightSearch() throws InterruptedException {
        driver.get(baseURL);
        home.clickFlight();
        flight.acceptCookies();
        flight.onewayCheck();
        flight.searchDeparture();
        flight.selectDeparture();
        flight.searchArrival();
        flight.selectArrival();
        flight.clickSearchFlight();
        flight.clickCloseCampaignPopUp();
        flight.checkFlightList();
        departureCode = flight.checkDepartureDetails();
        flight.closeDetailPopup();
        flight.clickFirstDepartureFlight();
        flight.clickDepartureEcoFlight();
        arrivalCode = flight.checkArrivalDetails();
        flight.closeDetailPopup();
        flight.clickFirstArrivalFlight();
        flight.clickArrivalEcoFlight();
        payment.checkPaymentPage(departureCode,arrivalCode);
    }
}

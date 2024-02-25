package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FlightPage {

    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    public FlightPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait){
        this.driver = driver;
        this.js = js;
        this.wait = wait;
    }

    By departureInput = By.cssSelector("#origin-input");
    By departureList = By.cssSelector(".results li");
    By arrivalInput = By.cssSelector("#destination-input");
    By arrivalList = By.cssSelector(".results li");
    By onewayCheckbox = By.cssSelector(".box.flight-check");
    By acceptCookieBtn = By.cssSelector("#accept");
    By FlightList = By.cssSelector("#outbound-journeys");
    By departureFirstFlight = By.cssSelector("#outbound-journeys li");
    By arrivalFirstFlight = By.cssSelector("#return-journeys li");
    By departureEcoFlight = By.cssSelector(".details.row li li div div");
    By arrivalEcoFlight = By.cssSelector("#return-journeys .details.row li li div div");
    By campaignPopupBtn = By.cssSelector("#close-button-1454703513202");
    By departureDetailBtn = By.cssSelector("#outbound-journeys li div button");
    By flightCode = By.cssSelector(".code.col strong");
    By arrivalDetailBtn = By.cssSelector("#return-journeys li div button");
    By departureAirlineName = By.cssSelector("#outbound-journeys li div div div span");
    By arrivalAirlineName = By.cssSelector("#return-journeys li div div div span");
    By closeDetailBtn = By.cssSelector(".ob-modal.normal.pop.details-modal.active.open button");


    public void searchDeparture(){
        wait.until(ExpectedConditions.elementToBeClickable(departureInput));
        driver.findElement(departureInput).click();
        driver.findElement(departureInput).sendKeys("istanbul");
    }

    public void selectDeparture() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(departureList));
        driver.findElement(departureList).click();
    }

    public void searchArrival(){
        wait.until(ExpectedConditions.elementToBeClickable(arrivalInput));
        driver.findElement(arrivalInput).click();
        driver.findElement(arrivalInput).sendKeys("istanbul");
    }

    public void selectArrival() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(arrivalList));
        driver.findElement(arrivalList).click();
    }

    public void onewayCheck(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(onewayCheckbox));
        driver.findElement(onewayCheckbox).click();
    }

    public void acceptCookies(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieBtn));
        driver.findElement(acceptCookieBtn).click();
    }

    public void clickSearchFlight(){
        wait.until(ExpectedConditions.javaScriptThrowsNoExceptions("document.querySelector('#search-button').click()"));
    }

    public void checkFlightList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(FlightList));
        Assert.assertEquals(driver.findElement(FlightList).getAttribute("class"),"list container visible active");
    }

    public void clickFirstArrivalFlight(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(arrivalFirstFlight));
        driver.findElement(arrivalFirstFlight).click();
    }

    public void clickFirstDepartureFlight(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(departureFirstFlight));
        driver.findElement(departureFirstFlight).click();
    }

    public void clickDepartureEcoFlight(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(departureEcoFlight));
        driver.findElement(departureEcoFlight).click();
    }

    public void clickArrivalEcoFlight(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(arrivalEcoFlight));
        driver.findElement(arrivalEcoFlight).click();
    }

    public void clickCloseCampaignPopUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(campaignPopupBtn));
        driver.findElement(campaignPopupBtn).click();
    }

    public String checkDepartureDetails(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(departureDetailBtn));
        driver.findElement(departureDetailBtn).click();
        return driver.findElement(departureAirlineName).getText() + " - " + driver.findElement(flightCode).getText();
    }

    public void closeDetailPopup(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeDetailBtn));
        driver.findElement(closeDetailBtn).click();
    }

    public String checkArrivalDetails(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(arrivalDetailBtn));
        driver.findElement(arrivalDetailBtn).click();
        return driver.findElement(arrivalAirlineName).getText() + " - " + driver.findElement(flightCode).getText();
    }


}

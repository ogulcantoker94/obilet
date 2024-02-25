package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PaymentPage {
    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    public PaymentPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait){
        this.driver = driver;
        this.js = js;
        this.wait = wait;
    }

    By paymentPageText = By.cssSelector("#payment label");
    By dprCode = By.cssSelector(".partner-info strong");
    By arrCode = By.cssSelector(".journey tbody:nth-child(2) strong");

    public void checkPaymentPage(String departureCode, String arrivalCode){
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentPageText));
        Assert.assertEquals(driver.findElement(paymentPageText).getText(),"ÖDEME BİLGİLERİ");
        Assert.assertEquals(driver.findElement(dprCode).getText(), departureCode);
        Assert.assertEquals(driver.findElement(arrCode).getText(), arrivalCode);
    }
}

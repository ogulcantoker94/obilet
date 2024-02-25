package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage  {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    By loginBtn = By.className("login");

    public void clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        driver.findElement(loginBtn).click();
    }

    public void clickFlight(){
        wait.until(ExpectedConditions.javaScriptThrowsNoExceptions("document.querySelectorAll('.menu.left li a')[1].click()"));
    }
}


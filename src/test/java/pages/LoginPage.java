package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    public LoginPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait){
        this.driver = driver;
        this.js = js;
        this.wait = wait;
    }

    public void clickMoveToSignUp(){
        wait.until(ExpectedConditions.javaScriptThrowsNoExceptions("document.querySelector('.sign-up').click()"));
    }
}

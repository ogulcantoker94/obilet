package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignUpPage {
    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    public SignUpPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait){
        this.driver = driver;
        this.js = js;
        this.wait = wait;
    }

    By mailField = By.cssSelector(".email input");
    By passwordField = By.cssSelector(".password input");
    By myProfile = By.cssSelector(".user-name span");

    public void clickSignUp() {
        wait.until(ExpectedConditions.javaScriptThrowsNoExceptions("document.querySelector('.register.register-button').click()"));
    }

    public void setMail(String mail){
        wait.until(ExpectedConditions.visibilityOfElementLocated(mailField));
        driver.findElement(mailField).sendKeys(mail);
        System.out.println(mail);
    }

    public void setPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public void checkSignIn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(myProfile));
        Assert.assertEquals(driver.findElement(myProfile).getText(),"Hesabım");
    }
}

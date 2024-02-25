package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;
import utils.MailGenerator;

import java.time.Duration;

public class SignUpTest extends BaseTest{

    MailGenerator mg = new MailGenerator();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    HomePage home = new HomePage(driver, wait);
    LoginPage login = new LoginPage(driver, js, wait);
    SignUpPage signUp = new SignUpPage(driver,js,wait);

    @Test
    public void signUpTest() throws InterruptedException {
        driver.get(baseURL);
        home.clickLogin();
        login.clickMoveToSignUp();
        signUp.setMail(mg.generateMail());
        signUp.setPassword("Test123.");
        Thread.sleep(2000);
        signUp.clickSignUp();
        signUp.checkSignIn();
    }
}

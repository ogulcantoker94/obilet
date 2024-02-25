package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {

    public WebDriver driver;
    public ChromeOptions co;
    public String baseURL;

    public BaseTest() {
        co = new ChromeOptions();
        co.addArguments("--disable-notifications");
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        baseURL = "https://obilet.com";
    }

    @BeforeClass
    void Before() {
        //co.addArguments("--disable-notifications");
       // driver.manage().window().maximize();
       // baseURL = "https://obilet.com";
    }

    @AfterClass
    void After() {
        driver.quit();
    }

}


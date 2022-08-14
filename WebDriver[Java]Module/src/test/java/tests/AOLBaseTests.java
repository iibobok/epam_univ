package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.AOLMailbox;
import pages.AOLLoginPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class AOLBaseTests {
    private WebDriver driver;
    private static final String EMAIL_URL = "https://mail.aol.com";

    @BeforeTest
    public void profileSetUP() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUP() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(EMAIL_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public AOLLoginPage getLoginPage() { return new AOLLoginPage(getDriver()); }

    public AOLMailbox getAOLMailbox() { return new AOLMailbox(getDriver()); }

}


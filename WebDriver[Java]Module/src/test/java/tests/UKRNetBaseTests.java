package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.UKRNetLoginPage;
import pages.UKRNetMailbox;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class UKRNetBaseTests {
    private WebDriver driver;
    private static final String AVIC_URL = "http://mail.ukr.net";

    @BeforeTest
    public void profileSetUP() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUP() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AVIC_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public UKRNetLoginPage getUKRNetLoginPage() { return new UKRNetLoginPage(getDriver()); }

    public UKRNetMailbox getUKRNetMailbox() { return new UKRNetMailbox(getDriver()); }

}


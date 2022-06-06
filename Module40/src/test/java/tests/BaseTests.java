package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.MailBoxPage;


import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTests {
    private WebDriver driver;
    private static final String GMAIL_URL = "https://mail.google.com/";

    @BeforeTest
    public void profileSetUP() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUP() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(GMAIL_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public MailBoxPage getMailBoxPage() { return new MailBoxPage(getDriver()); }

}


package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.SearchPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTests {
    public WebDriver driver;
    private static final String URL = "https://www.google.com/";

    @BeforeTest
    public void profileSetUP() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUP() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public SearchPage getSearchPage() { return new SearchPage(getDriver()); }

}


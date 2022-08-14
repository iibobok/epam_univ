package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {

    WebDriver driver;
    public BasePage (WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void implicitWait(long timeToWait) {

        driver.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);

    }

}

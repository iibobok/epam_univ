package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AOLBasePage {

    WebDriver driver;
    public AOLBasePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void implicitWait(long timeToWait) {

        driver.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);

    }

}

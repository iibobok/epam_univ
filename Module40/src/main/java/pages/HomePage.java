package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    WebDriverWait wait;

    @FindBy (xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy (xpath = "//input[@type='password']")
    private WebElement passField;

    @FindBy (xpath = "(//span[@class='VfPpkd-vQzf8d'])[2]")
    private WebElement buttonNext;


    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void inputEmail (final String email) {
        emailField.sendKeys(email);
        buttonNext.click();
    }

    public void inputPassword (final String pass) {
        wait.until(ExpectedConditions.visibilityOf(passField)).isDisplayed();
        passField.sendKeys(pass);
        buttonNext.click();
    }

}

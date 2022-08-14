package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UKRNetLoginPage extends UKRNetBasePage {

    @FindBy (xpath = "//input[@name='login']")
    private WebElement inputLogin;

    @FindBy (xpath = "//input[@name='password']")
    private WebElement inputPass;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy (xpath = "//*[@id='modalAlert']//div[@class='modal-top']//div[@class='ttl js_title']")
    private WebElement Confirmation;


    public UKRNetLoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputLoginPass(final String USER_LOGIN, final String USER_MAIL) {
        inputLogin.sendKeys(USER_LOGIN);
        inputPass.sendKeys(USER_MAIL);
        loginButton.click();
    }

    public WebElement getConfirmation() {
        return Confirmation;
    }

}

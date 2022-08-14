package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AOLLoginPage extends AOLBasePage {

    @FindBy (xpath = "//input[@id='login-username']")
    private WebElement inputLogin;

    @FindBy (xpath = "//input[@id='login-passwd']")
    private WebElement inputPass;

    @FindBy (xpath = "//input[@type='submit']")
    private WebElement loginButton;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement passButton;

    @FindBy (xpath = "//p[@id='username-error']")
    private WebElement emptyUsernameMsg;

    @FindBy (xpath = "//p[@class='error-msg']")
    private WebElement invalidPassMsg;


    public AOLLoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputLogin(final String USER_LOGIN) {

        inputLogin.sendKeys(USER_LOGIN);
        loginButton.click();

    }

    public void inputPass(final String USER_PASS) {

        inputPass.sendKeys(USER_PASS);
        passButton.click();

    }

    public String emptyUsernameMsgDisplayed() {
        return emptyUsernameMsg.getText();
    }

    public String invalidPassMsgDisplayed() {
        return invalidPassMsg.getText();
    }

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MailBoxPage extends BasePage {

    WebDriverWait wait;

    @FindBy (xpath = "//img[contains(@src,'logo_gmail')]")
    private WebElement gmailLogo;

    @FindBy (xpath = "//div[@class='T-I T-I-KE L3']")
    private WebElement startLetterButton;

    @FindBy (xpath = "//textarea[@name='to']")
    private WebElement mailTo;

    @FindBy (xpath = "//input[@name='subjectbox']")
    private WebElement mailTheme;

    @FindBy (xpath = "//div[contains(@class, 'editable')]")
    private WebElement mailText;

    @FindBy (xpath = "//td[@class='gU Up']")
    private WebElement sendButton;

    @FindBy (xpath = "//div[@class='TN bzz aHS-bnt']//div[contains(@class,'qj')]")
    private WebElement inbox;

    @FindBy (xpath = "//span[@class='bog']")
    private WebElement inboxTheme;

    @FindBy (xpath = "//span[@class='y2']")
    private WebElement inboxText;

    @FindBy (xpath = "//span[@class='yP']")
    private WebElement inboxAddress;

    public MailBoxPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));

    }

    public void enterGmail () {
        wait.until(ExpectedConditions.visibilityOf(gmailLogo)).isDisplayed();
    }

    public void composeLetter(final String receiver, final String theme, final String text) {
        startLetterButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mailTo.sendKeys(receiver);
        mailTheme.sendKeys(theme);
        mailText.sendKeys(text);
    }

    public void sendMail() {
        sendButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void openInbox() {
        inbox.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public String checkReceivedLetterTheme() { return inboxTheme.getText(); }

    public String checkSenderEMail() { return inboxAddress.getAttribute("email"); }


}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AOLMailbox extends AOLBasePage {

    @FindBy (xpath = "//div[contains(@class, 'composeBtn')]")
    private WebElement composeBtn;

    @FindBy (xpath = "//textarea[@id='toInputField']")
    private WebElement receiverMail;

    @FindBy (xpath = "//input[@class='subject']")
    private WebElement mailSubject;

    @FindBy (xpath = "//div[@class='contentEditDiv']")
    private WebElement mailText;

    @FindBy (xpath = "//div[contains(@class, 'sendButton')]")
    private WebElement sendBtn;

    public AOLMailbox(WebDriver driver) {
        super(driver);
    }


    public void clickComposeBtn() {
        composeBtn.click();
    }

    public void inputReceiverMail(final String RCV_MAIL) {
        receiverMail.sendKeys(RCV_MAIL);
    }

    public void inputMailSubject(final String THEME) {
        mailSubject.sendKeys(THEME);
    }

    public void inputMailText(final String TEXT) {
        mailText.sendKeys(TEXT);
    }

    public void clickSendBtn() {
        sendBtn.click();
    }

}

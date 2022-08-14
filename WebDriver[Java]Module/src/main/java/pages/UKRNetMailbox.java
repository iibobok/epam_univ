package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UKRNetMailbox extends UKRNetBasePage {

    @FindBy (xpath = "//a[contains(@href, 'readmsg')]")
    private WebElement newMail;

    @FindBy (xpath = "//a[@class='readmsg__head-contact main']")
    private WebElement newMailSender;

    @FindBy (xpath = "//h3[@class='readmsg__subject']")
    private WebElement newMailSubject;

    @FindBy (xpath = "//div[@class='readmsg__body']")
    private WebElement newMailText;

    public UKRNetMailbox(WebDriver driver) { super(driver); }

    public void openNewMail() {
        newMail.click();
    }

    public String getSenderMail(){
        String sender_mail = newMailSender.getAttribute("data-email");
        return sender_mail;
    }

    public String getNewMailSubject() {
        return newMailSubject.getText();
    }

    public String getNewMailText() {
        return newMailText.getText();
    }

}

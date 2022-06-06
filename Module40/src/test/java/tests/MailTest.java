package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class MailTest extends BaseTests {

    private final String EMAIL_1 = "ivan.test.epam1@gmail.com";
    private final String EMAIL_2 = "ivan.test.epam2@gmail.com";
    private final String PASS_1 = "adfsTr434%";
    private final String THEME = "Hello World!";
    private final String MESSAGE = "ALOHA!";

    @Test (priority = 1)
    public void sendMail() throws InterruptedException {

        getHomePage().inputEmail(EMAIL_1);
        getHomePage().inputPassword(PASS_1);

        getMailBoxPage().enterGmail();
        getMailBoxPage().composeLetter(EMAIL_2, THEME, MESSAGE);
        getMailBoxPage().sendMail();

        Thread.sleep(5000);

    }

    @Test (priority = 10)
    public void checkMail() throws InterruptedException {

        getHomePage().inputEmail(EMAIL_2);
        getHomePage().inputPassword(PASS_1);

        getMailBoxPage().enterGmail();
        getMailBoxPage().openInbox();


        Assert.assertEquals(getMailBoxPage().checkSenderEMail(), EMAIL_1);
        Assert.assertEquals(getMailBoxPage().checkReceivedLetterTheme(), THEME);

        //System.out.println("EMAIL: "+getMailBoxPage().checkLetter3());
        //System.out.println("THEME: "+getMailBoxPage().checkLetter());

        Thread.sleep(5000);

    }
}

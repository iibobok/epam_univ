package tests;

import org.testng.annotations.Test;

public class AOLSendMailTest extends AOLBaseTests {

    private static final String USER_LOGIN = "ivantest797";
    private static final String USER_PASS = "Qwerty1991@";
    private static final String RCV_MAIL = "spamaz@ukr.net";
    private static final String MAIL_THEME = "Hello, Bob";
    private static final String MAIL_TEXT = "How are you?";

    @Test
    public void sendMail() throws InterruptedException {

        getLoginPage().inputLogin(USER_LOGIN);
        getLoginPage().implicitWait(5);
        getLoginPage().inputPass(USER_PASS);
        getLoginPage().implicitWait(10);
        getAOLMailbox().clickComposeBtn();
        getLoginPage().implicitWait(5);
        getAOLMailbox().inputReceiverMail(RCV_MAIL);
        getAOLMailbox().inputMailSubject(MAIL_THEME);
        getAOLMailbox().inputMailText(MAIL_TEXT);
        getLoginPage().implicitWait(5);
        getAOLMailbox().clickSendBtn();
        Thread.sleep(5000);

    }

}

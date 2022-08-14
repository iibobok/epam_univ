package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UKRNetCheckMailTest extends UKRNetBaseTests {

    private static final String USER_LOGIN = "spamaz";
    private static final String USER_MAIL = "Qwerty1991@";

    @Test
    public void checkEMail() throws InterruptedException {

        getUKRNetLoginPage().inputLoginPass(USER_LOGIN, USER_MAIL);
        getUKRNetLoginPage().implicitWait(5);
        getUKRNetMailbox().openNewMail();
        getUKRNetLoginPage().implicitWait(5);
        Assert.assertEquals(getUKRNetMailbox().getSenderMail(), "ivantest797@aol.com");
        Assert.assertEquals(getUKRNetMailbox().getNewMailSubject(), "Hello, Bob");
        Assert.assertEquals(getUKRNetMailbox().getNewMailText(), "How are you?");
        Thread.sleep(3000);

    }
}

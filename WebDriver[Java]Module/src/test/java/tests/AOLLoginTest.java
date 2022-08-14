package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AOLLoginTest extends AOLBaseTests {

    private static final String USER_LOGIN = "ivantest797";
    private static final String USER_PASS = "Qwerty1991@";
    private static final String INVALID_PASS = "qqqqqqqqq";

    @Test
    public void inputCorrectLoginPass() {

        getLoginPage().inputLogin(USER_LOGIN);
        getLoginPage().implicitWait(5);
        getLoginPage().inputPass(USER_PASS);
        getLoginPage().implicitWait(10);

    }

    @Test
    public void inputEmptyLogin() throws InterruptedException {

        getLoginPage().inputLogin("");
        Thread.sleep(2000);
        Assert.assertEquals(getLoginPage().emptyUsernameMsgDisplayed(), "Sorry, we don't recognize this email.");

    }

    @Test
    public void inputInvalidPass() throws InterruptedException {

        getLoginPage().inputLogin(USER_LOGIN);
        getLoginPage().implicitWait(5);
        getLoginPage().inputPass(INVALID_PASS);
        Thread.sleep(2000);
        Assert.assertEquals(getLoginPage().invalidPassMsgDisplayed(), "Invalid password. Please try again");

    }

}

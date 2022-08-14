using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace TestProject1
{
    public class VerifyChangingAOLSenderName
    {
        IWebDriver driver = new ChromeDriver(Environment.CurrentDirectory);

        private readonly By _login = By.XPath("//input[@id='login-username']");
        private readonly By _pass = By.XPath("//input[@id='login-passwd']");
        private readonly By _loginButton = By.XPath("//input[@type='submit']");
        private readonly By _passButton = By.XPath("//button[@type='submit']");

        private const string _username = "ivantest797";
        private const string _userpass = "Qwerty1991@";

        //private readonly By _composeBtn = By.XPath("//div[@class='unselectable btn composeBtn']");
        //private readonly By _receiverMail = By.XPath("//textarea[@id='toInputField']");
        //private readonly By _mailSubject = By.XPath("//input[@class='subject']");
        //private readonly By _mailText = By.XPath("//div[@class='contentEditDiv']");
        //private readonly By _sendBtn = By.XPath("//div[contains(@class, 'sendButton')]");

        //private const string RCV_MAIL = "spamaz@ukr.net";
        //private const string MAIL_THEME = "Hello, Bob";
        //private const string MAIL_TEXT = "How are you?";

        private readonly By _inboxNode = By.XPath("//span[@id='inboxNode']");
        private readonly By _receivedMail = By.XPath("//span[@title='spamaz@ukr.net']");
        private readonly By _receivedMailText = By.XPath("//span[contains(@class,'yiv')]/following-sibling::div[1]");
        private readonly By _optionsLink = By.XPath("//a[@data-dojo-attach-point='optionsLink']");
        private readonly By _mailSettings = By.XPath("//*[text()='Mail Settings']");
        private readonly By _composeSettings = By.XPath("//div[@id='composeSettings']");
        private readonly By _displayName = By.XPath("(//input[contains(@class,'wsInput')])[4]");
        private readonly By _saveSettingsBtn = By.XPath("(//div[text()='Save Settings'])[2]");



        [SetUp]
        public void Setup()
        {
            driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://mail.aol.com");
            driver.Manage().Window.Maximize();
        }

        [Test, Order(1)]
        public void changeNameTest()
        {
            driver.FindElement(_login).SendKeys(_username);

            driver.FindElement(_loginButton).Click();

            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(20));
            wait.Until(driver => driver.FindElement(_pass));
            driver.FindElement(_pass).SendKeys(_userpass);

            driver.FindElement(_passButton).Click();

            wait.Until(driver => driver.FindElement(_inboxNode));
            driver.FindElement(_inboxNode).Click();

            wait.Until(driver => driver.FindElement(_receivedMail));
            driver.FindElement(_receivedMail).Click();

            wait.Until(driver => driver.FindElement(_receivedMailText));
            var newAlias = driver.FindElement(_receivedMailText).Text;

            wait.Until(driver => driver.FindElement(_optionsLink));
            driver.FindElement(_optionsLink).Click();

            wait.Until(driver => driver.FindElement(_mailSettings));
            driver.FindElement(_mailSettings).Click();

            wait.Until(driver => driver.FindElement(_composeSettings));
            driver.FindElement(_composeSettings).Click();

            wait.Until(driver => driver.FindElement(_displayName));
            driver.FindElement(_displayName).Clear();
            driver.FindElement(_displayName).SendKeys(newAlias);

            wait.Until(driver => driver.FindElement(_saveSettingsBtn));
            driver.FindElement(_saveSettingsBtn).Click();

            Thread.Sleep(3000);
        }


        [TearDown]
        public void TearDown()
        {
            Thread.Sleep(600);
            driver.Quit();
        }
    }
}
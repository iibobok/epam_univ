using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace TestProject1
{
    public class AOLMailTests
    {
        IWebDriver driver = new ChromeDriver(Environment.CurrentDirectory);

        private readonly By _login = By.XPath("//input[@id='login-username']");
        private readonly By _pass = By.XPath("//input[@id='login-passwd']");
        private readonly By _loginButton = By.XPath("//input[@type='submit']");
        private readonly By _passButton = By.XPath("//button[@type='submit']");

        private readonly By _invalidPassMsg = By.XPath("//p[@class='error-msg']");
        private readonly By _emptyLoginMsg = By.XPath("//p[@id='username-error']");

        private const string _username = "ivantest797";
        private const string _userpass = "Qwerty1991@";
        private const string _invalidpass = "qqqqqqq";

        private readonly By _composeBtn = By.XPath("//div[@class='unselectable btn composeBtn']");
        private readonly By _receiverMail = By.XPath("//textarea[@id='toInputField']");
        private readonly By _mailSubject = By.XPath("//input[@class='subject']");
        private readonly By _mailText = By.XPath("//div[@class='contentEditDiv']");
        private readonly By _sendBtn = By.XPath("//div[contains(@class, 'sendButton')]");

        private const string RCV_MAIL = "spamaz@ukr.net";
        private const string MAIL_THEME = "Hello, Bob";
        private const string MAIL_TEXT = "How are you?";


        [SetUp]
        public void Setup()
        {
            driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://mail.aol.com");
            driver.Manage().Window.Maximize();
        }

        [Test, Order(1)]
        public void ValidLoginPassTest()
        {
            driver.FindElement(_login).SendKeys(_username);
            
            driver.FindElement(_loginButton).Click();

            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(20));
            wait.Until(driver => driver.FindElement(_pass));
            driver.FindElement(_pass).SendKeys(_userpass);

            driver.FindElement(_passButton).Click();
        }

        [Test, Order(2)]
        public void InvalidPassTest() 
        {
            driver.FindElement(_login).SendKeys(_username);

            driver.FindElement(_loginButton).Click();

            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(20));
            wait.Until(driver => driver.FindElement(_pass));
            driver.FindElement(_pass).SendKeys(_invalidpass);

            driver.FindElement(_passButton).Click();

            var errorMsg = driver.FindElement(_invalidPassMsg).Text;
            Assert.That("Invalid password. Please try again", Is.EqualTo(errorMsg));
        }

        [Test, Order(3)]
        public void EmptyLoginTest()
        {
            driver.FindElement(_login).SendKeys("");

            driver.FindElement(_loginButton).Click();

            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(20));
            wait.Until(driver => driver.FindElement(_emptyLoginMsg).Text);
            var errorEmptyLogin = driver.FindElement(_emptyLoginMsg).Text;
            Assert.That("Sorry, we don't recognize this email.", Is.EqualTo(errorEmptyLogin));
        }

        [Test, Order(4)]
        public void SendMailTest()
        {
            driver.FindElement(_login).SendKeys(_username);

            driver.FindElement(_loginButton).Click();

            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(20));
            wait.Until(driver => driver.FindElement(_pass));
            driver.FindElement(_pass).SendKeys(_userpass);

            driver.FindElement(_passButton).Click();

            wait.Until(driver => driver.FindElement(_composeBtn));
            driver.FindElement(_composeBtn).Click();

            wait.Until(driver => driver.FindElement(_receiverMail));
            driver.FindElement(_receiverMail).SendKeys(RCV_MAIL);

            driver.FindElement(_mailSubject).SendKeys(MAIL_THEME);

            driver.FindElement(_mailText).SendKeys(MAIL_TEXT);

            wait.Until(driver => driver.FindElement(_sendBtn));
            driver.FindElement(_sendBtn).Click();

            Thread.Sleep(500);
        }


        [TearDown]
        public void TearDown()
        {
            Thread.Sleep(600);
            driver.Quit();
        }
    }
}
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using System.Text;

namespace TestProject1
{
    public class UKRNetMailTests
    {
        IWebDriver driver = new ChromeDriver(Environment.CurrentDirectory);

        private const string _userLogin = "spamaz";
        private const string _userPasswd = "Qwerty1991@";

        private const string SENDER_MAIL = "ivantest797@aol.com";
        private const string MAIL_THEME = "Hello, Bob";
        private const string MAIL_TEXT = "How are you?";


        private readonly By _loginField = By.XPath("//input[@name='login']");
        private readonly By _passField = By.XPath("//input[@name='password']");
        private readonly By _signInBtn = By.XPath("//button[@type='submit']");

        private readonly By _newMail = By.XPath("//a[contains(@href, 'readmsg')]");
        private readonly By _newMailSender = By.XPath("//a[@class='readmsg__head-contact main']");
        private readonly By _newMailSubject = By.XPath("//h3[@class='readmsg__subject']");
        private readonly By _newMailText = By.XPath("//div[@class='readmsg__body']");

        private readonly By _responseBtn = By.XPath("//a[contains(@href, 'sendmsg/reply')]");
        private readonly By _responseTextArea = By.XPath("//iframe[contains(@id, 'mce')]");
        private readonly By _sendBtn = By.XPath("//button[@class='button primary send']");

        String aliasName = RandomString(5, true);

        public static string RandomString(int size, bool lowerCase)
        {
            StringBuilder builder = new StringBuilder();
            Random random = new Random();
            char ch;

            for (int i = 0; i < size; i++)
            {
                ch = Convert.ToChar(Convert.ToInt32(Math.Floor(26 * random.NextDouble() + 65)));
                builder.Append(ch);
            }

            if (lowerCase)
                return builder.ToString().ToLower();
            return builder.ToString();
        }

        [SetUp]
        public void Setup()
        {
            driver = new ChromeDriver();
            driver.Navigate().GoToUrl("http://mail.ukr.net");
            driver.Manage().Window.Maximize();
        }

        [Test]
        public void ReceivedMailTest()
        {
            driver.FindElement(_loginField).SendKeys(_userLogin);

            driver.FindElement(_passField).SendKeys(_userPasswd);

            driver.FindElement(_signInBtn).Click();

            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(20));
            wait.Until(driver => driver.FindElement(_newMail));
            driver.FindElement(_newMail).Click();

            wait.Until(driver => driver.FindElement(_newMailSender));
            var newMailAddress = driver.FindElement(_newMailSender).GetAttribute("data-email");
            Assert.That(SENDER_MAIL, Is.EqualTo(newMailAddress));
            var newMailTheme = driver.FindElement(_newMailSubject).Text;
            Assert.That(MAIL_THEME, Is.EqualTo(newMailTheme));
            var newMailContent = driver.FindElement(_newMailText).Text;
            Assert.That(MAIL_TEXT, Is.EqualTo(newMailContent));
        }

        [Test]
        public void ResponseTest()
        {
            driver.FindElement(_loginField).SendKeys(_userLogin);

            driver.FindElement(_passField).SendKeys(_userPasswd);

            driver.FindElement(_signInBtn).Click();

            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(20));
            wait.Until(driver => driver.FindElement(_newMail));
            driver.FindElement(_newMail).Click();

            wait.Until(driver => driver.FindElement(_responseBtn));
            driver.FindElement(_responseBtn).Click();

            wait.Until(driver => driver.FindElement(_responseTextArea));
            driver.FindElement(_responseTextArea).SendKeys(aliasName);

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
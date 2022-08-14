package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Key;

public class SearchPage extends BasePage {

    @FindBy (xpath = "//input[@name='q']")
    private WebElement searchField;

    @FindBy (xpath = "(//div[contains(@class,'mitem')])[2]")
    private WebElement imageTab;



    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void inputSearchWord(final String request) {
        searchField.sendKeys(request);
        searchField.sendKeys(Keys.ENTER);
    }

    public void openImageTab() {
        imageTab.click();
    }

}

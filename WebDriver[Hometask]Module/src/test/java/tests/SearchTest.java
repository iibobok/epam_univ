package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTests {

    private static final String SEARCH_WORD = "otter";


    @Test
    public void checkImage() {
        getSearchPage().inputSearchWord(SEARCH_WORD);
        getSearchPage().openImageTab();
        getSearchPage().implicitWait(10);

        WebElement image = driver.findElement(By.xpath("//img[contains(@alt,'otter')]"));
        // Javascript executor to check image
        Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", image);

        //verify if status is true
        if (p) {
            System.out.println("Image present");
        } else {
            System.out.println("Image not present");
        }
    }

}

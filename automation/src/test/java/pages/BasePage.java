package pages;

import org.openqa.selenium.WebDriver;

/**
 * This class covers any generic Menu items that are spread across all pages
 * @author Haritha Desu
 */
public class BasePage {

    protected static WebDriver driver;

       public void setWebDriver(WebDriver driver) {
        BasePage.driver = driver;
    }
}

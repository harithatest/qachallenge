package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.NoSuchElementException;

/**
 * This class is created to include locators (web elements) and actions on Login page
 * @author Haritha Desu
 */

public class LoginPage extends BasePage{

    /**
     * Locator for "User Name" text input box
     * @return WebeElement (or unique identifier for username field
     */
    public static WebElement getUserName() {
        return driver.findElement(By.name("form-username"));
    }
    /**
     * Locator for "Password" text input box
     * @return WebeElement (or unique identifier for password field
     */
    public static WebElement getPassword() {
        return driver.findElement(By.name("form-password"));
    }
    /**
     * Locator for "Login" Button
     * @return WebeElement (or unique identifier for login button
     */
    public static WebElement getLoginButton() {

        return driver.findElement(By.id("btnLogin"));
    }

    /**
     * This method performs Login action
     * @param username a string with username
     * @param password a string with password
     */
    public static void login(String username, String password) {
        getUserName().sendKeys(username);
        getPassword().sendKeys(password);
        getLoginButton().click();
    }

    /**
     *  Locator for any error messages on page
     * @return error message text
     */
    public static String errorMessageText(){
        return getErrorMessage().getText();
    }

    /**
     * To verify there are no errors on the page
     */
    public static void CheckNoErrors(){
        Assert.assertNull(LoginPage.errorMessageText());
    }

    /**
     * Locator for Error Messages if exist on the LoginPage
     * @return web element for error message if present
     */
    public static WebElement getErrorMessage(){
        WebElement element;
        try{
            element = driver.findElement(By.id("validation-errors"));
            return element;
        }
        catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
}

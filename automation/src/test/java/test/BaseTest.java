package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import pages.BasePage;
import pages.DashboardPage;
import pages.LoginPage;
import java.nio.file.Paths;

/**
 * This class is created to include all generaL purpose methods to be used in the tests
 * @author Haritha Desu
 */
public class BaseTest {

    protected static WebDriver driver;
    protected static BasePage basePage;

    private static final String app_path = Paths.get("src/test/resources/app/home.html").toUri().toString();

    //@BeforeSuite
    public static void launchApplication(){
        setChromeDriverProperty();
        driver = new ChromeDriver();
        driver.get(app_path);
        basePage = new BasePage();
        basePage.setWebDriver(driver);
    }

    @AfterSuite
    public void tearDown() {
        //driver.close();
        driver.quit();
    }

    public static void closeBrowser(){
        driver.close();
    }

    private static void setChromeDriverProperty(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public static void CheckOnRightPage(String title){
        Assert.assertEquals(driver.getTitle(),title);
    }

    public static void OnHomePage(){
        CheckOnRightPage("Login");
        Assert.assertTrue(LoginPage.getUserName().isEnabled());
        Assert.assertTrue(LoginPage.getPassword().isEnabled());
        Assert.assertTrue(LoginPage.getLoginButton().isEnabled());
    }

    public DashboardPage navToDashboard(String username, String password) {
        LoginPage.getUserName().sendKeys(username);
        LoginPage.getPassword().sendKeys(password);
        LoginPage.getLoginButton().click();
        return new DashboardPage();
    }

}

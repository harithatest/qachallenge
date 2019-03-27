package pages;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * This class covers web elements and actions that can be performed on Benefits Dashboard Page
 *
 * @author Haritha Desu
 */
public class DashboardPage extends BasePage {

    /**
     * Locator for Header on Benefits Dashboard  page
     *
     * @return webelement
     */
    public static WebElement getHeader() {
        String headerXPath = ("[//div[@id=\"header\"]/h1]");
        return driver.findElement(By.xpath(headerXPath));
    }

    /**
     * Asserts the  (column) headers of the data table (with employee details)
     */
    public static void AssertDataTableHeader() {
        Assert.assertTrue(DashboardPage.getHeaderByColumnName("id").isDisplayed());
        Assert.assertTrue(DashboardPage.getHeaderByColumnName("lastname").isDisplayed());
        Assert.assertTrue(DashboardPage.getHeaderByColumnName("firstname").isDisplayed());
        Assert.assertTrue(DashboardPage.getHeaderByColumnName("salary").isDisplayed());
        Assert.assertTrue(DashboardPage.getHeaderByColumnName("dependants").isDisplayed());
        Assert.assertTrue(DashboardPage.getHeaderByColumnName("grosspay").isDisplayed());
        Assert.assertTrue(DashboardPage.getHeaderByColumnName("benefitscost").isDisplayed());
        Assert.assertTrue(DashboardPage.getHeaderByColumnName("netpay").isDisplayed());
        Assert.assertTrue(DashboardPage.getHeaderByColumnName("actions").isDisplayed());
    }

    /**
     * Locators to identify column headers
     *
     * @param column takes column number as input
     * @return returns webelement for the column header you are looking for
     */

    public static WebElement getHeaderByColumnName(String column) {

        switch (column) {
            case "id":
                return findHeaderField(1);

            case "lastname":
                return findHeaderField(2);

            case "firstname":
                return findHeaderField(3);

            case "salary":
                return findHeaderField(4);

            case "dependants":
                return findHeaderField(5);

            case "grosspay":
                return findHeaderField(6);

            case "benefitscost":
                return findHeaderField(7);

            case "netpay":
                return findHeaderField(8);

            case "actions":
                return findHeaderField(9);

            default:
                return findHeaderField(9);
        }
    }


    public static String getDataText(String name, int row) {
        return getDataElement(name, row).getText();
    }

    /**
     * Locators to identify particular cell in the table
     *
     * @param name column name as string
     * @param row  row number as int
     * @return webelement on row with corresponding column name
     */

    public static WebElement getDataElement(String name, int row) {
        switch (name) {
            case "id":
                return findDataField(row, 1);

            case "lastname":
                return findDataField(row, 2);

            case "firstname":
                return findDataField(row, 3);

            case "salary":
                return findDataField(row, 4);

            case "dependants":
                return findDataField(row, 5);

            case "grosspay":
                return findDataField(row, 6);

            case "benefitscost":
                return findDataField(row, 7);

            case "netpay":
                return findDataField(row, 8);

            case "delete":
                return findElementByXPath("//table/tbody/tr[" + row + "]/td[9]/span[@id=\"btnDelete\"]");

            case "edit":
                return findElementByXPath("//table/tbody/tr[" + row + "]/td[9]/span[@id=\"btnEdit\"]");
            default:
                return findDataField(row, 8);
        }
    }

    public static String dataHeaderXPath(int x) {
        return "//table/thead/tr[1]/th[" + x + "]";
    }

    public static String dataTableXPath(int x, int y) {
        return "//table/tbody/tr[" + x + "]/th[" + y + "]";
    }

    public static WebElement findElementByXPath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    /**
     * Clicks "Add Employee" Button
     */
    public static void clickAddEmployee() {
        driver.findElement(By.cssSelector("button.btnAddEmployee")).click();
        //WebElement element = driver.findElement(By.xpath("//button[contains(.,'Add Employee')]"));
        //List<WebElement> buttons = driver.findElements(By.xpath("//*[@id=\"btnAddEmployee\"]"));
//          //text.get(0).click();
//          System.out.println(buttons.size());
//          buttons.get(0).click();
//          driver.switchTo().frame(0);
//          Point point = element.getLocation();
//          int x = point.getX();
//          int y = point.getY();
//          Actions action = new Actions(driver);
//          action.moveToElement(element, 0, 0).click().build().perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Clicks "Edit Icon" on a given row  under Actions  *
     *
     * @param row takes row number as int
     */
    public void clickEditEmployee(int row) {
        driver.findElement(By.xpath("//table/tbody/tr[" + row + "]/td[9]/span[@id=\"btnEdit\"]")).click();
    }

    /**
     * Clicks "Delete Icon" on a given row  under Actions    *
     * @param row takes row number as int
     */
    public void clickDeleteEmployee(int row) {
        driver.findElement(By.xpath("\"//table/tbody/tr[\" + row + \"]/td[9]/span[@id=\"btnEdit\"]")).click();
    }

    public static WebElement findHeaderField(int x) {
        String xpath = dataHeaderXPath(x);
        return findElementByXPath(xpath);
    }

    public static WebElement findDataField(int x, int y) {
        String xpath = dataTableXPath(x, y);
        return findElementByXPath(xpath);
    }

    /**
     * Adds Employee details
     * @param fname first name as string
     * @param lname last name as string
     * @param dep dependents as string
     */
    public static void AddEmployeeDetails(String fname, String lname, String dep) {
        inputFirstName(fname);
        inputLastName(lname);
        inputDependants(dep);
        clickSubmitButton();
    }

    public static void inputFirstName(String fname) {
        driver.findElement(By.xpath("//label[@for=\"firstname\"]/../div/input")).click();
        driver.findElement(By.xpath("//label[@for=\"firstname\"]/../div/input")).sendKeys(fname);
    }

    public static void inputLastName(String lname) {
        driver.findElement(By.xpath("//label[@for=\"lastname\"]/../div/input")).sendKeys(lname);
    }

    public static void inputDependants(String dep) {
        driver.findElement(By.xpath("//label[@for=\"dependents\"]/../div/input")).sendKeys(dep);
    }

    /**
     * Clicks submit button on modal dialog "Add Employee & His Dependents"
     */
    public static void clickSubmitButton() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
    }

    public static void clickCloseButton() {
        driver.findElement(By.xpath("//button[@class=\"btn btn-default\"]")).click();
    }

    public static void clickModalDialog() {
        modalTitle().click();
    }

    public static WebElement modalTitle() {
        return driver.findElement(By.xpath("//*[@id=\"addEmployeeModal\"]/div/div/div[1]/h4"));
    }

    public static void closeModal() {
        driver.findElement(By.xpath("//button[@class=\"close\"]")).click();
    }
}

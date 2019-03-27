package test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.DashboardPage;
import pages.LoginPage;

public class FunctionalTests extends BaseTest {

    @BeforeTest
    public void setup(){
        launchApplication();
        CheckOnRightPage("Login");
    }

    @AfterTest
    public void logout(){
        //logout();
        closeBrowser();
    }

    @Test
    public void LoginTest(){
        OnHomePage();
        //Test 1: To check if invalid credentials throw an error on page
        LoginPage.login("test","test");
        String actualMessage = LoginPage.errorMessageText();
        Assert.assertEquals(actualMessage,"Invalid login attempt. Please try again.");
        CheckOnRightPage("Login");
        refreshPage();
        //Test 2: To check if empty credentials are validated
        LoginPage.login("","");
        actualMessage = LoginPage.errorMessageText();
        Assert.assertEquals(actualMessage,"Invalid login attempt. Please try again.");
        CheckOnRightPage("Login");
        refreshPage();
        //Test 3: To check if valid credentials are accepted
        LoginPage.login("testUser","Test1234");
        LoginPage.CheckNoErrors();
        CheckOnRightPage("Benefits Dashboard");
    }

    @Test
    public void AddEmployeeTest(){
        DashboardPage dashPage = new DashboardPage();
        dashPage = navToDashboard("testUser","Test1234");
        CheckOnRightPage("Benefits Dashboard");
        dashPage.AssertDataTableHeader();

        //Test 4: Add a new Employee with first name starting with any letter other than 'A'
        dashPage.clickAddEmployee();
        Assert.assertEquals(dashPage.modalTitle().getText(),"Add Employee & His dependents");
        dashPage.AddEmployeeDetails("Emily","Smith","1");
        Assert.assertEquals(dashPage.getDataText("benefitscost",2),"57.69");
        dashPage.AddEmployeeDetails("1234","Smith","1");
        Assert.assertEquals(dashPage.getDataText("benefitscost",3),"57.69");

        //Test 5: Add a new Employee with first name starting with letter 'A'
        dashPage.clickAddEmployee();
        Assert.assertEquals(dashPage.modalTitle().getText(),"Add Employee & His dependents");
        dashPage.AddEmployeeDetails("Amy","Smith","1");
        Assert.assertEquals(dashPage.getDataText("benefitscost",4),"51.92");
        dashPage.AddEmployeeDetails("anton","Smith","1");
        Assert.assertEquals(dashPage.getDataText("benefitscost",5),"51.92");
    }

    @Test
    public void EditEmployee(){
        DashboardPage dashPage = new DashboardPage();
        dashPage = navToDashboard("testUser","Test1234");
        CheckOnRightPage("Benefits Dashboard");
        dashPage.AssertDataTableHeader();
        //Test 6: Edit existing employee details and check if the calculation is correct
        dashPage.clickEditEmployee(1);
        dashPage.AddEmployeeDetails("anton","Smith","1");
        Assert.assertEquals(dashPage.getDataText("benefitscost",1),"51.92");
        //Test 7: Add new employee and Edit employee details and check if the calculation is correct
        dashPage.clickAddEmployee();
        dashPage.AddEmployeeDetails("Zack","Smith","1");
        Assert.assertEquals(dashPage.getDataText("benefitscost",2),"57.96");
        dashPage.clickEditEmployee(2);
        dashPage.AddEmployeeDetails("anton","Smith","1");
        Assert.assertEquals(dashPage.getDataText("benefitscost",2),"51.92");
    }

    @Test
    public void DeleteEmployee(){
        DashboardPage dashPage = new DashboardPage();
        dashPage = navToDashboard("testUser","Test1234");
        CheckOnRightPage("Benefits Dashboard");
        dashPage.AssertDataTableHeader();
        //Test 8: Add new employee and delete the same employee details (catches if there are any cache related issues
        dashPage.clickAddEmployee();
        dashPage.AddEmployeeDetails("Amy","Smith","1");
        Assert.assertEquals(dashPage.getDataText("benefitscost",2),"51.92");
        dashPage.clickDeleteEmployee(2);
        Assert.assertEquals(dashPage.getDataText("firstname",2),null);
        //Test 9: Delete already existing employee details
        dashPage.clickDeleteEmployee(1);
        Assert.assertEquals(dashPage.getDataText("firstname",1),null);

    }










}

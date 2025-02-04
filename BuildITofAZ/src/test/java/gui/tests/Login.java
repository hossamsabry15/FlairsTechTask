package gui.tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.*;

public class Login {
    // Variables
    WebDriver driver;
    JsonFileManager testData;


    // Test Cases
    @Test(description = "Login With Correct Email and Password Test - Register and Delete user with APIs ")
    @Description("Given that I am a registered user, When I enter correct email, And Correct Password , And I Clicked on Login button And I clicked on delete user, Then I should be Logged in successfully to the system, And user be deleted from the system")
    public void loginWithCorrectEmailAndPassword() {
        //Register and Delete user with APIs still not implemented
        new pages.Login(driver)
                .enterEmail(testData.getTestData("Email"))
                .enterPassword(testData.getTestData("Password"))
                .clickOnLogin();
        new pages.Dashboard(driver)
                .validateOnDashboardPage();
    }
    @Test(description = "Login With Invalid Email Test")
    @Description("Given that I am a registered user, When I enter invalid email, Then an error message should appear")
    public void loginWithInvalidEmail() {
        new pages.Login(driver)
                .enterEmail(testData.getTestData("InvalidUserMail"))
                .assertOnErrorMessageInvalidEmailFormat(testData.getTestData("errorMessageInvalidEmailFormat"));
    }
    @Test(description = "Login With Wrong Email and Correct Password Test")
    @Description("Given that I am a registered user, When I enter wrong email, And Correct Password , Then an error message should appear")
    public void loginWithWrongEmailAndCorrectPassword() {
        new pages.Login(driver)
                .enterEmail(testData.getTestData("WrongUserMail"))
                .enterPassword(testData.getTestData("Password"))
                .clickOnLogin()
                .assertOnErrorMessageIncorrectEmailOrPassword(testData.getTestData("errorMessageIncorrectEmailOrPassword"));
    }
    @Test(description = "Login With Correct Email and Wrong Password Test")
    @Description("Given that I am a registered user, When I enter correct email, And wrong Password , Then an error message should appear")
    public void loginWithCorrectEmailAndWrongPassword() {
        new pages.Login(driver)
                .enterEmail(testData.getTestData("Email"))
                .enterPassword(testData.getTestData("WrongPassword"))
                .clickOnLogin()
                .assertOnErrorMessageIncorrectEmailOrPassword(testData.getTestData("errorMessageIncorrectEmailOrPassword"));
    }

    //////////////////////// Configurations \\\\\\\\\\\\\\\\\\\\\\\\\\\
    @BeforeClass
    public void beforeClass() {
        PropertiesReader.loadProperties();
        testData = new JsonFileManager("src/test/resources/TestDataJsonFiles/LoginTestsTestData.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = DriverFactory.initDriver();
        new pages.Login(driver)
                .navigate()
                .validateOnLoginPage();
    }

    @AfterMethod(description = "Close driver")
    public void afterMethod() {
        driver.quit();
    }
}

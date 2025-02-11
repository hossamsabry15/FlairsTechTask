package apis.tests;

import apis.ApisAccountManagement;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.JsonFileManager;

public class Login {
    // Variables
    private ApisAccountManagement api;
    private JsonFileManager testData;
    private String timeStamp;

    // Test Cases
    @Test(description = "Login User Test - API - Time Stamp")
    @Description("Given that I am a registered user, When I click in Signup/Login button, And I entered valid email and valid password, And I clicked on Login button, Then I should be logged in successfully to the system")
    public void loginUserTestApi() {
        api.logIntoUserAccount(
                testData.getTestData("Email"),
                testData.getTestData("Password")
        );
//        api.createRegisterUserAccount(
//                        testData.getTestData("UserName"),
//                        testData.getTestData("UserMail.ApiTimeStamp") + timeStamp + "@gizasystems.com",
//                        testData.getTestData("UserPassword")
//                )
//                .validateUserCreatedRegistered()
//                .logIntoUserAccount(
//                        testData.getTestData("UserMail.ApiTimeStamp") + timeStamp + "@gizasystems.com",
//                        testData.getTestData("UserPassword")
//                )
//                .validateUserLoggedIn()
//                .deleteUserAccount(
//                        testData.getTestData("UserMail.ApiTimeStamp") + timeStamp + "@gizasystems.com",
//                        testData.getTestData("UserPassword")
//                )
//                .validateDeleteUser()
//                .validateUserNotFound(testData.getTestData("UserMail.ApiTimeStamp") + timeStamp + "@gizasystems.com");
    }

    //////////////////// Configurations \\\\\\\\\\\\\\\\\\\\
    @BeforeClass
    public void beforeClass() {
        testData = new JsonFileManager("src/test/resources/TestDataJsonFiles/LoginUserApisTestsTestData.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        timeStamp = String.valueOf(System.currentTimeMillis());
        api = new ApisAccountManagement();
    }
}
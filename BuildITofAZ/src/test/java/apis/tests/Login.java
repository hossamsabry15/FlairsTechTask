package apis.tests;

import apis.ApisAccountManagement;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import io.restassured.response.Response;
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
        api.
//                createRegisterUserAccount(
//                testData.getTestData("companyName"),
//                testData.getTestData("Email2"),
//                testData.getTestData("Password2")).
                logIntoUserAccount(
                testData.getTestData("Email2"),
                testData.getTestData("Password2")).
                deleteUserAccount().
                validateDeleteUser();
//        api.createRegisterUserAccount(
//                        testData.getTestData("UserName"),
//                        testData.getTestData("UserMail.ApiTimeStamp") + timeStamp + "@builditofaz.com",
//                        testData.getTestData("UserPassword")
//                )
//                .validateUserCreatedRegistered()
//                .logIntoUserAccount(
//                        testData.getTestData("UserMail.ApiTimeStamp") + timeStamp + "@builditofaz.com",
//                        testData.getTestData("UserPassword")
//                )
//                .validateUserLoggedIn()
//                .deleteUserAccount(
//                        testData.getTestData("UserMail.ApiTimeStamp") + timeStamp + "@builditofaz.com",
//                        testData.getTestData("UserPassword")
//                )
//                .validateDeleteUser()
//                .validateUserNotFound(testData.getTestData("UserMail.ApiTimeStamp") + timeStamp + "@builditofaz.com");
    }
//    @Test
//    public void restAssuredTest() {
//        String body = """
//                {
//                    "username" : "sari@builditofaz.com",
//                    "password" : "Liveurlife102!"
//                }
//                """;
//
//        // Capture response
//        Response response = RestAssured.
//                given()
//                .header("Content-Type", "application/json")
//                .body(body)
//                .log().all()
//                .when()
//                .post("https://api.dev.gunsync.com/v1/auth/login");
//
//        // Print response body
//        System.out.println("Response Body: " + response.getBody().asString());
//
//        // Validate response and log body
//        response.then()
//                .statusCode(200)
//                .log().body();
//    }

    //////////////////// Configurations \\\\\\\\\\\\\\\\\\\\
    @BeforeClass
    public void beforeClass() {
        testData = new JsonFileManager("src/test/resources/TestDataJsonFiles/Login/LoginUserApisTestsTestData.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        timeStamp = String.valueOf(System.currentTimeMillis());
        api = new ApisAccountManagement();
    }
}
package apis;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import utilities.PropertiesReader;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApisAccountManagement {

    // Status Codes
    public static final int SUCCESS = 200;

    // Variables
    private String baseUrl = PropertiesReader.getProperty("apisBaseUrl");
    private String accessToken;
    private int useId;
    private Response deleteResponse;
    // Constructor
    public ApisAccountManagement() {
        RestAssured.baseURI = baseUrl;
    }

    // Services
    private static final String createAccount_serviceName = "/auth/register";
    private static final String loginToAccount_serviceName = "/auth/login";
    private static final String deleteAccount_serviceName = "/user/";
    private static final String getUserDetailByEmail_serviceName = "/getUserDetailByEmail";

    //////////////////// Actions \\\\\\\\\\\\\\\\\\\\
    @Step("API Create/Register User Account")
    public ApisAccountManagement createRegisterUserAccount(String company_name, String email, String pass) {
        String body = String.format(
                "company_name=%s&email=%s&password=%s&confirm_password=%s",
                company_name, email, pass, pass
        );

        Response response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .post(createAccount_serviceName);

        response.then().statusCode(SUCCESS);
        return this;
    }

    @Step("API Log Into User Account")
    public ApisAccountManagement logIntoUserAccount(String email, String pass) {

        String body = String.format("""
        {
            "email": "%s",
            "password": "%s"
        }
        """, email, pass);

        // Send Request
        Response response =
                given()
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .when()
                .post(loginToAccount_serviceName);
        System.out.println("Response Body: " + response.getBody().asString());
        // Validate Response Status Code
        response.then().statusCode(SUCCESS) // Assuming 200 is a success response
                .log().body();

        //Extract Access Token (Ensure the key is correct)
        accessToken = response.jsonPath().getString("data.accessToken"); // Replace with actual key

        //Extract User ID (Ensure the key is correct)
        useId = response.jsonPath().getInt("data.user.id"); // Replace with actual key

        System.out.println("Access Token: " + accessToken);
        System.out.println("User ID: " + useId);

        // Configure RestAssured to Automatically Add Token in Every Request
        RestAssured.filters((requestSpec, responseSpec, ctx) -> {
            requestSpec.header("Authorization", "Bearer " + accessToken);
            return ctx.next(requestSpec, responseSpec);
        });
        return this;
    }

    @Step("API Delete User Account")
    public ApisAccountManagement deleteUserAccount() {

        deleteResponse = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .delete(deleteAccount_serviceName + useId);

        deleteResponse.then().statusCode(SUCCESS);
        return this;
    }

    @Step("API Get User Detail By Email")
    public ApisAccountManagement getUserDetailByEmail(String email) {
        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("email", email)
                .get(getUserDetailByEmail_serviceName);

        response.then().statusCode(SUCCESS);
        return this;
    }

    //////////////////// Validations \\\\\\\\\\\\\\\\\\\\
    @Step("Validate User Created/Registered")
    public ApisAccountManagement validateUserCreatedRegistered() {
        Response response = given().get(createAccount_serviceName);
        response.then().body("message", equalTo("User created!"));
        return this;
    }

    @Step("Validate User Login")
    public ApisAccountManagement validateUserLoggedIn() {
        Response response = given().get(loginToAccount_serviceName);
        response.then().body("message", equalTo("User exists!"));
        return this;
    }

    @Step("Validate Account Deleted")
    public ApisAccountManagement validateDeleteUser() {
        deleteResponse.then().body("message", equalTo("User registered successfully."));
        return this;
    }

    @Step("Validate User Not Found In The System")
    public ApisAccountManagement validateUserNotFound(String email) {
        getUserDetailByEmail(email);
        Response response = given().get(getUserDetailByEmail_serviceName);
        response.then().body("message", equalTo("Account not found with this email, try another email!"));
        return this;
    }
}
package apis;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import static org.hamcrest.CoreMatchers.equalTo;

public class ApisAccountManagement {
    // Status Codes
    public static final int SUCCESS = 200;

    // Variables
    private String baseUrl = System.getProperty("apisBaseUrl");

    // Constructor
    public ApisAccountManagement() {
        // Constructor
    }

    // Services
    private static final String createAccount_serviceName = "/register";
    private static final String loginToAccount_serviceName = "/login";
    private static final String deleteAccount_serviceName = "/delete";
    private static final String getUserDetailByEmail_serviceName = "/getUserDetailByEmail";

    //////////////////// Actions \\\\\\\\\\\\\\\\\\\\
    @Step("API Create/Register User Account")
    public ApisAccountManagement createRegisterUserAccount(String company_name, String email, String pass) {
        String body = String.format(
                "company_name=%s&email=%s&password=%s&confirm_password=%s",
                company_name, email, pass, pass
        );

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .post(baseUrl + createAccount_serviceName);

        response.then().statusCode(SUCCESS);
        return this;
    }

    @Step("API Log Into User Account")
    public ApisAccountManagement logIntoUserAccount(String email, String pass) {
        String body = String.format("email=%s&password=%s", email, pass);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .post(baseUrl + loginToAccount_serviceName);

        response.then().statusCode(SUCCESS);
        return this;
    }

    @Step("API Delete User Account")
    public ApisAccountManagement deleteUserAccount(String email, String pass) {
        String body = String.format("email=%s&password=%s", email, pass);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .delete(baseUrl + deleteAccount_serviceName);

        response.then().statusCode(SUCCESS);
        return this;
    }

    @Step("API Get User Detail By Email")
    public ApisAccountManagement getUserDetailByEmail(String email) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("email", email)
                .get(baseUrl + getUserDetailByEmail_serviceName);

        response.then().statusCode(SUCCESS);
        return this;
    }

    //////////////////// Validations \\\\\\\\\\\\\\\\\\\\
    @Step("Validate User Created/Registered")
    public ApisAccountManagement validateUserCreatedRegistered() {
        Response response = RestAssured.given().get(baseUrl + createAccount_serviceName);
        response.then().body("message", equalTo("User created!"));
        return this;
    }

    @Step("Validate User Login")
    public ApisAccountManagement validateUserLoggedIn() {
        Response response = RestAssured.given().get(baseUrl + loginToAccount_serviceName);
        response.then().body("message", equalTo("User exists!"));
        return this;
    }

    @Step("Validate Account Deleted")
    public ApisAccountManagement validateDeleteUser() {
        Response response = RestAssured.given().get(baseUrl + deleteAccount_serviceName);
        response.then().body("message", equalTo("Account deleted!"));
        return this;
    }

    @Step("Validate User Not Found In The System")
    public ApisAccountManagement validateUserNotFound(String email) {
        getUserDetailByEmail(email);
        Response response = RestAssured.given().get(baseUrl + getUserDetailByEmail_serviceName);
        response.then().body("message", equalTo("Account not found with this email, try another email!"));
        return this;
    }
}
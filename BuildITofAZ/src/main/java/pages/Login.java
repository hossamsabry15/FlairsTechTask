package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.BrowserActions;
import utilities.ElementActions;

public class Login {
    private WebDriver driver;
    private String url = System.getProperty("baseUrl");

    public Login(WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By resetPasswordButton = By.cssSelector("resetPassword");
    private By registerButton = By.id("");
    private By loginButton = By.id("");
    private By errorMessageInvalidEmailFormat = By.id("");
    private By errorMessageIncorrectEmailOrPassword = By.id("");
    private By loginPage = By.cssSelector("[data-cy='CardBody']");

    /////////// Actions \\\\\\\\\\\\
    @Step("Navigate to Login Page")
    public Login navigate() {
        BrowserActions.navigate(driver, url);
        return this;
    }
    @Step("Enter the email {email}")
    public Login enterEmail(String email) {
        ElementActions.enterData(driver, emailField, email);
        return this;
    }
    @Step("Enter the password {password}")
    public Login enterPassword(String password) {
        ElementActions.enterData(driver, passwordField, password);
        return this;
    }
    @Step("Click on 'Reset password' Button")
    public Login clickOnResetPassword() {
        ElementActions.click(driver, resetPasswordButton);
        return this;
    }
    @Step("Click on 'Login' Button")
    public Login clickOnLogin() {
        ElementActions.click(driver, loginButton);
        return this;
    }
    @Step("Click on 'Register' Button")
    public Login clickOnRegister() {
        ElementActions.click(driver, registerButton);
        return this;
    }
    ///////////////// Validations \\\\\\\\\\\\
    @Step("Validate on 'Login' page")
    public Login validateOnLoginPage() {
        driver.findElement(loginPage).isDisplayed();
        System.out.println("Validating on Login Page");
        return this;
    }
    @Step("Assert on error message when entering a invalid email, Should be {expectedMessage}")
    public Login assertOnErrorMessageInvalidEmailFormat(String expectedMessage) {
        Assert.assertEquals(ElementActions.getElementText(driver, errorMessageInvalidEmailFormat), expectedMessage);
        return this;
    }
    @Step("Assert on error message when entering an incorrect email or password, Should be {expectedMessage}")
    public Login assertOnErrorMessageIncorrectEmailOrPassword(String expectedMessage) {
        Assert.assertEquals(ElementActions.getElementText(driver, errorMessageIncorrectEmailOrPassword), expectedMessage);
        return this;
    }
}

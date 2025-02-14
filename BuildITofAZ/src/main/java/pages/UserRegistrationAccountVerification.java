package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ElementActions;

public class UserRegistrationAccountVerification {
    private WebDriver driver;

    public UserRegistrationAccountVerification(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By firstCodeDigit = By.id("");
    private By secondCodeDigit = By.id("");
    private By thirdCodeDigit = By.id("");
    private By fourthCodeDigit = By.id("");
    private By fifthCodeDigit = By.id("");
    private By sixCodeDigit = By.id("");
    private By seventhCodeDigit = By.id("");
    private By eighthCodeDigit = By.id("");
    private By resendButton = By.id("");
    private By backButton = By.id("");
    private By verifyButton = By.id("");
    private By errorMessageWrongCode = By.id("");
    private By verificationCodePage = By.id("");

    /////////// Actions \\\\\\\\\\\\
    @Step("Enter the verification code {code}")
    public UserRegistrationAccountVerification enterVerificationCode(String[] code) {
        ElementActions.enterData(driver, firstCodeDigit, code[0]);
        ElementActions.enterData(driver, secondCodeDigit, code[1]);
        ElementActions.enterData(driver, thirdCodeDigit, code[2]);
        ElementActions.enterData(driver, fourthCodeDigit, code[3]);
        ElementActions.enterData(driver, fifthCodeDigit, code[4]);
        ElementActions.enterData(driver, sixCodeDigit, code[5]);
        ElementActions.enterData(driver, seventhCodeDigit, code[6]);
        ElementActions.enterData(driver, eighthCodeDigit, code[7]);
        return this;
    }
    @Step("Click on 'Resend' Button")
    public UserRegistrationAccountVerification clickOnResend() {
        ElementActions.click(driver, resendButton);
        return this;
    }
    @Step("Click on 'Back' Button")
    public UserRegistrationAccountVerification clickOnBack() {
        ElementActions.click(driver, backButton);
        return this;
    }
    @Step("Click on 'Verify' Button")
    public UserRegistrationAccountVerification clickOnVerify() {
        ElementActions.click(driver, verifyButton);
        return this;
    }

    ///////////////// Validations \\\\\\\\\\\\
    @Step("Validate on 'Verification Code' page")
    public UserRegistrationAccountVerification validateOnVerificationCodePage(String expectedText) {
        driver.findElement(verificationCodePage).isDisplayed();
        return this;
    }
    @Step("Assert on error message when entering a wrong code, Should be {expectedMessage}")
    public UserRegistrationAccountVerification assertOnErrorMessageWrongCode(String expectedMessage) {
        Assert.assertEquals(driver.findElement(errorMessageWrongCode).getText(), expectedMessage);
        return this;
    }
}

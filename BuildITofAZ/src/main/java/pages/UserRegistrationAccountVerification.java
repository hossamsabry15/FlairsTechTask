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
    private By firstCodeDigit = By.cssSelector("([data-cy='confirmationCodeField_input'])[1]");
    private By secondCodeDigit = By.cssSelector("([data-cy='confirmationCodeField_input'])[2]");
    private By thirdCodeDigit = By.cssSelector("([data-cy='confirmationCodeField_input'])[3]");
    private By fourthCodeDigit = By.cssSelector("([data-cy='confirmationCodeField_input'])[4]");
    private By fifthCodeDigit = By.cssSelector("([data-cy='confirmationCodeField_input'])[5]");
    private By sixCodeDigit = By.cssSelector("([data-cy='confirmationCodeField_input'])[6]");
    private By resendButton = By.cssSelector("[data-cy='resendButton']");
    private By backButton = By.cssSelector("[data-cy='backButton']");
    private By verifyButton = By.cssSelector("[data-cy='submitVerifyButton']");
    private By errorMessageWrongCode = By.xpath("//p[@class=\"sc-19e7a3e9-0 jaVBfY\"]");
    private By verificationCodePage = By.cssSelector("[data-cy='verifyForm']");

    /////////// Actions \\\\\\\\\\\\
    @Step("Enter the verification code {code}")
    public UserRegistrationAccountVerification enterVerificationCode(String[] code) {
        ElementActions.enterData(driver, firstCodeDigit, code[0]);
        ElementActions.enterData(driver, secondCodeDigit, code[1]);
        ElementActions.enterData(driver, thirdCodeDigit, code[2]);
        ElementActions.enterData(driver, fourthCodeDigit, code[3]);
        ElementActions.enterData(driver, fifthCodeDigit, code[4]);
        ElementActions.enterData(driver, sixCodeDigit, code[5]);
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

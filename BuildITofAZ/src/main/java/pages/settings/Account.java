package pages.settings;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ElementActions;

public class Account {
    private static final String REQUIRED_FIELD_ERROR_MESSAGE = "This field is required.";
    private WebDriver driver;

    public Account(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By accountPage = By.cssSelector("[data-cy='CardBody']");

    private By emailAddressField = By.cssSelector("[data-cy='email-address']");
    private By phoneNumberField = By.cssSelector("[data-cy='phone-number']");
    private By firstNameField = By.cssSelector("[data-cy='first-name']");
    private By emailEditIcon = By.cssSelector("[data-cy='email-edit-icon']");

    private By firstCodeDigit = By.id("");
    private By secondCodeDigit = By.id("");
    private By thirdCodeDigit = By.id("");
    private By fourthCodeDigit = By.id("");
    private By fifthCodeDigit = By.id("");
    private By sixCodeDigit = By.id("");
    private By seventhCodeDigit = By.id("");
    private By eighthCodeDigit = By.id("");

    private By phoneEditIcon = By.cssSelector("[data-cy='phone-edit-icon']");
    private By companyNameField = By.cssSelector("[data-cy='company-name']");
    private By lastNameField = By.cssSelector("[data-cy='last-name']");
    private By address1Field = By.cssSelector("[data-cy='address-1']");
    private By address2Field = By.cssSelector("[data-cy='address-2']");
    private By cityField = By.cssSelector("[data-cy='city']");
    private By postalCodeField = By.cssSelector("[data-cy='postal-code']");
    private By stateDropDown = By.cssSelector("[data-cy='state']");
    private By dayDropDown = By.cssSelector("[data-cy='day']");
    private By monthDropDown = By.cssSelector("[data-cy='month']");
    private By yearDropDown = By.cssSelector("[data-cy='year']");
    private By saveChangesButton = By.cssSelector("[data-cy='save-changes']");
    private By confirmationMessage = By.cssSelector("[data-cy='confirmation-message']");
    private By emailErrorMessage = By.cssSelector("[data-cy='email-error-message']");
    private By phoneErrorMessage = By.cssSelector("[data-cy='phone-error-message']");
    private By firstNameErrorMessage = By.cssSelector("[data-cy='first-name-error-message']");
    private By lastNameErrorMessage = By.cssSelector("[data-cy='last-name-error-message']");
    private By companyNameErrorMessage = By.cssSelector("[data-cy='company-name-error-message']");
    private By address1ErrorMessage = By.cssSelector("[data-cy='address-1-error-message']");
    private By address2ErrorMessage = By.cssSelector("[data-cy='address-2-error-message']");
    private By cityErrorMessage = By.cssSelector("[data-cy='city-error-message']");
    private By postalCodeErrorMessage = By.cssSelector("[data-cy='postal-code-error-message']");
    private By countryErrorMessage = By.cssSelector("[data-cy='country-error-message']");
    private By stateErrorMessage = By.cssSelector("[data-cy='state-error-message']");
    private By dayErrorMessage = By.cssSelector("[data-cy='day-error-message']");
    private By monthErrorMessage = By.cssSelector("[data-cy='month-error-message']");
    private By yearErrorMessage = By.cssSelector("[data-cy='year-error-message']");

    /////////// Actions \\\\\\\\\\\\
    @Step("Enter Email Address: {email}")
    public Account enterEmailAddress(String email) {
        ElementActions.enterData(driver, emailAddressField, email);
        return this;
    }
    @Step("Enter the verification code {code}")
    public Account enterVerificationCode(String[] code) {
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
    @Step("Enter Phone Number: {phone}")
    public Account enterPhoneNumber(String phone) {
        ElementActions.enterData(driver, phoneNumberField, phone);
        return this;
    }

    @Step("Click on Email Edit Icon")
    public Account clickOnEmailEditIcon() {
        ElementActions.click(driver, emailEditIcon);
        return this;
    }
    @Step("Click on Phone Edit Icon")
    public Account clickOnPhoneEditIcon() {
        ElementActions.click(driver, phoneEditIcon);
        return this;
    }

    @Step("Enter First Name: {firstName}")
    public Account enterFirstName(String firstName) {
        ElementActions.enterData(driver, firstNameField, firstName);
        return this;
    }

    @Step("Enter Company Name: {companyName}")
    public Account enterCompanyName(String companyName) {
        ElementActions.enterData(driver, companyNameField, companyName);
        return this;
    }

    @Step("Enter Last Name: {lastName}")
    public Account enterLastName(String lastName) {
        ElementActions.enterData(driver, lastNameField, lastName);
        return this;
    }


    @Step("Enter Address 1: {address1}")
    public Account enterAddress1(String address1) {
        ElementActions.enterData(driver, address1Field, address1);
        return this;
    }

    @Step("Enter Address 2: {address2}")
    public Account enterAddress2(String address2) {
        ElementActions.enterData(driver, address2Field, address2);
        return this;
    }

    @Step("Enter City: {city}")
    public Account enterCity(String city) {
        ElementActions.enterData(driver, cityField, city);
        return this;
    }

    @Step("Enter Postal Code: {postalCode}")
    public Account enterPostalCode(String postalCode) {
        ElementActions.enterData(driver, postalCodeField, postalCode);
        return this;
    }

    @Step("Select State: {state}")
    public Account selectState(String state) {
        ElementActions.selectByVisibleText(driver, stateDropDown, state);
        return this;
    }

    @Step("Select Day: {day}")
    public Account selectDay(String day) {
        ElementActions.selectByVisibleText(driver, dayDropDown, day);
        return this;
    }

    @Step("Select Month: {month}")
    public Account selectMonth(String month) {
        ElementActions.selectByVisibleText(driver, monthDropDown, month);
        return this;
    }

    @Step("Select Year: {year}")
    public Account selectYear(String year) {
        ElementActions.selectByVisibleText(driver, yearDropDown, year);
        return this;
    }

    @Step("Click on Save Changes Button")
    public Account clickOnSaveChangesButton() {
        ElementActions.click(driver, saveChangesButton);
        return this;
    }

    ///////////////// Validations \\\\\\\\\\\\
    @Step("Validate on 'Account' page")
    public Account validateOnAccountPage() {
        driver.findElement(accountPage).isDisplayed();
        System.out.println("Validating on Account Page");
        return this;
    }
    @Step("Validate Save Changes Button is Disabled")
    public Account validateSaveChangesButtonIsDisabled() {
        Assert.assertFalse(driver.findElement(saveChangesButton).isEnabled());
        return this;
    }

    @Step("Validate Save Changes Button is Enabled")
    public Account validateSaveChangesButtonIsEnabled() {
        Assert.assertTrue(driver.findElement(saveChangesButton).isEnabled());
        return this;
    }

    @Step("Validate Confirmation Message is Displayed")
    public void validateConfirmationMessageIsDisplayed(String message) {
        Assert.assertEquals(ElementActions.getElementText(driver, confirmationMessage), message);
    }

    @Step("Validate Error Message is Displayed for Email Address Field")
    public Account validateErrorMessageIsDisplayedForEmailAddressField() {
        Assert.assertEquals(ElementActions.getElementText(driver, emailErrorMessage), REQUIRED_FIELD_ERROR_MESSAGE);
        return this;
    }

    @Step("Validate Error Message is Displayed for Phone Number Field")
    public Account validateErrorMessageIsDisplayedForPhoneNumberField() {
        Assert.assertEquals(ElementActions.getElementText(driver, phoneErrorMessage), REQUIRED_FIELD_ERROR_MESSAGE);
        return this;
    }

    @Step("Validate Error Message is Displayed for First Name Field")
    public Account validateErrorMessageIsDisplayedForFirstNameField() {
        Assert.assertEquals(ElementActions.getElementText(driver, firstNameErrorMessage), REQUIRED_FIELD_ERROR_MESSAGE);
        return this;
    }

    @Step("Validate Error Message is Displayed for Last Name Field")
    public Account validateErrorMessageIsDisplayedForLastNameField() {
        Assert.assertEquals(ElementActions.getElementText(driver, lastNameErrorMessage), REQUIRED_FIELD_ERROR_MESSAGE);
        return this;
    }

    @Step("Validate Error Message is Displayed for Company Name Field")
    public Account validateErrorMessageIsDisplayedForCompanyNameField() {
        Assert.assertEquals(ElementActions.getElementText(driver, companyNameErrorMessage), REQUIRED_FIELD_ERROR_MESSAGE);
        return this;
    }

    @Step("Validate Error Message is Displayed for Address 1 Field")
    public Account validateErrorMessageIsDisplayedForAddress1Field() {
        Assert.assertEquals(ElementActions.getElementText(driver, address1ErrorMessage), REQUIRED_FIELD_ERROR_MESSAGE);
        return this;
    }

    @Step("Validate Error Message is Displayed for Address 2 Field")
    public Account validateErrorMessageIsDisplayedForAddress2Field() {
        Assert.assertEquals(ElementActions.getElementText(driver, address2ErrorMessage), REQUIRED_FIELD_ERROR_MESSAGE);
        return this;
    }

    @Step("Validate Error Message is Displayed for City Field")
    public Account validateErrorMessageIsDisplayedForCityField() {
        Assert.assertEquals(ElementActions.getElementText(driver, cityErrorMessage), REQUIRED_FIELD_ERROR_MESSAGE);
        return this;
    }

    @Step("Validate Error Message is Displayed for Postal Code Field")
    public Account validateErrorMessageIsDisplayedForPostalCodeField() {
        Assert.assertEquals(ElementActions.getElementText(driver, postalCodeErrorMessage), REQUIRED_FIELD_ERROR_MESSAGE);
        return this;
    }

    @Step("Validate Error Message is Displayed for Country Field")
    public Account validateErrorMessageIsDisplayedForCountryField() {
        Assert.assertEquals(ElementActions.getElementText(driver, countryErrorMessage), REQUIRED_FIELD_ERROR_MESSAGE);
        return this;
    }

    @Step("Validate Error Message is Displayed for State Field")
    public Account validateErrorMessageIsDisplayedForStateField() {
        Assert.assertEquals(ElementActions.getElementText(driver, stateErrorMessage), REQUIRED_FIELD_ERROR_MESSAGE);
        return this;
    }

    @Step("Validate Error Message is Displayed for Day Field")
    public Account validateErrorMessageIsDisplayedForDayField() {
        Assert.assertEquals(ElementActions.getElementText(driver, dayErrorMessage), REQUIRED_FIELD_ERROR_MESSAGE);
        return this;
    }

    @Step("Validate Error Message is Displayed for Month Field")
    public Account validateErrorMessageIsDisplayedForMonthField() {
        Assert.assertEquals(ElementActions.getElementText(driver, monthErrorMessage), REQUIRED_FIELD_ERROR_MESSAGE);
        return this;
    }

    @Step("Validate Error Message is Displayed for Year Field")
    public void validateErrorMessageIsDisplayedForYearField() {
        Assert.assertEquals(ElementActions.getElementText(driver, yearErrorMessage), REQUIRED_FIELD_ERROR_MESSAGE);
    }
}

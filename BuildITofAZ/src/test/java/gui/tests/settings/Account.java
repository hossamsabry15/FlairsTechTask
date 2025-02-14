package gui.tests.settings;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Header;
import utilities.DriverFactory;
import utilities.JsonFileManager;
import utilities.PropertiesReader;

public class Account {
    // Variables
    private WebDriver driver;
    JsonFileManager testData;
    private String timeStamp;

    // Test Cases
    @Test(description = "Update Account Information with Valid Data")
    @Description("Given that I am a registered user, When I enter valid data in all fields, Then the account should be created successfully")
    public void testUpdateAccountInformation() {
        //Register and Delete user with APIs still not implemented
        new pages.Login(driver)
                .enterEmail(testData.getTestData("Email"))
                .enterPassword(testData.getTestData("Password"))
                .clickOnLogin();
        new pages.Dashboard(driver)
                .validateOnDashboardPage();
        new Header(driver)
                .clickOnSettingButton();

        // Update account information
        new pages.settings.Account(driver)
                .validateOnAccountPage()
                .clickOnEmailEditIcon()
                .enterEmailAddress("newemail@example.com")
                .clickOnPhoneEditIcon()
                .enterVerificationCode(new String[]{"1", "2", "3", "4", "5", "6", "7", "8"})
                .enterPhoneNumber("1234567890")
                .enterFirstName("John")
                .enterLastName("Doe")
                .enterCompanyName("Example Inc.")
                .enterAddress1("123 Main St")
                .enterAddress2("Apt 4B")
                .enterCity("New York")
                .enterPostalCode("10001")
                .selectState("NY")
                .selectDay("01")
                .selectMonth("January")
                .selectYear("1990")
                .clickOnSaveChangesButton()
                .validateConfirmationMessageIsDisplayed("Account information updated successfully");

    }
    @Test(description = "Update Account Information with Invalid Data")
    @Description("Given that I am a registered user, When I enter invalid data in various fields, Then appropriate error messages should appear next to each invalid field")
    public void testUpdateAccountInformationWithInvalidData() {
        new pages.Login(driver)
                .enterEmail(testData.getTestData("Email"))
                .enterPassword(testData.getTestData("Password"))
                .clickOnLogin();
        new pages.Dashboard(driver)
                .validateOnDashboardPage();
        new Header(driver)
                .clickOnSettingButton();

        // Attempt to update account information with invalid data
        new pages.settings.Account(driver)
                .validateOnAccountPage()
                .clickOnEmailEditIcon()
                .enterEmailAddress("invalid-email")
                .validateErrorMessageIsDisplayedForEmailAddressField()
                .clickOnPhoneEditIcon()
                .enterPhoneNumber("invalid-phone")
                .validateErrorMessageIsDisplayedForPhoneNumberField()
                .enterFirstName("John123")
                .enterLastName("Doe@")
                .enterCompanyName("!@#")
                .enterAddress1("!@#")
                .enterAddress2("!@#")
                .enterCity("123City")
                .enterPostalCode("ABCDE")
                .selectDay("32")
                .selectMonth("InvalidMonth")
                .selectYear("1890")
                .validateErrorMessageIsDisplayedForFirstNameField()
                .validateErrorMessageIsDisplayedForLastNameField()
                .validateErrorMessageIsDisplayedForAddress1Field()
                .validateErrorMessageIsDisplayedForAddress2Field()
                .validateErrorMessageIsDisplayedForCityField()
                .validateErrorMessageIsDisplayedForPostalCodeField()
                .validateErrorMessageIsDisplayedForDayField()
                .validateErrorMessageIsDisplayedForMonthField()
                .validateErrorMessageIsDisplayedForYearField();
    }

    //////////////////////// Configurations \\\\\\\\\\\\\\\\\\\\\\\\\\\
    @BeforeClass
    public void beforeClass() {
        PropertiesReader.loadProperties();
        testData = new JsonFileManager("src/test/resources/TestDataJsonFiles/Account/AccountTestsTestData.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        timeStamp = String.valueOf(System.currentTimeMillis());
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

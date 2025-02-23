package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;

public class Header {

    private WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By dashboardButton = By.cssSelector("[data-cy='']");
    private By fireArmsButton = By.cssSelector("[data-cy='']");
    private By salesButton = By.cssSelector("[data-cy='']");
    private By notificationIcon = By.cssSelector("[data-cy='']");
    private By settingButton = By.cssSelector("[data-cy='']");
    private By accountIcon = By.cssSelector("[data-cy='']");

    /////////// Actions \\\\\\\\\\\\
    @Step("Click on 'Dashboard' Button")
    public Header clickOnDashboardButton() {
        ElementActions.click(driver, dashboardButton);
        return this;
    }
    @Step("Click on 'Fire Arms' Button")
    public Header clickOnFireArmsButton() {
        ElementActions.click(driver, fireArmsButton);
        return this;
    }

    @Step("Click on 'Sales' Button")
    public Header clickOnSalesButton() {
        ElementActions.click(driver, salesButton);
        return this;
    }

    @Step("Click on 'Notification' Icon")
    public Header clickOnNotificationIcon() {
        ElementActions.click(driver, notificationIcon);
        return this;
    }
    @Step("Click on 'Setting' Button")
    public Header clickOnSettingButton() {
        ElementActions.click(driver, settingButton);
        return this;
    }
    @Step("Click on 'Account' Icon")
    public Header clickOnAccountIcon() {
        ElementActions.click(driver, accountIcon);
        return this;
    }

    /////////// Validations \\\\\\\\\\\\

}

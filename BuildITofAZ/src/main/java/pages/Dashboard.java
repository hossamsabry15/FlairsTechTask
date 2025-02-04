package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {
    private WebDriver driver;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    private By dashboardPage = By.id("");

    /////////// Actions \\\\\\\\\\\\

    ///////////////// Validations \\\\\\\\\\\\
    @Step("Validate on 'Dashboard' page")
    public Dashboard validateOnDashboardPage() {
        driver.findElement(dashboardPage).isDisplayed();
        return this;
    }
}

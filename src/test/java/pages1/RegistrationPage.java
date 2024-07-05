package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    WebDriver driver;

    // Locators
    By myAccountLink = By.linkText("My Account");
    By registerLink = By.linkText("Register");
    By firstNameField = By.id("input-firstname");
    By lastNameField = By.id("input-lastname");
    By emailField = By.id("input-email");
    By phoneField = By.id("input-telephone");
    By passwordField = By.id("input-password");
    By confirmPasswordField = By.id("input-confirm");
    By newsletterOption = By.name("newsletter");
    By termsCheckbox = By.name("agree");
    By continueButton = By.cssSelector("input[type='submit']");

    // Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page actions
    public void clickMyAccount() {
        driver.findElement(myAccountLink).click();
    }

    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void selectNewsletter() {
        WebElement newsletter = driver.findElement(newsletterOption);
        if (!newsletter.isSelected()) {
            newsletter.click();
        }
    }

    public void agreeToTerms() {
        WebElement terms = driver.findElement(termsCheckbox);
        if (!terms.isSelected()) {
            terms.click();
        }
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }
}

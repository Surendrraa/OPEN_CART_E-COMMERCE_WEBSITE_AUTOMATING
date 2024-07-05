package stepdefin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages1.RegistrationPage;

public class RegistrationSteps {

    WebDriver driver;
    RegistrationPage registrationPage;

    @BeforeClass
    public void setup() {
    	 WebDriverManager.firefoxdriver().setup();
         driver = new FirefoxDriver();
         driver.manage().window().maximize();
        driver.get("https://naveenautomationlabs.com/opencart/");
        registrationPage = new RegistrationPage(driver);
    }

    @DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() {
        return new Object[][] {
            {"C V Surendra", "Surendra", "cvsurendra2001@gmail.com", "8186874383", "Phani@123", "Phani@123", true}, // New User
            {"C V Surendra", "Surendra", "cvsurendra2001@gmail.com", "8186874383", "Phani@123", "Phani@123", false}, // Existing User
            {"C V Surendra", "Surendra", "cvsurendra2001@gmail.com", "8186874383", "Phani@123", "Phani@", false}, // Wrong Confirm Password
            {"C V Surendra", "Surendra", "cvsurendra2001@gmail.com", "8186874383", "Phani@12", "Phani@123", false}, // Wrong Password
            {"C V Surendra", "Surendra", "cvsurendra2001@gmail.com", "8186874", "Phani@123", "Phani@123", false}, // Invalid Phone
            {"C V Surendra", "Surendra", "cvsurendra2001@", "8186874383", "Phani@123", "Phani@123", false}, // Invalid Email
            {"", "Surendra", "cvsurendra2001@gmail.com", "8186874383", "Phani@123", "Phani@", false}, // Blank First Name
            {"C V Surendra", "", "cvsurendra2001@gmail.com", "8186874383", "Phani@12", "Phani@123", false}, // Blank Last Name
            {"C V Surendra", "Surendra", "", "8186874383", "Phani@123", "Phani@123", false}, // Blank Email
            {"C V Surendra", "Surendra", "cvsurendra2001@gmail.com", "", "Phani@123", "Phani@123", false}, // Blank Phone
            {"C V Surendra", "Surendra", "cvsurendra2001@gmail.com", "8186874383", "", "Phani@123", false}, // Blank Password
            {"C V Surendra", "Surendra", "cvsurendra2001@gmail.com", "8186874383", "Phani@123", "", false}, // Blank Confirm Password
            {"", "", "", "", "", "", false}, // All Fields Blank
            {"345566", "$$$", "85949jjbbb", "% $", "% $ $ $", "!&%", false}, // Different Symbols
        };
    }

    @Test(dataProvider = "registrationData")
    public void testRegistration(String firstName, String lastName, String email, String phone, String password, String confirmPassword, boolean isSuccess) throws InterruptedException {
        registrationPage.clickMyAccount();
        registrationPage.clickRegisterLink();
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.enterEmail(email);
        registrationPage.enterPhone(phone);
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(confirmPassword);
        registrationPage.selectNewsletter();
        registrationPage.agreeToTerms();
        registrationPage.clickContinue();

        
         // Wait for the registration to complete

       
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

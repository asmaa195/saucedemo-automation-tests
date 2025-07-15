import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.io.FileHandler;

import org.testng.Assert;
import java.io.File;
import java.time.Duration;

public class SauceDemoInvalidLogin {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(3000);

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginbutton = driver.findElement(By.id("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("hghgkiguigui");
        loginbutton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[data-test='error']")));

        String actualMsg = errorMsg.getText();
        String expectedMsg = "Epic sadface: WRONG MESSAGE";

        try {
            Assert.assertEquals(actualMsg, expectedMsg);
            System.out.println(" Error message is correct.");
        } catch (AssertionError e) {
            System.out.println(" Assertion failed. Taking screenshot...");

            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileHandler.copy(screenshot, new File("screenshots/login_error.png"));
                System.out.println("📸 Screenshot saved to screenshots/login_error.png");
            } catch (Exception ex) {
                System.out.println("⚠️ Couldn't save screenshot.");
            }

            throw e;
        } finally {
            driver.quit();
        }
    }
}

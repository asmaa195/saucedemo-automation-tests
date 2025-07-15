import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.time.Duration;
import java.io.IOException;


public class SauceDemoValidLogin {
    public static void main(String[]args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement username=driver.findElement(By.id("user-name"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement loginbtn=driver.findElement(By.id("login-button"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginbtn.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        String timestamp=String.valueOf(System.currentTimeMillis());
        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File("screenshots/first_page" + timestamp + ".png"));
            System.out.println("📸 Screenshot saved successfully.");
        } catch (IOException e) {
            System.out.println(" Couldn't save screenshot.");
            e.printStackTrace();
        }
            driver.quit();
        }

    }


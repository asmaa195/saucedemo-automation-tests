
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SauceDemoLoginTest {
public static void main(String[]args) throws InterruptedException
{
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    driver.get("https://www.saucedemo.com/");
    Thread.sleep(2000);
    WebElement username = driver.findElement(By.id("user-name"));
    WebElement password=driver.findElement(By.id("password"));
    WebElement loginBtn = driver.findElement(By.id("login-button"));
    username.sendKeys("standard_user");
    password.sendKeys("secret_sauce");
    loginBtn.click();
    System.out.println("login succefully");
    driver.quit();
}

}

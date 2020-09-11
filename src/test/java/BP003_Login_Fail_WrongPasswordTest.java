import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class BP003_Login_Fail_WrongPasswordTest {

    @Test
    public void main() throws InterruptedException {
        WebDriver driver;
        WebDriverWait wait;
        FirefoxOptions options = new FirefoxOptions();

        options.addArguments("--disable-notification");

        System.setProperty("webdriver.gecko.driver", "D:\\Sekolah QA Cilsy\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();

        //open orangeHRM website
        driver.get("http://130.211.230.133");
        //verify url orangeHRM
        System.out.println("Current Url is: " + driver.getCurrentUrl());
        //verify homepage/loginpage with image
        String loginPanel = driver.findElement(By.id("logInPanelHeading")).getText();
        Assert.assertEquals("LOGIN Panel", loginPanel);
        //input Username
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        //input Password
        driver.findElement(By.id("txtPassword")).sendKeys("Admin");
        //click login Button
        driver.findElement(By.id("btnLogin")).click();
        //verify alert Invalid credentials
        String wrongPass = driver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals("Invalid credentials", wrongPass);
    }
}
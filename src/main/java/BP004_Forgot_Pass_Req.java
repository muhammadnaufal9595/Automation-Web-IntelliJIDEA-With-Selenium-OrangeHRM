import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BP004_Forgot_Pass_Req {
    public static void main(String[] args) throws InterruptedException {
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
        //verify homepage/loginpage
        String loginPanel = driver.findElement(By.id("logInPanelHeading")).getText();
        Assert.assertEquals("LOGIN Panel", loginPanel);
        //click forgot password
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[5]/div/a")).click();
        //verify forgot password page
        System.out.println("Current Url is: " + driver.getCurrentUrl());
        String forgotPass = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/h1")).getText();
        Assert.assertEquals("Forgot Your Password?", forgotPass);
        //input username
        driver.findElement(By.id("securityAuthentication_userName")).sendKeys("aadmin");
        //click reset password button
        driver.findElement(By.id("btnSearchValues")).click();
    }
}

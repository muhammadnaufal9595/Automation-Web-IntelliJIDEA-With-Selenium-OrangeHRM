import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class BP005_Success_Add_EmployeeTest {

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
        //verify homepage/loginpage
        String loginPanel = driver.findElement(By.id("logInPanelHeading")).getText();
        Assert.assertEquals("LOGIN Panel", loginPanel);
        //input Username
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        //input Password
        driver.findElement(By.id("txtPassword")).sendKeys("s3Kol4HQA!*");
        //click login Button
        driver.findElement(By.id("btnLogin")).click();
        //verify url orangeHRM
        System.out.println("Current Url is: " + driver.getCurrentUrl());
        //verify dashboard orangeHRM
        String welcomeDashboard = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals("Welcome Muhammad", welcomeDashboard);
        //Click PIM button
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        //verify url PIMUrl
        System.out.println("Current Url is: " + driver.getCurrentUrl());
        String employeeList = driver.findElement(By.id("menu_pim_viewEmployeeList")).getText();
        Assert.assertEquals("Employee List", employeeList);
        //click add button
        driver.findElement(By.id("btnAdd")).click();
        //verify url add employee
        System.out.println("Current Url is: " + driver.getCurrentUrl());
        String employeeAdd = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
        Assert.assertEquals("Add Employee", employeeAdd);
        //input first name
        driver.findElement(By.id("firstName")).sendKeys("Expecto");
        //input last name
        driver.findElement(By.id("lastName")).sendKeys("Petronum");
        //click save button
        driver.findElement(By.id("btnSave")).click();
        //verify url success add employee
        System.out.println("Current Url is: " + driver.getCurrentUrl());
        String employeeAddSuccess = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/h1")).getText();
        Assert.assertEquals("Personal Details", employeeAddSuccess);
    }
}
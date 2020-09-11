import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class BP007_Search_Employee_by_EmployeeIdTest {

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
        //input valid employee id
        driver.findElement(By.id("empsearch_id")).sendKeys("0001");
        //click search button
        driver.findElement(By.id("searchBtn")).click();
        //verify user is available
        String idSatu = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a")).getText();
        Assert.assertEquals("0001", idSatu);
    }
}
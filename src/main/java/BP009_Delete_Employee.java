import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BP009_Delete_Employee {
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
        //select or checklist employee
        driver.findElement(By.id("ohrmList_chkSelectRecord_4")).click();
        //click delete button
        driver.findElement(By.id("btnDelete")).click();
        //verify alert confirmation is visible
        String deleteConfirm = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[1]/h3")).getText();
        Assert.assertEquals("OrangeHRM - Confirmation Required", deleteConfirm);
        String deleteEmp = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/p")).getText();
        Assert.assertEquals("Delete records?", deleteEmp);
        //click ok button
        driver.findElement(By.id("dialogDeleteBtn")).click();
    }
}

package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testffc.nimapinfotech.com/");
        driver.findElement(By.id("mat-input-0"));
		driver.findElement(By.id("mat-input-0")).sendKeys("stajane107@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("mat-input-1"));
		driver.findElement(By.id("mat-input-1")).sendKeys("Admin@234");
		Thread.sleep(2000);
		driver.findElement(By.id("kt_login_signin_submit")).click();
		driver.findElement(By.id("toast-container")).click();
		Thread.sleep(2000);
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
            {"stajane107@gmail.com", "Admin@234"}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String email, String password) throws InterruptedException {
        driver.findElement(By.id("mat-input-0")).sendKeys("stajane107@gmail.com");
        driver.findElement(By.id("mat-input-1")).sendKeys("Admin@234");
        driver.findElement(By.id("kt_login_signin_submit")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Dashboard"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

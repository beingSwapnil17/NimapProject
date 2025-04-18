package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class CustomerTest {
    WebDriver driver;

    @DataProvider(name = "customerData")
    public Object[][] customerInfo() {
        return new Object[][] {
            {"Swapnil Enterprises", "swapnil123", "Maharashtra", "India"}
        };
    }

    @Test(dataProvider = "customerData")
    public void addCustomer(String name, String code, String state, String country) throws InterruptedException {
    	 WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://testffc.nimapinfotech.com/");
         driver.findElement(By.id("mat-input-0"));
 		driver.findElement(By.id("mat-input-0")).sendKeys("stajane107@gmail.com");
 		Thread.sleep(2000);
 		driver.findElement(By.id("mat-input-1"));
 		driver.findElement(By.id("mat-input-1")).sendKeys("Admin@234");
 		Thread.sleep(1000);
 		driver.findElement(By.id("kt_login_signin_submit")).click();
 		
        
        driver.findElement(By.className("kt-menu__item kt-menu__item--active kt-menu__item--here ng-star-inserted")).click();
        driver.findElement(By.className("mat-button-wrapper")).click();
        driver.findElement(By.id("mat-input-61")).sendKeys("Sunil");
        driver.findElement(By.className("mat-focus-indicator mat-tooltip-trigger mat-raised-button mat-button-base mat-primary")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        Assert.assertTrue(toast.getText().contains("Customer Added Successfully"));
    }
}

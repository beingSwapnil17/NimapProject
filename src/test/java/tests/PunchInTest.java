package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class PunchInTest {
    WebDriver driver;

    @Test
    public void testPunchInToastMessage() throws InterruptedException{
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
		Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.className("mat-button-wrapper")).click();
        
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mat-button-wrapper")));
        String toastMessage = toast.getText();
        Assert.assertTrue(toastMessage.contains("Punch In Successful"));
       
    }
}

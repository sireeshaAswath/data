package test_scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.JXLException;

public class Scenario3_AddMobileNumber {
	WebDriver driver;

	@Test
	public void AddMobileNumber() throws IOException, JXLException, Exception {
		driver.get("https://www.justrechargeit.com/");
		driver.findElement(By.id("jriTop_signin9")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("txtUserName")).sendKeys("sireesha.v@hotmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("txtPasswd")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.id("imgbtnSignin")).click();
		Thread.sleep(3000);
		//to check its click able are not
		if (driver.findElement(By.className("addMobileLink")).isEnabled()) {
			System.out.println("Its clickable.");
		} else {
			System.out.println("Its Notable to click");
		}
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\siree\\Desktop\\Selenium_Automation\\Library\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@AfterTest
	public void AfterTest() throws Exception {
		driver.findElement(By.id("jriTop_signOut")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}

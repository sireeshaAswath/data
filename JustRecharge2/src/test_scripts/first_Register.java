package test_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class first_Register {
	WebDriver driver;

	@Test
	public void Register() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\siree\\Desktop\\Selenium_Automation\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.justrechargeit.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("signup-link9")).click();
		Thread.sleep(2000);
		// inserting the data
		driver.findElement(By.id("signup_name")).sendKeys("siri");
		Thread.sleep(2000);
		driver.findElement(By.id("signup_mobileno")).sendKeys("9742277920");
		Thread.sleep(2000);
		driver.findElement(By.id("signup_email")).sendKeys("sireesha.v@hotmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("signup_password")).sendKeys("123456");
		Thread.sleep(3000);
		driver.findElement(By.id("checkbox1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkbox")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("imgbtnSubmit")).click();

	}
}

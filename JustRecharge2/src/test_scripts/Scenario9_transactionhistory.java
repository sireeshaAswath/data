package test_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scenario9_transactionhistory {
	WebDriver driver;

	@Test
	public void transactionhistory() throws InterruptedException {
		driver.findElement(By.partialLinkText("My Account")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Transaction History")).click();
		Thread.sleep(2000);
		String orderstatus = driver.findElement(By.id("RepDetails_lnkOrderStatus_0")).getText();
		System.out.println(" Order Status message should be  : " + orderstatus);
		Thread.sleep(2000);
	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\siree\\Desktop\\Selenium_Automation\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.justrechargeit.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("jriTop_signin9")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("txtUserName")).sendKeys("sireesha.v@hotmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("txtPasswd")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.id("imgbtnSignin")).click();
		Thread.sleep(2000);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		driver.findElement(By.id("TopPanel_signOut")).click();
		Thread.sleep(2000);
		driver.quit();

	}
}

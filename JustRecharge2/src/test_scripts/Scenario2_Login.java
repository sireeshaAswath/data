package test_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scenario2_Login {
	WebDriver driver;
  @Test
  public void Login() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\siree\\Desktop\\Selenium_Automation\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.justrechargeit.com/");
		/// login in details
		driver.findElement(By.id("jriTop_signin9")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("txtUserName")).sendKeys("sireesha.v@hotmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("txtPasswd")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.id("imgbtnSignin")).click();
		
  }
}

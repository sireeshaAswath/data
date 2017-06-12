package test_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scenario8_RechargeMobile {
	WebDriver driver;
  @Test
  public void RechargeMobile () throws InterruptedException {
	  
	  driver.findElement(By.id("listingtable_ImgRecharge_1")).click();
		Thread.sleep(2000);
      //link popular recharge
		String parentwindowname = driver.getWindowHandle();
		driver.findElement(By.partialLinkText("View Popular Recharges")).click();
		Thread.sleep(2000);
		// popup will dispaly
		String childwindowname = "PopularRecharges";
		driver.switchTo().window(childwindowname);
		Thread.sleep(3000);
		new Select(driver.findElement(By.id("ddlLocation"))).selectByVisibleText("Assam");;
		Thread.sleep(2000);
		new Select(driver.findElement(By.id("ddlPlanName"))).selectByValue("263");
		Thread.sleep(2000);
		//String actualdata = driver.findElement(By.partialLinkText("71")).getText();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("71")).click();
		//after popup got closed need to do some mouse click on parent window
		driver.switchTo().window(parentwindowname);
		driver.findElement(By.id("disCd")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("lblUserText3")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("11")).click();
		Thread.sleep(2000);
	  driver.findElement(By.id("btnProceedtoPay")).click();
	  Thread.sleep(2000);
	  //If user enters invalid payment details
	  new Select(driver.findElement(By.id("debitCard"))).selectByValue("State Bank of India");
	  Thread.sleep(2000);
	  driver.findElement(By.id("debitCardNumber")).sendKeys("78903456712");
	  Thread.sleep(2000);
	  new Select(driver.findElement(By.id("expiryMonthDebitCard"))).selectByValue("07");
	  Thread.sleep(2000);
	  new Select(driver.findElement(By.id("expiryYearDebitCard"))).selectByValue("2022");
	  Thread.sleep(2000);
	 driver.findElement(By.id("CVVNumberDebitCard")).sendKeys("233");
	 Thread.sleep(2000);
	 driver.findElement(By.className("primary-button-text")).click();
	  
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
	  driver.findElement(By.id("jriTop_signOut")).click();
		Thread.sleep(2000);
		driver.quit();
  }
}

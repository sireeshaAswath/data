package test_scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Scenario7_PopularRecharges {
	WebDriver driver;
	String parentwindowname;

	@Test
	public void PopularRecharges() throws InterruptedException {
		driver.findElement(By.id("listingtable_ImgRecharge_1")).click();
		Thread.sleep(2000);
		// link popular recharge
		driver.findElement(By.partialLinkText("View Popular Recharges")).click();
		Thread.sleep(3000);
		// popup will dispaly
		// String childwindowname = "PopularRecharges";

		Set<String> test = driver.getWindowHandles();
		Iterator<String> iterator = test.iterator();
		String subwindowhandler = null;
		while (iterator.hasNext()) {
			subwindowhandler = iterator.next();
		}
		// switch to popup window
		driver.switchTo().window(subwindowhandler);
		Thread.sleep(3000);
		new Select(driver.findElement(By.id("ddlLocation"))).selectByVisibleText("Assam");
		Thread.sleep(2000);
		new Select(driver.findElement(By.id("ddlPlanName"))).selectByValue("263");
		Thread.sleep(2000);
		String actualdata = driver.findElement(By.partialLinkText("71")).getText();
		System.out.println(actualdata);
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("71")).click();
		// after popup got closed need to do some mouse click on parent window
		driver.switchTo().window(parentwindowname);
		Thread.sleep(4000);
		driver.findElement(By.id("disCd")).click();
		String presentdata = driver.findElement(By.id("txtrechargeval")).getAttribute("value");
		System.out.println(presentdata);
		// Validate selected amount will flow correct or not
		if (actualdata.contentEquals(presentdata)) {
			System.out.println("The selected amount and inserted amount is same");
		} 
		else{
			System.out.println("The selected amount and inserted amount is not same");
		}
	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\siree\\Desktop\\Selenium_Automation\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.justrechargeit.com/");
		parentwindowname = driver.getWindowHandle();
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

	/*
	 * @AfterTest public void afterTest() throws InterruptedException {
	 * driver.findElement(By.id("jriTop_signOut")).click(); Thread.sleep(2000);
	 * driver.quit(); }
	 */

}

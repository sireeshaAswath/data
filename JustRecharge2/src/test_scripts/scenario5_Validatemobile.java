package test_scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class scenario5_Validatemobile {
	WebDriver driver;

	@Test
	public void Validatemobile() throws InterruptedException {
		driver.findElement(By.id("imgbtnSignin")).click();
		Thread.sleep(2000);
		//Add mobile number,the same number edit and do some changes  then click on save button.
		String olddata = driver.findElement(By.id("listingtable_lblGridMobileDTHNo_1")).getText();
		Thread.sleep(2000);
		driver.findElement(By.id("listingtable_btnGridEdit_1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("listingtable_txtMobileDTHNo_1")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("listingtable_txtMobileDTHNo_1")).sendKeys("9000233305");
		Thread.sleep(2000);
		driver.findElement(By.id("listingtable_LinkButton1_1")).click();
		Thread.sleep(2000);
		String newdata = driver.findElement(By.id("listingtable_lblGridMobileDTHNo_1")).getText();
		if (olddata.equals(newdata)) {
			System.out.println("Edit Mobile number functionality is not working successfully");
		} else {
			System.out.println("Edit Mobile number functionality is working successfully");
		}
		//Click on edit icon do some modifications and click on Cancel icon(X).
		driver.findElement(By.id("listingtable_btnGridEdit_1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("listingtable_txtMobileDTHNo_1")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("listingtable_txtMobileDTHNo_1")).sendKeys("9000233308");
		Thread.sleep(2000);
		driver.findElement(By.id("listingtable_btnGridCancel_1")).click();
		Thread.sleep(2000);
		String modifydata = driver.findElement(By.id("listingtable_lblGridMobileDTHNo_1")).getText();
		if (modifydata.equals(newdata)) {
			System.out.println("Edit Mobile number functionality is  working successfully");
		} else {
			System.out.println("Edit Mobile number functionality is not working successfully");
		}
		
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

	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		driver.findElement(By.id("jriTop_signOut")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}

package test_scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Scenario6_Deletefunctionality {
	WebDriver driver;

	@Test
	public void Deletefunctionality() throws InterruptedException {
		driver.findElement(By.id("imgbtnSignin")).click();
		Thread.sleep(2000);
		//getting the text of Add mobile number ,for that same number click on Delete button.
		String data = driver.findElement(By.id("listingtable_lblGridMobileDTHNo_1")).getText();
		System.out.println(data);
		Thread.sleep(3000);
		driver.findElement(By.id("listingtable_btnGridDelete_1")).click();
		Thread.sleep(2000);
		//Click on CANCEL button on Confirmation Alert. 
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.dismiss();
		String nextdata = driver.findElement(By.id("listingtable_lblGridMobileDTHNo_1")).getText();
		Thread.sleep(2000);
		//Validating the data is change are not
		if (data.equals(nextdata)){
			System.out.println("The data is same");
		}
		else{
			System.out.println("The data is not same ");
		}
		//getting the text of Add mobile number,for that same number on Delete button.
		driver.findElement(By.id("listingtable_btnGridDelete_1")).click();
		Thread.sleep(2000);
		//Click on OK button on Confirmation Alert.
		Alert acceptalert = driver.switchTo().alert();
		Thread.sleep(1000);
		acceptalert.accept();
		//Validating the data whether it is deleted are not
		String Newdata = driver.findElement(By.id("listingtable_lblGridMobileDTHNo_1")).getText();
		if (data.equals(Newdata)) {
			System.out.println("The data is not deleted successfully");
		}
		else {
			System.out.println("The data is deleted successfully");
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

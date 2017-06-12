package test_scripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;

public class scenario4_AddMobile {
	WebDriver driver;

	@Test
	public void AddMobile() throws InterruptedException, IOException, JXLException {
		driver.get("https://www.justrechargeit.com/");
		driver.findElement(By.id("jriTop_signin9")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("txtUserName")).sendKeys("sireesha.v@hotmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("txtPasswd")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.id("imgbtnSignin")).click();
		// Thread.sleep(4000);
		// to read data from Xml
		String path = "C:\\Users\\siree\\Desktop\\Selenium_Automation\\Workspce\\JustRecharge\\TestData\\JRI_AddMobileNumber.xls";
		FileInputStream fi = new FileInputStream(path);
		Workbook W = Workbook.getWorkbook(fi);
		Sheet s = W.getSheet("ReTestingData");

		// checking that user able to 10 add mobile numbers are not
		for (int i = 2; i < s.getRows(); i++) {
			Thread.sleep(4000);
			driver.findElement(By.className("addMobileLink")).click();
			Thread.sleep(2000);
			driver.findElement(By.name("txtpopMobileNo")).sendKeys(s.getCell(1, i).getContents());
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("ddlpopMobileSP"))).selectByVisibleText(s.getCell(2, i).getContents());
			// driver.findElement(By.id("ddlpopMobileSP")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("txtpopMobileNickname")).sendKeys(s.getCell(3, i).getContents());
			Thread.sleep(1000);

			if (driver.findElement(By.id("ddlpopMobileLocation")).isDisplayed()) {
				new Select(driver.findElement(By.id("ddlpopMobileLocation"))).selectByVisibleText(s.getCell(4, i).getContents());
			}
			Thread.sleep(1000);
			driver.findElement(By.id("btnPopupAddMobile")).click();
			Thread.sleep(1000);
			if (driver.findElement(By.id("lblpopMobileErrorMsg")).isDisplayed()) {
				String Result = driver.findElement(By.id("lblpopMobileErrorMsg")).getText();
				System.out.println("In 11th row ...>>>>>>>" + Result);
			}

		} // i loop ended

	}

	@BeforeTest
	public void BeforeTest() {
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

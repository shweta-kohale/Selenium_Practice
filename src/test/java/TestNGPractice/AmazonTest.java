package TestNGPractice;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("BM: beforeMethod");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/");
	}

	@Test(priority=2)
	public void getTitle() {
		System.out.println("Title : " + driver.getTitle());
		assertEquals(driver.getTitle(), "Amazon.com. Spend less. Smile more.");
	}

	@Test(priority=1)
	public void search() {
		assertEquals(driver.findElement(By.id("twotabsearchtextbox")).isDisplayed(), true);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

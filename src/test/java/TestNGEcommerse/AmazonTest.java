package TestNGEcommerse;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest extends BaseTest {
	
	

	@Test(priority=2)
	public void getTitle() {
		System.out.println("Title : " + driver.getTitle());
		assertEquals(driver.getTitle(), "Amazon.com. Spend less. Smile more.");
	}

	@Test(priority=1)
	public void search() {
		assertEquals(driver.findElement(By.id("twotabsearchtextbox")).isDisplayed(), true);

	}

	

}

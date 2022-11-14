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

public class GoogleTest extends BaseTest {
	
	

	@Test(priority=2)
	public void getTitle() {
		System.out.println("Title : " + driver.getTitle());
		assertEquals(driver.getTitle(), "Google");
	}

	@Test(priority=1)
	public void search() {
		assertEquals(driver.findElement(By.name("q")).isDisplayed(), true);

	}

	

}

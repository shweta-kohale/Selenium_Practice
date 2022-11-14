package TestNGEcommerse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Cross_Browser.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	
	@BeforeMethod
	@Parameters({"url","browser"})
	public void launchBrowser(String url, String browser) {
		System.out.println("BM: beforeMethod");

		BrowserUtil br = new BrowserUtil();
		driver = br.launchBrowser(browser);
		
		System.out.println("In bm URL"+url);
		driver.get(url);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

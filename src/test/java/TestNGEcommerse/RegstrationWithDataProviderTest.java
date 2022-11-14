package TestNGEcommerse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Cross_Browser.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegstrationWithDataProviderTest {
	
	
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("BM: beforeMethod");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	}
	
	@DataProvider
	public Object[][] getRegisterData() {
		return new Object[][]  {
			
			{"a", "a", "a@gmail.com", "1234567890", "12345"},
			{"b", "b", "b@gmail.com", "1234567897", "12347"},
			{"c", "c", "c@gmail.com", "1234567893", "12348"}
		};
		
	}
	
	@Test(dataProvider="getRegisterData")
	public void register(String fname, String lname, String email, String telephone, String password) {
		doRegister(fname,lname, email, telephone,password);
		//Assert.assertEquals(false, null);
	}

	public void doRegister(String fname, String lname, String email, String telephone, String password) {
		ElementUtil elUtil = new ElementUtil(driver);
		By firstName_loc = By.id("input-firstname");	
		By lastName_loc = By.id("input-lastname");
		By email_loc = By.id("input-email");
		By telephone_loc = By.id("input-telephone");
		By password_loc = By.id("input-password");
		By confirmPassword_loc = By.id("input-confirm");
		
		elUtil.doSendkeys(firstName_loc, fname);
		elUtil.doSendkeys(lastName_loc, lname);
		elUtil.doSendkeys(email_loc, email);
		elUtil.doSendkeys(telephone_loc, telephone);
		elUtil.doSendkeys(password_loc, password);
		elUtil.doSendkeys(confirmPassword_loc, password);
		
		elUtil.doClick(By.xpath("//input[@type=\"checkbox\"]"));
		elUtil.doClick(By.xpath("//input[@type=\"submit\"]"));
		driver.findElement(By.xpath("//h1")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Your Account Has Been Created!");
		
	}

}

package Cross_Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebElementTest {
	
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.getURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		ElementUtil elUtil = new ElementUtil(driver);
		By firstName = By.id("input-firstname");	
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmPassword = By.id("input-confirm");
		
		elUtil.doSendkeys(firstName, "Shweta");
		elUtil.doSendkeys(lastName, "Kohale");
		elUtil.doSendkeys(email, "shweta.kohale@gmail.com");
		elUtil.doSendkeys(telephone, "1234567890");
		elUtil.doSendkeys(password, "Test@123");
		elUtil.doSendkeys(confirmPassword, "Test@123");
		
		//driver.close();
		
	}

}

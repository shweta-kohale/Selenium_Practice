package Cross_Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitAssigment {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		ElementUtil elUtil = new ElementUtil(driver);
		By firstName = By.id("input-firstname");	
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmPassword = By.id("input-confirm");
		By subscribe = By.xpath("//input[@name='newsletter' and@checked='checked']");
		By agree = By.xpath("//input[@name='agree']");
		By continue_btn = By.xpath("//input[@type='submit']");
		By success_msg = By.xpath("//h1");
		
		elUtil.doSendkeysWithWait(firstName, 10, "Shweta");
		//elUtil.doSendkeys(firstName, "Shweta");
		elUtil.doSendkeys(lastName, "Kohale");
		elUtil.doSendkeys(email, "shweta.kohale1@gmail.com");
		elUtil.doSendkeys(telephone, "1234567890");
		elUtil.doSendkeys(password, "Test@123");
		elUtil.doSendkeys(confirmPassword, "Test@123");
		elUtil.doClick(subscribe);
		elUtil.doClick(agree);
		elUtil.doClick(continue_btn);
		
		String success = elUtil.getElementTextWithWait(success_msg, 10);
		System.out.println("Success msg after continue::" + success);
		
		
		
	}

}

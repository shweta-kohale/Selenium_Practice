package Cross_Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementGetAttribute {

public static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		ElementUtil elUtil = new ElementUtil(driver);
		By email = By.id("input-email");
		By password = By.id("input-password");
		System.out.println(elUtil.doGetAttribute(email, "placeholder"));
		
	}

	
	
}

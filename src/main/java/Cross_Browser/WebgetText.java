package Cross_Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebgetText {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		By email = By.id("input-email");
		By password = By.id("input-email");
		By loginHeading = By.xpath("//*[@id=\"content\"]/div/div[2]/div/h2");
		
		eleUtil.doSendkeys(email, "aa@aa.com");
		String text = eleUtil.doGetText(loginHeading);
		System.out.println("Text: "+text);
		
		
		
	}
	
	
}

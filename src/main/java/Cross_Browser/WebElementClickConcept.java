package Cross_Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementClickConcept {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By email = By.id("input-email");
		By password = By.id("input-password");
		By loginButton = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
		doSendkeys(email, "aaa@aa.com");
		doSendkeys(password, "12345");
		doClick(loginButton);

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSendkeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	public static void doClick(By locator) {
		getElement(locator).click();
	}
}

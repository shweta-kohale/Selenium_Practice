package Cross_Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementHandling {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
//		BrowserUtil brUtil = new BrowserUtil();
//		brUtil.launchBrowser("Chrome");
//		brUtil.getURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//1.
//		driver.findElement(By.id("input-firstname")).sendKeys("Shweta");
//		driver.findElement(By.id("input-lastname")).sendKeys("Kohale");
		
		//2.
//		WebElement firstName = driver.findElement(By.id("input-firstname"));
//		WebElement lastName = driver.findElement(By.id("input-lastname"));
//		firstName.sendKeys("Shweta");
//		lastName.sendKeys("Kohale");
		
		//3.
//		By firstName = By.id("input-firstname");
//		By lastName = By.id("input-lastname");
//		WebElement fName = driver.findElement(firstName);
//		WebElement lName = driver.findElement(lastName);
//		fName.sendKeys("Shweta");
//		lName.sendKeys("Kohale");
		
		//4.
//		By firstName = By.id("input-firstname");
//		By lastName = By.id("input-lastname");
//		getElement(firstName).sendKeys("Shweta");
//		getElement(lastName).sendKeys("Kohale");
		
		//5.
//		By firstName = By.id("input-firstname");
//		By lastName = By.id("input-lastname");
//		doSendkeys(firstName, "Shweta");
//		doSendkeys(lastName, "Kohale");
		
		//6.
//		ElementUtil elUtil = new ElementUtil(driver);
//		By firstName = By.id("input-firstname");
//		By lastName = By.id("input-lastname");
//		elUtil.doSendkeys(firstName, "Shweta");
//		elUtil.doSendkeys(lastName, "Kohale");
		
		//7.
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void doSendkeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
}

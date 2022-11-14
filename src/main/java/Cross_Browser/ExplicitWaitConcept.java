package Cross_Browser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitConcept {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By email_id = By.id("input-email");
		By pwd = By.id("input-password");
		By logo = By.xpath("//div[@id='logo']");

		WaitForElementPresense(email_id, 10).sendKeys("Shweta");
		driver.findElement(pwd).sendKeys("shweta");
		
		if(WaitForElementPresense(logo, 10).isDisplayed())
		System.out.println("Logo is present");
	}
	


	public static WebElement WaitForElementPresense(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	

}

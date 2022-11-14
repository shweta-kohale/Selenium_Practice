package Cross_Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomElementHandle {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		//driver.findElement(By.id("Tea")).sendKeys("Ginger Tea");
		//document.querySelector("#snacktime").shadowRoot.querySelector("#tea");
		
		driver.switchTo().frame("pact");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
		WebElement tea = (WebElement)js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
		tea.sendKeys("Ginger Tea");
		
	}

}

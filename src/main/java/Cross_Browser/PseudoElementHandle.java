package Cross_Browser;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PseudoElementHandle {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//window.getComputedStyle(document.querySelector('label[for="input-firstname"]'),'::before').getPropertyValue('content')

	String fn_jsScript = "return window.getComputedStyle(document.querySelector('label[for=\"input-firstname\"]'),'::before').getPropertyValue('content')";
	checkElementIsMandatory(fn_jsScript);
	
	}
	
	public static boolean checkElementIsMandatory(String jsScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String text =  js.executeScript(jsScript).toString();
		
		if(text.contains("*")) { 
			System.out.println("Pass");
			return true;
		}
		else
		{	System.out.println("Fail");
			return false;
		}
	}

}

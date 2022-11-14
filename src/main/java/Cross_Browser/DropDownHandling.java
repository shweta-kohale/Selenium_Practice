package Cross_Browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandling {

public static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		
		WebElement country = driver.findElement(By.id("Form_getForm_Country"));
		
		List<WebElement> dropDownList = driver.findElements(By.xpath("//select/option"));
		System.out.println(dropDownList.size());
			
		for(WebElement e : dropDownList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals("India")){
				e.click();
				break;
			}
		}
		
		
		
	}
	
	
}

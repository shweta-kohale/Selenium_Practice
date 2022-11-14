package Cross_Browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTextUsingSearchBox {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
		Thread.sleep(4000);

		By searchList = By.xpath("//div[@class='wM6W7d']/span");
		searchText(searchList, getElements(searchList), "selenium download");
	}

	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	
	public static void searchText(By locator, List<WebElement> searchList, String inputtext ) {
			
	System.out.println(searchList.size()-1);
	for(WebElement e : searchList) {
		String text = e.getText();
		System.out.println(text);
		if(text.equalsIgnoreCase(inputtext)) {
		e.click();
		break;
		}
}
}
}

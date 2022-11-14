package Cross_Browser;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementMultipleElements {

public static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		
		By links = By.tagName("a");
		By images = By.tagName("img");
		
		System.out.println(getElementTextList(links));
		
		//List<WebElement> linksList = getFindElements(links);
		//List<WebElement> imagesList = getFindElements(images);
		
		
//		System.out.println(doGetElementsCount(links));
//		System.out.println(doGetElementsCount(images));
		
		//System.out.println("Total links available on page: "+ imagesList.size());
		
//		for(int i=0; i<links.size();i++) {
//			String text = links.get(i).getText();
//			if(text.length()!=0) {
//				System.out.println(text);
//			}
//		}
		
//		for (WebElement e : links) {
//			String text = e.getText();
//			if(text.length()!=0) {
//				System.out.println(text);
//			}
//		}
		
	}
	

	
	public static List<WebElement> getFindElements(By locator) {
		return driver.findElements(By.tagName("a"));
	}

	
	public static int doGetElementsCount(By locator) {
		return getFindElements(locator).size();
	}
	
	public static ArrayList<String> getElementTextList(By locator) {
		List<WebElement> eleList = getFindElements(locator);
		ArrayList<String> eleText = new ArrayList<String>();
		
		for(WebElement e : eleList) {
			String text = e.getText();
			if(text.length() != 0) {
				eleText.add(text);
			}
		}
		return eleText;
	}
}

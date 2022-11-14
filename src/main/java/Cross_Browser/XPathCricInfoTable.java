package Cross_Browser;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathCricInfoTable {

public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.espncricinfo.com/series/new-zealand-a-in-india-2022-1329818/india-a-vs-new-zealand-a-2nd-unofficial-test-1329822/full-scorecard");
		
		Thread.sleep(4000);
//		getWktTakerName("Priyank Panchal");
//		getWktTakerName("Abhimanyu Easwaran");
		
		ArrayList<String> scoreList = getScoreList("Rajat Patidar");
		System.out.println("scoreList::::"+scoreList);
		
		ArrayList<String> bowlingDetails = getScoreList("Benjamin Lister");
		System.out.println("bowlingDetails::::"+bowlingDetails);
		
	}
	
	public static ArrayList<String> getScoreList(String name) {
		List<WebElement> scoreList = driver.findElements(By.xpath("//span[text()='"+name+"']//ancestor::td/following-sibling::td"));
		ArrayList<String> scoreListArray = new ArrayList<String>();
		
		for(WebElement e : scoreList) {
			String text = e.getText();
			scoreListArray.add(text);
		}
		return scoreListArray;
	}
	
	public static ArrayList<String> getBallerDetails(String name) {
		List<WebElement> bowlingDetails = driver.findElements(By.xpath("//span[text()='"+name+"']//ancestor::td"));
		ArrayList<String> bowlingDetailsArray = new ArrayList<String>();
		
		for(WebElement e : bowlingDetails) {
			String text = e.getText();
			bowlingDetailsArray.add(text);
		}
		return bowlingDetailsArray;
	}
	
	public static String getBallerName(String name) {
		String blr_xpath = "//span[text()='"+name+"']//ancestor::td/following-sibling::td";
		String ballerName = driver.findElement(By.xpath(blr_xpath)).getText();
		System.out.println(ballerName);
		return ballerName;
	}

	public static String getWktTakerName(String name) {
		String wkt_xpath = "//span[text()='"+name+"']//ancestor::td";
		String wktTakerName = driver.findElement(By.xpath(wkt_xpath)).getText();
		System.out.println(wktTakerName);
		return wktTakerName;
	}
}

package Cross_Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableTraverse {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		int rowCount = getRowCount();
		int columnCount = getColumnCount();
		System.out.println("Rows count"+rowCount);
		System.out.println("Column count"+columnCount);
		
		getColumnText(1);
		getColumnText(2);
		getColumnText(3);
		
	}
	
	public static int getRowCount() {
		int rows = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		return rows-1;
	}

	public static int getColumnCount() {
		int columns = driver.findElements(By.xpath("//table[@id='customers']//th")).size();
		return columns;
	}
	
	public static void getColumnText(int columnnumber) {
		String beforeXpath = "//table[@id='customers']/tbody/tr[";
		String afterXpath = "]/td["+columnnumber+"]";
		System.out.println("==========================================");
		for(int i=2;i<=getRowCount()+1;i++) {
			String actual_Xpath = beforeXpath + i + afterXpath;
			
			System.out.println( driver.findElement(By.xpath(actual_Xpath)).getText());
			
		}
	}
}

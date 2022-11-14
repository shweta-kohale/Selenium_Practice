package Cross_Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CrossBrowser {

	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		BrowserUtil br = new BrowserUtil();
		
		br.launchBrowser("Firefox");
		
		br.getURL("http://www.facebook.com");
		String title = br.getTitle();
		System.out.println("Browser title: "+title);
		
		//launchbrowser
		//geturl
		//gettitle
		//

	}

}

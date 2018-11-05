package jdwebautomatn;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "/Users/amitkumarv/Documents/Automation/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.justdial.com/Shop-Online/Mobile-Phone/nid-11216691?city=Bangalore&where=Prithvi-Theatre-arabic-College");
		
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		int linkCount = alllinks.size();
		System.out.println(linkCount);
		
		/*for(int i=0;i<linkCount;i++) {
			System.out.println(alllinks.get(i).getAttribute("href"));
		}*/
		alllinks.addAll(driver.findElements(By.tagName("img")));
		int totallinks = alllinks.size();
		System.out.println(totallinks);
		List<WebElement> activelinks = new ArrayList<WebElement>();
		
		for(int i=0;i<totallinks;i++) {
			System.out.println(alllinks.get(i).getAttribute("href"));

		if(alllinks.get(i).getAttribute("href")!= null && (! alllinks.get(i).getAttribute("href").contains("javascript") && (! alllinks.get(i).getAttribute("href").equals("")))) {
			activelinks.add(alllinks.get(i));
		}
		}
		System.out.println(activelinks.size());
		
		for(int j=0;j<activelinks.size();j++) {
		
		HttpURLConnection connect = (HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
		String response = connect.getResponseMessage();
		int responsecode = connect.getResponseCode();
		
		connect.disconnect();
		System.out.println(activelinks.get(j).getAttribute("href")+ " : "+response+" -- "+responsecode);
				
		}
	

		
	driver.close();	

	}

}


// HttpURLConnection connect = (HttpURLConnection) new links.get(i).getAttribute("href").openConnection();
// connect.getResponseMessage




//HttpURLConnection con =(HttpURLConnection)new URL(activelinks.get(i).getAttribute("href")).openConnection();
//conn.getResponseCode();



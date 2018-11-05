package jdwebautomatn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Class2 {
	
	WebDriver driver;
@BeforeClass

public void launchbrowser(){
	System.setProperty("webdriver.chrome.driver","/Users/amitkumarv/Documents/Automation/chromedriver.exe");
	 driver=new ChromeDriver();
}

@Test (priority=3)
public void openwebhg() {
	driver.get("https://www.google.com");
	String title="Google";
	System.out.println(driver.getTitle());
	//System.out.println(title);
	Assert.assertEquals("Website has launched", title, driver.getTitle());
	
	
}
	
@AfterClass
public void closebrows() throws InterruptedException {
driver.close();
Thread.sleep(2000);

}
@Test (priority=4)
public void hotelr() {
//	WebHomeElements obj=new WebHomeElements(null);
	//obj.hotelsWeb();
}

}

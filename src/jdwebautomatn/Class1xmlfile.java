package jdwebautomatn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Class1xmlfile {
  
	WebDriver driver;
@BeforeClass

public void launchbrowser(){
	System.setProperty("webdriver.chrome.driver","/Users/amitkumarv/Documents/Automation/chromedriver.exe");
	 driver=new ChromeDriver();
}
@Test (priority=2)
public void openweb() throws InterruptedException {
	driver.get("https://www.justdial.com");
	String title="Justdial - Local Search, Order Food, Travel, Movies, Online Shopping";
	System.out.println(title);
	Assert.assertEquals("Website has launched", title, driver.getTitle());
	
}

	
@AfterClass
public void closebrows() throws InterruptedException {
driver.close();
Thread.sleep(2000);

}
@Test (priority=4)
public void hotelr() {
	WebHomeElements obj=new WebHomeElements();
	//obj.hotelsWeb();
}
}

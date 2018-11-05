package jdwebautomatn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Window;

public class Webhome extends WebHomeElements {
	
/*	public Webhome() {
		super(driver);
		// TODO Auto-generated constructor stub
		 //*[@id=\"htlprcM_9\"]//*[text=\" More Deals \"]
	   WebElement cityfield1=driver.findElement(cityfield);
	WebElement searchfield=driver.findElement(searchbox);
	}*/

 
	int count=0;

	
	public void jdwebcitysearch() throws InterruptedException {
		
		/*driver.get(baseurl);
		driver.findElement(jdlogo).click();
		Thread.sleep(1000);*/
		 WebElement cityfield1=driver.findElement(cityfield);
		 WebElement searchfield=driver.findElement(searchbox);
		  cityfield1=driver.findElement(cityfield);
		  searchfield=driver.findElement(searchbox);
		try{
		System.out.println(cityfield1.getText());
		cityfield1.click();
		Thread.sleep(300);
		String cityatsgt=driver.findElement(By.cssSelector("#Pune")).getTagName();
		driver.findElement(By.cssSelector("#Pune")).click();
		//System.out.println(cityatsgt);
		cityfield1.clear();
		cityfield1.sendKeys("Mumbai");
		Thread.sleep(500);
		cityatsgt=driver.findElement(By.cssSelector("#Mumbai")).getTagName();
		driver.findElement(By.cssSelector("#Mumbai")).click();
     //System.out.println(cityfield.getText());
		if(cityatsgt.equals("li")) {
			System.out.println("city autosuggest: Pass");
		}
		}
		catch (Exception Failedcase){
			System.out.println("City field Autosuggest:  Failed");
		}
	}
	
//=======Category search autosuggest------------------############################
	
	public void categorySearchAutosuggest() throws IOException, InterruptedException {
		Webhome dataobj=new Webhome();
		int i=0;
		String testvalue;
		int count=0;

		WebElement searchfield=driver.findElement(searchbox);
		//try {
		int rowcount= dataobj.findRowCount(xcelFilePath, "categorydata");
		
		for(i=1;i<rowcount;i++){
			testvalue=dataobj.ReadXcalData(xcelFilePath, "categorydata", i);
			searchfield.sendKeys(testvalue);
			Thread.sleep(1000);
			List<WebElement> autosuggestList= driver.findElements(By.tagName("li"));
			for(WebElement find : autosuggestList) {
				if(find.getText().contains(testvalue)) {
					count=1;
					break;
				}
				else {
					count=5;
				}
			}
			searchfield.clear();
			if(count==5) {
				System.out.println("Autosuggest Failed --"+testvalue);
				}
		}
		System.out.println();
		if(count==1) {
			System.out.println("Category Autosuggest: Pass");
		}
		else {
			System.out.println("Category Autosuggest: Failed");
		}
	  }
	/*	catch(Exception Failcase) {
		System.out.println("Category autosuggest not working");
		}
	}*/
// ======COMPANY AUTOSUGGEST========------------------------------
		
		public void companySearchAutosuggest() throws FileNotFoundException {
			Webhome dataobj=new Webhome();
			int i=0;
			String testvalue;
			int count=0;

			WebElement searchfield=driver.findElement(searchbox);
			try {
			int rowcount= dataobj.findRowCount(xcelFilePath, "companydata");
			
			for(i=1;i<rowcount;i++){
				testvalue=dataobj.ReadXcalData(xcelFilePath, "companydata", i);
				searchfield.sendKeys(testvalue);
				Thread.sleep(1000);
				List<WebElement> autosuggestList= driver.findElements(By.tagName("li"));
				for(WebElement find : autosuggestList) {
					if(find.getText().contains(testvalue)) {
						count=1;
						break;
					}
					else {
						count=5;
					}
				}
				searchfield.clear();
				if(count==5) {
					System.out.println("Autosuggest Failed --"+testvalue);
					}
			}
			System.out.println();
			if(count==1) {
				System.out.println("Company Autosuggest: Pass");
			}
			else {
				System.out.println("Company Autosuggest: Failed");
			}
		  }
			catch(Exception Failcase) {
			System.out.println("Company autosuggest not working");
			}
		}
		
	////======PRODUCT AUTOSUGGEST=======----------------------------------
		
		public void productSearchAutosuggest() throws FileNotFoundException {
			Webhome dataobj=new Webhome();
			int i=0;
			String testvalue;
			int count=0;

			WebElement searchfield=driver.findElement(searchbox);
			try {
			int rowcount= dataobj.findRowCount(xcelFilePath, "productdata");
			
			for(i=1;i<rowcount;i++){
				testvalue=dataobj.ReadXcalData(xcelFilePath, "productdata", i);
				searchfield.sendKeys(testvalue);
				Thread.sleep(1000);
				List<WebElement> autosuggestList= driver.findElements(By.tagName("li"));
				for(WebElement find : autosuggestList) {
					if(find.getText().contains(testvalue)) {
						count=1;
						break;
					}
					else {
						count=5;
					}
				}
				searchfield.clear();
				if(count==5) {
					System.out.println("Autosuggest Failed --"+testvalue);
					}
			}
			System.out.println();
			if(count==1) {
				System.out.println("Product Autosuggest: Pass");
			}
			else {
				System.out.println("Product Autosuggest: Failed");
			}
		  }
			catch(Exception Failcase) {
			System.out.println("Product autosuggest not working");
			}
	}
		
		
//=====GROUP COMPANY SEARCH====
		public void groupSearchAutosuggest() throws InterruptedException {
			Webhome dataobj=new Webhome();
			int i=0;
			String testvalue;
			int count=0;

			WebElement searchfield=driver.findElement(searchbox);
			try {
			int rowcount= dataobj.findRowCount(xcelFilePath, "groupdata");
			
			for(i=1;i<rowcount;i++){
				testvalue=dataobj.ReadXcalData(xcelFilePath, "groupdata", i);
				searchfield.sendKeys(testvalue);
				Thread.sleep(1000);
				List<WebElement> autosuggestList= driver.findElements(By.tagName("li"));
				for(WebElement find : autosuggestList) {
					if(find.getText().contains(testvalue)) {
						count=1;
						break;
					}
					else {
						count=5;
					}
				}
				searchfield.clear();
				if(count==5) {
					System.out.println("Autosuggest Failed --"+testvalue);
					}
			}
			System.out.println();
			if(count==1) {
				System.out.println("Grouping-Company Autosuggest: Pass");
			}
			else {
				System.out.println("Grouping-Company Autosuggest: Failed");
			}
		  }
			catch(Exception Failcase) {
			System.out.println("Grouping-Company autosuggest not working");
			}
		}
//========MOVIE AUTOSUGGEST============
				
		public void movieSearchAutosuggest() throws InterruptedException {
		try {
				driver.findElement(moviehotkey).click();
				driver.findElement(moviesdropdown).click();
				String moviename=driver.findElement(moviexpath).getText();
				driver.navigate().to("http://www.justdial.com");
				//System.out.println(moviename);
				 WebElement cityfield1=driver.findElement(cityfield);
				 WebElement searchfield=driver.findElement(searchbox);				//searchfield.clear();
				searchfield.sendKeys(moviename+" movie");
				Thread.sleep(1000);
				String moviesautosuggest=driver.findElement(movieautosuggest).getText();
				driver.findElement(movieautosuggest).click();
				//System.out.println(moviesautosuggest);
				if(moviesautosuggest.equals("GOLD (Hindi Movie)")) {
					System.out.println("Movie autosuggest: Pass");
				}
				}
				catch(Exception Failedcase) {
					System.out.println("Movie autosuggest: Failed");
				}
				Thread.sleep(1000);		
		driver.close();
		}
		

//----BUS VERTICAL---------------------------------------------------------------------------------------		
	
	public void busvertical() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","/Users/amitkumarv/Documents/Automation/geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.get("https://www.justdial.com/Travel/Bus-Booking/?action=passengers&searchId=8de01a74ccc69f4bc2c88f83ed3c428b");
		Thread.sleep(1000);
		WebElement salutation=driver.findElement(By.id("genM_0"));
		Select salute=new Select(salutation);
		salute.selectByVisibleText("Mr");
		WebElement proceed=driver.findElement(By.id("bProceed"));
		boolean x=proceed.isDisplayed();
		System.out.println(x);
		x=proceed.isEnabled();
		System.out.println(x);
		driver.quit();
		Thread.sleep(1000);
	}
	
	//public static void main(String[] args) throws InterruptedException {
	

	public static void main(String []args) throws InterruptedException {
		WebHomeElements open=new WebHomeElements();
		//open.launchwebsite();
		Webhome openweb=new Webhome();
		//openweb.openWebhome();
		HotelsWeb hotelobj=new HotelsWeb();
		//hotelobj.hotelsWebAuto();
		//openweb.categorysearch();
		//TODO Auto-generated method stub
		//openweb.busvertical();
	
		//driver.get("https://www.justdial.com");
	

	}

}

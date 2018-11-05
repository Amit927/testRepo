package jdwebautomatn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.swing.plaf.synth.SynthSpinnerUI;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFShapeFactory;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.examples.ToCSV;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ExcelHandlingLearn {

	public static String filePath= "C:\\Users\\amitkumarv\\Documents\\DOCUMENTS\\AMIT 1\\Automation 1\\TESTDATA\\testdata.xls";
	public static String outfilePath="C:\\Users\\amitkumarv\\Documents\\DOCUMENTS\\AMIT 1\\A53 August 2018\\output.xls";	
	static WebDriver driver;
	
	/*
	public void ReadXcalData1(String  filePath,String sheetName) throws IOException {
		
		
		File file=new File(filePath);
		FileInputStream fis=new FileInputStream(file);
		HSSFWorkbook workbk=new HSSFWorkbook(fis);
		HSSFSheet sheets= workbk.getSheetAt(1);
		int rowcount= sheets.getLastRowNum();
		for(int i=0;i<=rowcount;i++) {
		String cityinput= sheets.getRow(i).getCell(0).getStringCellValue();
		System.out.println(cityinput);
		
		}
	}
	
public void writeXcalData() throws IOException {
		
	   File file=new File(filePath);
		FileInputStream fis=new FileInputStream(file);
		HSSFWorkbook workbk=new HSSFWorkbook(fis);
		HSSFSheet sheets= workbk.getSheet("citydata");
		HSSFSheet sheetnew= workbk.createSheet();
		//sheetnew.createRow(1);
		String cellText = null;
		int rowcount= sheets.getLastRowNum();
		
		File fileout=new File(outfilePath);
		fileout.createNewFile();
		for(int i=0;i<=rowcount;i++) {
			cellText=sheets.getRow(i).getCell(0).getStringCellValue();
			sheetnew.createRow(i).createCell(3).setCellValue("Pass");
			sheetnew.getRow(i).createCell(1).setCellValue(cellText);
			sheetnew.getRow(i).createCell(4).setCellValue("abcd");
			FileOutputStream fout= new FileOutputStream(fileout);
			workbk.write(fout);
		}
		System.out.println("Done");
	}
	
	
	public void takeScreenshot() throws InterruptedException, IOException {
		
	    String screensPath= "C:\\Users\\amitkumarv\\Documents\\DOCUMENTS\\AMIT 1\\Automation 1\\Reports\\Screenshots\\";
	    
	 // Formating date and time=========
	     DateFormat dateformat = new SimpleDateFormat("dd_MMyyyy_HHmmss");
	     Date date = new Date();
	     String datetime = dateformat.format(date);
	     
	     screensPath = screensPath+datetime+".jpg";
	     
	    File screenfile = new File(screensPath);
	   
	//Take Screenshot interface initialization
	    
	TakesScreenshot scrshot = ((TakesScreenshot)driver);
	File scrsource = scrshot.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrsource, screenfile);
		
	}*/
	
	
	
//=======Select Date from Calendar Using Java Script====================================###################
	
	public static void selectDatefromCalendar(WebDriver driver, WebElement element, String datevalue) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+datevalue+"');", element);
	}
	
	
//========================================================================================================	
	
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			ExcelHandlingLearn obj=new ExcelHandlingLearn();
			Dimension windSize = new Dimension(414, 736);
			
			System.setProperty("webdriver.chrome.driver", "/Users/amitkumarv/Documents/Automation/chromedriver.exe");
		    driver= new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.get("https://www.justdial.com/Shop-Online?city=Bangalore");

			DateFormat dateformat = new SimpleDateFormat("dd_MMyyyy_HHmmss");
			Date date = new Date();
			String currentDate = dateformat.format(date);
			System.out.println(currentDate);
			
			//obj.takeScreenshot();
			//driver.manage().window().setSize(windSize);
			//driver.manage().window().setPosition(left);
			//Thread.sleep(1000);
			//obj.takeScreenshot();
			//driver.findElement(By.xpath("//span[@className=\"hptext\"]//span[text()=\"jobs\"]")).click();
			Actions hover = new Actions(driver);
			//hover.clickAndHold().moveToElement(driver.findElement(By.linkText("Nokia"))).release().build().perform();
			Thread.sleep(2000);
			hover.moveToElement(driver.findElement(By.xpath("//a[contains(@class,'navlink ')]"))).build().perform();
					//xpath("/html/body/nav/div/ul/li[1]/section/aside[1]/a[3]")));
			Thread.sleep(2000);
			driver.findElement(By.partialLinkText("Samsung")).click();
			/*
			driver.navigate().back();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			
			hover.moveToElement(driver.findElement(By.partialLinkText("Automobile"))).build().perform();
			driver.findElement(By.linkText("Exide")).click();
			Thread.sleep(1000);
			
			driver.navigate().back();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			hover.moveToElement(driver.findElement(By.linkText("Computers & Accessories"))).build().perform();
			
			driver.findElement(By.linkText("Lenovo")).click();
		    Thread.sleep(2000);*/
			
		   /* driver.navigate().to("https://www.justdial.com/Mumbai/Six-Degrees-The-Leela-Near-Sahar-International-Airport-Andheri-East/022P8005914_BZDET?xid=TXVtYmFpIEZpbmUgV2luZQ==");
		    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("//i[@class='ic_shareic']")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id=\"swf\"]/section/section/ul/li[1]/a")).click();
		    Thread.sleep(2000);
		    
		    Set<String> handles = driver.getWindowHandles();
		    Iterator<String> iter = handles.iterator();
		    
		    String basewindow = iter.next();
		    System.out.println(basewindow);
		    
		    String sharewindow = iter.next();
		    System.out.println(sharewindow);
		    
		driver.switchTo().window(sharewindow);
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:/Users/amitkumarv/Documents/DOCUMENTS/AMIT 1/Automation 1/JustdialwebAutomation/src/jdwebautomatn/constants.properties");
		    prop.load(fis);

		    driver.findElement(By.xpath("//input[contains(@class,'inputtext _55r1 inputtext inputtext')]")).sendKeys(prop.getProperty("username"));
		    driver.findElement(By.xpath("//input[contains(@name,'pass')]")).sendKeys(prop.getProperty("password"));
		    driver.findElement(By.id("u_0_0")).click();
		    driver.close();
		    
		    driver.switchTo().window(basewindow);
		    driver.findElement(By.id("h_flist")).click();
		    */
		    
			driver.navigate().to("https://www.justdial.com/Bangalore/Hotels-in-Prithvi-Theatre-Arabic-College");
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			List<WebElement> metatags = driver.findElements(By.xpath("//a[starts-with(@id,'htlprc')]"));
			int sizem = metatags.size();
			System.out.println(sizem);
			for(int i=0;i<sizem;i++) {
				String tags = metatags.get(i).getText();
				System.out.println(tags);
				if(tags.contains("Makemytrip.com")) {
					String price = driver.findElement(By.xpath("//a[starts-with(@id,'htlprc')]//span[@class='ofrpric']")).getText();
					String hotelname = driver.findElement(By.xpath("//span[@class='ofrpric']//parent::a[starts-with(@id,'htlprcaL_"+i+"')]//parent::div[starts-with(@id,'htlprcL_')]//parent::div[starts-with(@class,'viewdealSecnw')]//preceding-sibling::div[starts-with(@class,'detailSecnw ')]//h2[@class='store-name']")).getText();
					System.out.println("Hotel name is "+hotelname);
					System.out.println("booking.com price equals to: Rs "+price); 

					break;
				}
				
				
				}
			Thread.sleep(1500);
			WebElement searchbox = driver.findElement(By.xpath("//input[contains(@id,'srchbx')]"));
			searchbox.clear();
			searchbox.sendKeys("raja");
			Thread.sleep(2000);
			List<WebElement> autosuggest = driver.findElements(By.xpath("//ul[@id='auto']//li/a/descendant::span[@class='lng_autowht tcon']"));
			System.out.println("Total autosuggest= "+autosuggest.size());
			for(int i=0;i<=autosuggest.size();i++) {
				String searchitems = autosuggest.get(i).getText();	
				System.out.println(searchitems);
				
				if(searchitems.contains("Rajarajeshwari Dental ")) {
					System.out.println(searchitems);
					break;
				}
			}
			Thread.sleep(2000);

			driver.navigate().to("https://www.justdial.com/travel/hotel-booking");
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			
			String dateselect = "Fri,21-Sep-2018";
			/*String datearray[] =dateselect.split(",");
			String datearray1[] =dateselect.split("-");
			String day = datearray[0];
			String date1= datearray1[0];
			String mon= datearray1[1];
			String yr= datearray1[2];*/
			
			WebElement calendar = driver.findElement(By.xpath("//div[@class='col-sm-12 padding0 cal']//input[@id='checkInDt']"));
			//calendar.click();
			Thread.sleep(1000);
			obj.selectDatefromCalendar(driver, calendar, dateselect);
			System.out.println(calendar.getText());
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//div/descendant::a[@title='Next']")).click();
			
			/*String rowbef="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[";
			String rowafter= "]/td[";
			int count= 4;
			for(int rows=1;rows<=5;rows++) {
				for(int column=1;column<=7;column++) {
					String datexpath = rowbef+rows+rowafter+column+"]/a";
					String  datetoselect =null;
					try {
					  datetoselect = driver.findElement(By.xpath(datexpath)).getText();
					if(datetoselect.equals("14")) {
						driver.findElement(By.xpath(datexpath)).click();
						System.out.println(datetoselect);
						System.out.println(driver.findElement(By.xpath("//div[@class='col-sm-12 padding0 cal']//input[@id='checkInDt']")).getText());
						count=6;
						break;
					}
					}catch(Exception e) {
						System.out.println("Date not found");
					}
				}
				if(count==6) {
					break;
				}
			}*/
			
			
			
			
			Thread.sleep(2000);
			
		  
			
			
			
// //span[@class='ofrpric']//parent::a[starts-with(@id,'htlprcaL')]//parent::div[starts-with(@id,'htlprcL_')]//parent::div[starts-with(@class,'viewdealSecnw')]//preceding-sibling::div[starts-with(@class,'detailSecnw ')]//h2/span/a[contains(@title,'Havilla Lake')]			

			
// // //span[@class='ofrpric']//parent::a[starts-with(@id,'htlprcaL')]//parent::div[starts-with(@id,'htlprcL_')]//parent::div[starts-with(@class,'viewdealSecnw')]//preceding-sibling::div[starts-with(@class,'detailSecnw ')]//h2[@class='store-name']		
			
		    
		    //obj.writeXcalData();
			driver.close();

	}

}

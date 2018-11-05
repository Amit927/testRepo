package jdwebautomatn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class WebHomeElements {
	
	 static WebDriver driver;
	 
	//Driver path;
	public static String geckodriverpath=" /Users/amitkumarv/Documents/Automation/geckodriver.exe";
	public static String chromedriverpath= "/Users/amitkumarv/Documents/Automation/chromedriver.exe";
	public static String datapath= "C:\\Users\\amitkumarv\\Documents\\DOCUMENTS\\AMIT 1\\Automation 1\\TESTDATA\\";
	public static String xcelFilePath= "C:\\Users\\amitkumarv\\Documents\\DOCUMENTS\\AMIT 1\\Automation 1\\TESTDATA\\testdata.xls";
	public static String outfilePath= "C:\\Users\\amitkumarv\\Documents\\DOCUMENTS\\AMIT 1\\Automation 1\\Reports\\output.xls";	
	public static String fileoutLocation = "C:\\Users\\amitkumarv\\Documents\\DOCUMENTS\\AMIT 1\\Automation 1\\Reports\\";
	public static String screenshot = "C:\\Users\\amitkumarv\\Documents\\DOCUMENTS\\AMIT 1\\Automation 1\\Reports\\Screenshots\\screen";

	
	public static String statusP = "PASS";
	public static String statusF = "FAIL";
	
	
	
	public static String baseurl="https://www.justdial.com";
	
	public static By jdlogo= By.xpath("//*[@id=\"setbackfix\"]/header/section/div/div[1]/span/a/img");
	public static By cityfield= By.xpath("//*[@id=\"city\"]");
	public static By searchbox= By.xpath("//*[@id=\"srchbx\"]");
	
	
	
	public static By moviehotkey= By.xpath("//*[@id=\"lng_main_0_2\"]");
	public static By moviesdropdown= By.xpath("//*[@id=\"movie\"]");
	public static By moviexpath= By.xpath("//*[@id=\"listMovie\"]/ul[1]/li[2]");
	public static By movieautosuggest= By.xpath("//*[@id=\"1072598631~1~0~Mumbai~~GOLD%20Hindi%20Movie~~~~0~0~0~undefined~undefined~12058031~~~~GOLD%20(Hindi%20Movie)~~1\"]/span");
	public static By prodatsgt= By.xpath("//*[@id=\"340603~1~0~Mumbai~~iPhone%208%20Plus~~~~1~5~1810914~undefined~undefined~11216741~~~~iPhone%208%20Plus~~0\"]");
	public static By prodatsgt1= By.xpath("//*[@id=\"340603~1~0~Mumbai~~iPhone%208%20256%20GB%2C%20Gold~~~~1~1~31027536~undefined~undefined~11216741~~~~iPhone%208%20(256%20GB%2C%20Gold)~~0\"]");
	public static By prodatsgt2= By.xpath("//*[@id=\"1071790708~1~0~Mumbai~~One%20Plus%205T%20RAM%208%20GB%2C%20128%20GB%2C%20Midnight%20Black~~~~1~1~51691090~undefined~undefined~11281356~~~~One%20Plus%205T%20(RAM%208%20GB%2C%20128%20GB%2C%20Midnight%20Black)~~0\"]");

//=====HOTEL WEB AUTOMATION================
	public static By hotelhotkey=By.xpath("//*[@id=\"ht_lk_sub_2_21\"]");
	public static By travelhotkey= By.xpath("//*[@id=\"ht_lk_sub_Img_21\"]/img");
	public static By hotelmenu= By.xpath("//*[@id=\"hotkeys_text_11\"]");
	public static By bannernextarrow= By.xpath("//*[@id=\"carousel-example-generic\"]/div[3]/a[2]/span");
	public static By hotelbanner= By.xpath("//*[@id=\"BannerLnk_6\"]/span");
	public static By hotelfilter= By.xpath("//*[@id=\"mnintrnlbnr\"]/ul/li[6]/a");
	public static By destinationfield= By.xpath("//*[@id=\"destinationName\"]");
	public static By hotelautosuggests= By.tagName("li");
	public static By calendarcheckin= By.xpath("//*[@id=\"checkInDt\"]");
	public static By calendarcheckout= By.xpath("//*[@id=\"checkOutDt\"]");
	public static By numbOfNights= By.xpath("//*[@id=\"dNightCountSelector_Htl\"]/span[2]");
	public static By adultcoount= By.xpath("//*[@id=\"dAdultsCountSelector_Htl1\"]/span[2]");
	public static By hotelsearchbutton= By.xpath("//*[@id=\"hsearch\"]");
	public static By hotelindelhi= By.xpath("//*[@id=\"ui-id-52\"]"); //*[@id="ui-id-41"]
	public static By hoteltajlandend= By.xpath("//*[@id=\"ui-id-174\"]");
	public static By tajlandsenddetails= By.xpath("//*[@id=\"setbackfix\"]/div[1]/div/div[1]/div[2]/div/div/h1/span/span");
	public static By nishitadetails= By.xpath("//*[@id=\"setbackfix\"]/div[1]/div/div[1]/div[2]/div/div/h1/span/span[1]");
	public static By resultlisting= By.xpath("//*[@id=\"setbackfix\"]//*[text()=\"Hotels in Bangalore\"]");
	public static By detailsgoibibotag= By.xpath("//*[@id=\"htlLst\"]//*[text()=\"goibibo.com\"]");
	public static By detailsmmttag= By.xpath("//*[@id=\"htlLst\"]//*[text()=\"makemytrip.com\"]");
	public static By detailscleartriptag= By.xpath("//*[@id=\"htlLst\"]//*[text()=\"cleartrip.com\"]");
	public static By detailsbookingtag= By.xpath("//*[@id=\"htlLst\"]//*[text()=\"booking.com\"]");
	public static By detailsmoredeals= By.xpath("//*[@id=\"htlLst\"]//*[text()=\" More Deals \"]"); 
	public static By detailsallprices= By.xpath("//*[@id=\"allDeals\"]/section/section/ul");
	public static By goibibopageelementNishita= By.xpath("//*[@id=\"gic_detail\"]/div[1]/div[3]/div/span");
	public static By mmtpageelementNishita= By.xpath("//*[@id=\"details-info-hotelname\"]");
	public static By bookingpageelementNishita= By.xpath("//*[@id=\"hotelDetailsHeader\"]/div/div/div[2]/div/div[1]/h1");
	public static By cleartrippageelementNishita= By.xpath("//*[@id=\"hotellist_inner\"]/div[1]/div[2]/div[1]/div[1]/h3/a/span[1]");
	public static By resultMoreDeals= By.xpath("//*[@id=\"htlprcH_0\"]//*[text()=\" More Deals \"]");
	public static By resultpageTag1= By.id("htlprc_1");
	public static By resultpageTag2= By.id("htlprcaL_1");
	public static By resultAllPrice= By.xpath("//*[@id=\"allDeals\"]/section/section/ul"); //*[@id="allDeals"]/section/section/ul/li[1]
	public static By resultAllPricelist1= By.xpath("//*[@id=\"allDeals\"]/section/section/ul/li[1]");


	
	
//  =====Create Construtor============================================
	
/*	public WebHomeElements(WebDriver driver) {
		this.driver=driver;
	}
*/	
//	============== Customized methods======================================================================================
	
//--------LAUNCH WEBSITE----------------------------------------------------------
	public void launchwebsite() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver",chromedriverpath);
	driver=new ChromeDriver();
	driver.manage().window().maximize();
    driver.get(baseurl);
	//driver.navigate().to("https://www.justdial.com/travel/hotel-booking");
	driver.findElement(jdlogo).click();
	Thread.sleep(1000);
	
	}
	
//====== Read XCel Data==========================================================================================================	
	
public String ReadXcalData(String  xcelFilePath,String sheetName, int rowindex) throws IOException {
		
		File file=new File(xcelFilePath);
		FileInputStream fis=new FileInputStream(file);
		HSSFWorkbook workbk=new HSSFWorkbook(fis);
		HSSFSheet sheets= workbk.getSheet(sheetName);
		//int rowcount= sheets.getLastRowNum();
		String cellText= sheets.getRow(rowindex).getCell(0).getStringCellValue();
		return cellText;
	}

//======Find row count================

public int findRowCount(String xcelFilePath,String sheetName) throws IOException {
	File file=new File(xcelFilePath);
	FileInputStream fis=new FileInputStream(file);
	HSSFWorkbook workbk=new HSSFWorkbook(fis);
	HSSFSheet sheets= workbk.getSheet(sheetName);
	int rowcount= sheets.getLastRowNum();
	return rowcount;
    }

//=====Write output report===========================

public void writeStatus(String xceloutpath, String sheetName,String status, int statusColumn, int rowindex) throws IOException {
	rowindex = rowindex-1;
	File fileOut=new File(xceloutpath);
	FileInputStream fis=new FileInputStream(fileOut);
	HSSFWorkbook wrkbk= new HSSFWorkbook(fis);
	HSSFSheet sheetout = wrkbk.getSheet(sheetName);
	sheetout.getRow(rowindex).createCell(statusColumn).setCellValue(status);
	FileOutputStream fout = new FileOutputStream(fileOut);
	wrkbk.write(fout);
}


//========Refresh Output sheet=====================================================

public void clearPreviousOutputStatus() throws IOException {
	File file = new File(outfilePath);
	FileInputStream fis = new FileInputStream(file);
	HSSFWorkbook wb = new HSSFWorkbook(fis);
	HSSFSheet sheet = wb.getSheet("Hotel_cases");
	int count = sheet.getLastRowNum();
	for(int i=1;i<=count;i++) {
	sheet.getRow(i).createCell(2).setCellValue("");
	FileOutputStream fout = new FileOutputStream(file);
	wb.write(fout);
	}
}

//========Refresh Output sheet=====================================================

public void createOutputFile() throws IOException {

   DateFormat dateformat = new SimpleDateFormat("ddMMyyyy_HHmmss");
   Date date = new Date();
   String datetime = dateformat.format(date);
   
   File fileold = new File(outfilePath);
   String newFileout = fileoutLocation+datetime+"output.xls";
   File filenew = new File(newFileout);
   FileUtils.copyFile(fileold, filenew);
 
}

//=====Take ScreenShot-===============================================================

public void takeScreenshot() throws IOException {
	
	DateFormat format = new SimpleDateFormat("dd_MMyyyy_HH_mmss");
	Date date = new Date();
	String datetime = format.format(date);
	
	File scroutfile = new File(screenshot+datetime+".jpg");
	TakesScreenshot scrshot = ((TakesScreenshot)driver);
	File scrsource = scrshot.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrsource, scroutfile);
	
}

//======Tabs close=======================================================================
	public void closeTabs() {
	try {
		ArrayList<String> opentabs=new ArrayList<String>(driver.getWindowHandles());
		int numbofTabs=opentabs.size();
		for(int i=0;i<=numbofTabs;i++) {
		driver.switchTo().window(opentabs.get(i));
		driver.close();
		}
		}
		catch(Exception e) {
		}
	}
	
	
	
	
}

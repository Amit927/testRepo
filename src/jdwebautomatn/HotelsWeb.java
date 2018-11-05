package jdwebautomatn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HotelsWeb extends WebHomeElements {
	
	
	//WebDriver driver;
	

	/*public HotelsWeb(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}*/

	public static HotelsWeb obj = new HotelsWeb();

	
//=======--Hotel destination search case-------------------------------------------------------

	public void destinaionsearch(String word) throws InterruptedException {
		
			driver.findElement(destinationfield).sendKeys(word);
			Thread.sleep(1500);
			List<WebElement> autosuggests=driver.findElements(hotelautosuggests);
			for(WebElement selection:autosuggests) {
				if(selection.getText().contains(word) || selection.getText().contains("Hotels in "+word)) {
					selection.click();
					break;
				}
			}				
		}
			
//=====Result page meta tag find case---------------###################### 
	
	public String ResultTag1(String metaTagName) throws InterruptedException, IOException {
		
	String metaTagStatus="";	
	String resultTag1_id= "htlprca_";
	String resultTag2_id= "htlprcaL_";

	int i=0, c=0;
	String title="";
	//try {
	while(i<10) {
		resultTag1_id="htlprca_"+i;
		resultTag2_id="htlprcaL_"+i;
		WebElement resultTag2= driver.findElement(By.id(resultTag2_id));
		WebElement resultTag1= driver.findElement(By.id(resultTag1_id));
	if(resultTag1.isDisplayed() || resultTag2.isDisplayed()) {
		//System.out.println(resultTag1.getText());
		if(resultTag1.getText().contains(metaTagName) ){
			resultTag1.click() ;
			Thread.sleep(1500);
			title=driver.getTitle();
			System.out.println(title);
			System.out.println("Result page: "+metaTagName+" redirection: "+statusP);
			metaTagStatus = "PASS";
			break;
		}
		else if(resultTag2.getText().contains(metaTagName) ){
			resultTag2.click() ;
			Thread.sleep(1500);
			title=driver.getTitle();
			System.out.println(title);
			System.out.println("Result page: "+metaTagName+" redirection: "+statusP);
			metaTagStatus = "PASS";
			break;
		}
		else {
			i++;
			c=99;
		}
	}
	}
	if(c==99) {
		System.out.println("Result page: "+metaTagName+" Metaprice not found: Failed");
		metaTagStatus = "FAIL";
	}
	/*catch(Exception Failcase) {
		System.out.println("Result page: "+metaTagName+" redirection: Fail");
	}*/
	return metaTagStatus;
	}
	
	
//----#---- More Deals and all price popup cases=====================############	
	public String ResultTagMoreDeals() throws InterruptedException {
		
	String metaTagStatus="";	
	String resultTagid= "htlprcM_";
	int i=0, c=0;
	try {
	while(i<10) {
		resultTagid="htlprcM_"+i;
		String resultTagmoreXpath="//*[@id=\""+resultTagid+"\"]//*[text()=\" More Deals \"]";
		//System.out.println(resultTagmoreXpath);
		WebElement resultmoredeals= driver.findElement(By.xpath(resultTagmoreXpath));
	if(resultmoredeals.isDisplayed()) {
		System.out.println("Checking more deals");
		resultmoredeals.click();
		Thread.sleep(4000);
		if(driver.findElement(resultAllPrice).isDisplayed()) {
			System.out.println("Result page: All price popup list is seen: Pass");
			metaTagStatus = "PASS";
			driver.findElement(resultAllPricelist1).click();
			Thread.sleep(1500);
			if(true) {
				String Ttl= driver.getTitle();
				System.out.println(Ttl);
				System.out.println("Result page:All price popup- Meta price redirection: Pass");
				metaTagStatus = "PASS";
				break;
			}
		}
		else {
			c=99;
		}
	}
	else {
		i++;
	}
	}
	if(c==99) {
		System.out.println("Result page: All Price popup is not seen: Failed");
		metaTagStatus = "FAIL";
	}
	}
	catch(Exception Failcase) {
		System.out.println("Result page: More Deals not seen: Failed");
		metaTagStatus = "FAIL";
	}
	return metaTagStatus;
	}
	
	
//======HOTELS  Redirections cases=================================###################

	public void hotelWebRedirections() throws InterruptedException, IOException {
	
	
/*		driver.get(baseurl);
		driver.findElement(jdlogo).click();
		Thread.sleep(1000);*/
	//	HotelsWeb obj = new HotelsWeb();
		
		try {
		driver.findElement(travelhotkey).click();
		Thread.sleep(1000);
			driver.findElement(hotelfilter).click();
			Thread.sleep(1000);
			Assert.assertEquals(true,driver.findElement(destinationfield).isDisplayed());
		System.out.println("Travel hotkey redirection:"+statusP);
		obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, 2);
		}
		catch(Exception Failcase) {
			System.out.println("Travel hoekey redirection:"+statusF);
			obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, 2);

		}
		
		try {
			driver.navigate().back();
			Thread.sleep(300);
			driver.navigate().back();
			Thread.sleep(1000);
		driver.findElement(hotelmenu).click();
			Assert.assertEquals(true,driver.findElement(destinationfield).isDisplayed());
			System.out.println("Hotel menu link redirection:"+statusP);
			obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, 3);

		}
		catch(Exception Failcase2) {
			System.out.println("Contextual menu link redirection:"+statusF);
			obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, 3);

		}
		
		try {
			driver.navigate().back();
			Thread.sleep(1000);
			for(int i=0;i<5;i++) {
				driver.findElement(bannernextarrow).click();
				Thread.sleep(1000);
			}
			
			driver.findElement(hotelbanner).click();
			Thread.sleep(800);
			Assert.assertEquals(true,driver.findElement(destinationfield).isDisplayed());
			System.out.println("Hotel banner redirection:"+ statusP);
			obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, 4);

		}
		catch(Exception Failcase2) {
			System.out.println("Hotel banner redirection: "+statusF);
			obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, 4);

		}
		
		try {
			driver.navigate().back();
			Thread.sleep(1000);
		    driver.findElement(hotelhotkey).click();
			Thread.sleep(1000);
			Assert.assertEquals(true,driver.findElement(destinationfield).isDisplayed());
			System.out.println("Hotel hotkey link redirection: "+statusP);
			obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, 5);

		}
		catch(Exception Failcase1) {
			System.out.println("Hotel hotkey redirection: Fail");
			obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, 5);

		}
		Thread.sleep(800);
	}
		
//====Hotel Company/Hotel Search Flow--------------#####################################################
		
	public void hotelCompanySearchflow() throws InterruptedException, IOException {
		Thread.sleep(1000);
		 driver.findElement(hotelhotkey).click();
			Thread.sleep(1000);
		WebElement destination=driver.findElement(destinationfield);
		
		HotelsWeb searchcase=new HotelsWeb();
		try {
		searchcase.destinaionsearch("Taj Lands End Hotel");
	    System.out.println("Hotel destination company autosuggest: Pass");
		obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, 6);

		}
		catch(Exception Failcase) {
			System.out.println("Destination Hotel name autosuggest Failed");
			obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, 6);
		}

//----###----------Redirection to details page case----------------##########
		
	try {
		destination.clear();
		searchcase.destinaionsearch("Nishita Residency");
		System.out.println("Searching details forr Nishita Residency");
		driver.findElement(hotelsearchbutton).click();
    		if(true) {
	  	   driver.findElement(nishitadetails).isDisplayed();
	  	   obj.takeScreenshot();
		   System.out.println("Search redirection to details page: Pass");
			obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, 8);
			}
		
 //----###----------Checking meta price tags and Redirections----------------##########
   				
		Thread.sleep(2000);
		String Nishitadetails=driver.getWindowHandle();  // getting tab handle foe hotel details page-----#########
		
		try{
			Assert.assertEquals(true,driver.findElement(detailsgoibibotag).isDisplayed());
			System.out.println("Details page: Goibibo price is displayed: Pass");
			obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, 9);
			driver.findElement(detailsgoibibotag).click();
			Thread.sleep(1000);
			//if(driver.findElement(goibibopageelementNishita)).getText().contains("Nishita")) {
			if(driver.getTitle().contains("Nishita")) {	
			System.out.println("Goibibo page redirection: Pass");
			obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, 10);
			}
			else{
				System.out.println("Goibibo page redirection: Fail");
				obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, 10);
			}
			}
			catch(Exception Failcase) {
			System.out.println("Details page:Goibibo price is not seen: Fail");
			obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, 9);
		}
		
		driver.switchTo().window(Nishitadetails);	
		Thread.sleep(1000);
		try{
			if(driver.findElement(detailsmmttag).isDisplayed()) {
			System.out.println("Details page: MMT price is displayed: Pass");
			obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, 11);
			driver.findElement(detailsmmttag).click();
			Thread.sleep(1000);
			//if(driver.findElement(mmtpageelementNishita)).getText().contains("Nishita")) {
			if(driver.getTitle().contains("Nishita")) {		
			System.out.println("MMT page redirection: Pass");
			obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, 12);

			}
		    else {
				System.out.println("MMT page redirection: Fail");
				obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, 12);
			}
			}
		}
			catch(Exception Failcase) {
			System.out.println("Details page: MMT price is not seen: Fail");
			obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, 11);
		}
		
		driver.switchTo().window(Nishitadetails);
		Thread.sleep(1000);
		try{
			if(driver.findElement(detailsbookingtag).isDisplayed()) {
			System.out.println("Details page: Booking.com price is displayed: Pass");
			obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, 13);
			driver.findElement(detailsbookingtag).click();
			Thread.sleep(1500);
			//if(driver.findElement(bookingpageelementNishita)).isDisplayed()) {
			if(driver.getTitle().contains("Nishita")) {		
			System.out.println("Booking.com page redirection: Pass");
			obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, 14);
			}
			else {
				System.out.println("Booking.com page redirection: Fail");
				obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, 14);
			}
			}
		}
			catch(Exception Failcase) {
			System.out.println("Details page: Booking.com price is not seen: Fail");
			obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, 13);
		}
		
		driver.switchTo().window(Nishitadetails);
		Thread.sleep(1000);
		try{
			if(driver.findElement(detailscleartriptag).isDisplayed()) {
			System.out.println("Details page: Cleartrip price is displayed: Pass");
			obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, 15);
			driver.findElement(detailscleartriptag).click();
			Thread.sleep(1500);
			//if(driver.findElement(cleartrippageelementNishita)).getText().contains("Nishita")) {
			if(driver.getTitle().contains("Nishita")) {		
			System.out.println("Cleartrip page redirection: Pass");
			obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, 16);
			}
			else {
			System.out.println("Cleartrip page redirection: Fail");
			obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, 16);
			}
			}
		}
			catch(Exception Failcase) {
			System.out.println("Details page: Cleartrip price is not seen: Fail");
			obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, 15);
		}
		
		driver.switchTo().window(Nishitadetails);
		Thread.sleep(1000);
		try{
			if(driver.findElement(detailsmoredeals).isDisplayed()) {
			System.out.println("Details page: More link is displayed: Pass");
			obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, 17);

			driver.findElement(detailsmoredeals).click();
			Thread.sleep(5000);
			
			if(driver.findElement(detailsallprices).isDisplayed()) {
				obj.takeScreenshot();
				System.out.println("Details page: All prices popup is seen: Pass");
				obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, 18);
				}
			else {
				System.out.println("Details page: All prices popup is not seen: Fail");
				obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, 18);
			}
		}
	   }
		catch(Exception Failcase) {
			System.out.println("Details page: more deals link is not seen: Failed");
			obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, 17);
		}
		
		
		}
		catch(Exception Failcase1) {
			System.out.println("Search redirection to details page: Fail");
			obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, 8);
		}
		driver.navigate().back();
	}
		
//====Hotel City Search Flow--------------#####################################################
	
	public void hotelCitySearchflow() throws InterruptedException, IOException{
		Thread.sleep(1000);
		 driver.findElement(hotelhotkey).click();
			Thread.sleep(1000);
		HotelsWeb cityflowobj=new HotelsWeb();
		WebElement destination=driver.findElement(destinationfield);
		
		String cityname;
		int i=0, k=21;
		int rowcount= cityflowobj.findRowCount(xcelFilePath, "citydata");
		
		for(i=0;i<=rowcount;i++){
			
		try {
		System.out.println();	
		cityname= cityflowobj.ReadXcalData(xcelFilePath, "citydata", i);
		String searchedCity = "Searching for: Hotels in "+cityname;
		System.out.println(searchedCity);
		obj.writeStatus(outfilePath, "Hotel_cases", searchedCity, 0, k);
		destination=driver.findElement(destinationfield);
		cityflowobj.destinaionsearch(cityname);
		driver.findElement(hotelsearchbutton).click();
		Thread.sleep(1000);
		String resultelementXpath="//*[@id=\"setbackfix\"]//*[text()=\"Hotels in "+cityname+"\"]";
		By resultElement= By.xpath(resultelementXpath);
		Assert.assertEquals(true,driver.findElement(resultElement).isDisplayed());
		System.out.println("Hotel city search redirection: Pass");
		obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, k);

		}
		catch(Exception Failcase1) {
			System.out.println("Hotel city search redirection: Failed");
			obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, k);
		}
		Thread.sleep(2000);
		String resultwindow= driver.getWindowHandle();
		
	//---- Result page meta price case---------------##########
	
		//---"Cleartrip.com--------------------------------------------------------- 
		System.out.println();
			try {
			if(cityflowobj.ResultTag1("Cleartrip.com")=="PASS") {
			obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, k+1);
			}
			else {
				obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, k+1);				
			}
			driver.switchTo().window(resultwindow);
		   }
			catch(Exception Failcase) {
				System.out.println("Result page: Meta price Cleartrip.com not seen: Failed");
				obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, k+1);				
			} 
	//---"Booking.com----------------------------------	------------------------------- 
		System.out.println();
		try {
		 if(cityflowobj.ResultTag1("Booking.com")=="PASS"){
			obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, k+2);	
		 }
		 else {
				obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, k+2);
		 }
		driver.switchTo().window(resultwindow);
	      }
	catch(Exception Failcase) {
		System.out.println("Result page: Meta price Booking.com not seen: Failed");
		obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, k+2);
	 }
			
  //---"Makemytrip.com----------------------------------	------------------------------- 		
		System.out.println();
		try {
		 if( cityflowobj.ResultTag1("Makemytrip.com")=="PASS") {
			obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, k+3);	
		 }
		 else {
				obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, k+3);
		 }
		driver.switchTo().window(resultwindow);
      }
       catch(Exception Failcase) {
   		System.out.println("Result page: Meta price Makemytrip.com not seen: Failed");
		obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, k+3);	
	   }
  //---"Goibibo.com----------------------------------	------------------------------- 			
		System.out.println();
	  try {
		 if(cityflowobj.ResultTag1("Goibibo.com")=="PASS") {
			obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, k+4);	
		  }
		 else {
			obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, k+4);	
		 }
		driver.switchTo().window(resultwindow);
		  }
		catch(Exception Failcase) {
			System.out.println("Result page: Meta price Goibibo.com not seen: Failed");
			obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, k+4);	
		}	  
	 //---More Deals----------------------------------	------------------------------- 			
		System.out.println();
		if(cityflowobj.ResultTagMoreDeals()=="PASS") {
		obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, k+5);
		obj.writeStatus(outfilePath, "Hotel_cases", statusP, 2, k+6);
		}
		else {
			obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, k+5);
			obj.writeStatus(outfilePath, "Hotel_cases", statusF, 2, k+6);
		}
		driver.switchTo().window(resultwindow);

	driver.navigate().back();
	k=k+7;
}
}		
}

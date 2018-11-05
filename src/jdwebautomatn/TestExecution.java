package jdwebautomatn;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestExecution  {

	WebDriver driver;
	WebHomeElements test=new WebHomeElements();

	
@BeforeTest
public void clearxcelStatus() throws IOException {
	test.clearPreviousOutputStatus();
}

@AfterTest
public void executionReport() throws IOException {
	test.createOutputFile();
}
	
@BeforeMethod
public void launchbrowser() throws InterruptedException{
    test.launchwebsite();
}

@AfterMethod
public void closebrows() throws InterruptedException {
	Thread.sleep(1000);
	test.closeTabs();
}

HotelsWeb hotelobj=new HotelsWeb();

@Test (priority=1)
public void hotelAutomation_Redirections() throws InterruptedException, IOException {
	hotelobj.hotelWebRedirections();
}

@Test (priority=2)
public void hotelAutomation_Hotelsearch_DetailsPage_MetaPrice() throws InterruptedException, IOException {
hotelobj.hotelCompanySearchflow();
}

@Test (priority=3)
public void hotelAutomation_CitySearch_Resultpage_MetaPrice() throws InterruptedException, IOException {
hotelobj.hotelCitySearchflow();
}

/*Webhome testautosuggest=new Webhome();

@Test (priority=4)
public void CitysearchAutosuggestTest() throws InterruptedException, IOException {
	testautosuggest.jdwebcitysearch();
}

@Test (priority=5)
public void Category_searchAutosuggestTest() throws InterruptedException, IOException {
	testautosuggest.categorySearchAutosuggest();
}
	
@Test (priority=6)
public void Company_searchAutosuggestTest() throws InterruptedException, IOException {
	testautosuggest.companySearchAutosuggest();
}

@Test (priority=7)
public void Product_searchAutosuggestTest() throws InterruptedException, IOException {
	testautosuggest.productSearchAutosuggest();
}


@Test (priority=8)
public void Grouping_searchAutosuggestTest() throws InterruptedException, IOException {
	testautosuggest.groupSearchAutosuggest();
}

@Test (priority=9)
public void Movies_searchAutosuggestTest() throws InterruptedException, IOException {
	testautosuggest.movieSearchAutosuggest();
	
}*/
	
}

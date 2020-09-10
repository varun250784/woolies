package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import managers.PageObjectManager;
import objectrepository.HomePage_OR;
import utils.CommonFunctionLib;

public class HomePage extends HomePage_OR {
	
	WebDriver driver;
	CommonFunctionLib cfl = new CommonFunctionLib();
	PageObjectManager pageObjectManager=new PageObjectManager();;
	 public HomePage(WebDriver driver) {
	 
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
	 }
	 
	 
	 
	 public SearchResultPage perform_Search(String search) {
		 searchBox.sendKeys("Find a Service NSW location");
		 searchButton.click();
		 return pageObjectManager.getSearchResultPage();
	 }
	 
	 public void navigateTo_HomePage(String url) {
	 cfl.navigate_to_url(url);
	 }

	 
}

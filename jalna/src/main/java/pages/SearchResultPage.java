package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Managers.PageObjectManager;
import ObjectRepository.SearchResultPage_OR;

public class SearchResultPage extends SearchResultPage_OR{


	WebDriver driver;
	PageObjectManager pageObjectManager=new PageObjectManager();
	 public SearchResultPage(WebDriver driver) {
	 
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
	 }
	  
	 public ServiceCenterPage clickOnLink(String text)
	 {
		 searchedLink.click();
		 return pageObjectManager.getServiceCenterPage();
	 }
	 
	 public String getAddress()
	 {
		 return addressValue.getText();
	 }
}

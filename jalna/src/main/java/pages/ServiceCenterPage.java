package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Managers.PageObjectManager;
import ObjectRepository.ServiceCenter_OR;

public class ServiceCenterPage  extends ServiceCenter_OR{
	WebDriver driver;
	PageObjectManager  pageObjectManager = new PageObjectManager();
	 public ServiceCenterPage(WebDriver driver) {
	 
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
	 }
	 
	 public String getText()
	 {
		return serviceCenterLocation.getText();
	 }
	 
	 public SearchResultPage performSearch(String searchText)
	 {
		searchBox.sendKeys(searchText);
		searchButton.click();
		return pageObjectManager.getSearchResultPage();
	 }
}

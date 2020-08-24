package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ObjectRepository.SearchByLocation_OR;

public class SearchByLocationPage extends SearchByLocation_OR {

	WebDriver driver;
	 public SearchByLocationPage(WebDriver driver) {
	 
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
	 }
}

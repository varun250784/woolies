package cucumber;


import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SearchResultPage;
import pages.ServiceCenterPage;


public class PageObjectManager {
	private WebDriver driver;
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	private ServiceCenterPage serviceCenterPage;


	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	public HomePage getHomePage(){
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public SearchResultPage getSearchResultPage(){
		return (searchResultPage == null) ? searchResultPage = new SearchResultPage(driver) : searchResultPage;

	}

	public ServiceCenterPage getServiceCenterPage(){
		return (serviceCenterPage == null) ? serviceCenterPage = new ServiceCenterPage(driver) : serviceCenterPage;

	}

}
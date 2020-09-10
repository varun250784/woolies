package managers;


import org.openqa.selenium.WebDriver;



import pages.HomePage;
import pages.SearchResultPage;
import pages.ServiceCenterPage;
import utils.CommonFunctionLib;





public class PageObjectManager {

	private WebDriver driver;
	CommonFunctionLib cfl = new CommonFunctionLib();
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	private ServiceCenterPage serviceCenterPage;


	public PageObjectManager() {
		this.driver = cfl.getDriver();

	}
	public WebDriver getDriver() {
		return driver;
	}


	public HomePage getHomePage(){

		return (homePage == null) ? homePage = new HomePage(getDriver()) : homePage;

	}

	public SearchResultPage getSearchResultPage(){

		return (searchResultPage == null) ? searchResultPage = new SearchResultPage(getDriver()) : searchResultPage;

	}

	public ServiceCenterPage getServiceCenterPage(){

		return (serviceCenterPage == null) ? serviceCenterPage = new ServiceCenterPage(getDriver()) : serviceCenterPage;

	}


}
package stepdfn;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.SearchResultPage;
import pages.ServiceCenterPage;
import utils.CommonFunctionLib;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import Managers.PageObjectManager;
import Managers.WebDriverManager;
import apireqests.ApiBase;
import cucumber.api.java.en.And;

public class ServiceNSW {

HomePage homePage;
ServiceCenterPage serviceCenterPage;
SearchResultPage searchResultPage;
private String homePageURL="https://www.service.nsw.gov.au/";
private String searchItem="Find a Service NSW location";
WebDriverManager webDriverManager = new WebDriverManager();
CommonFunctionLib cfl= new CommonFunctionLib();
WebDriver driver = cfl.getDriver();
String serachResultPageURL="search-results";
String srviceCenterPageURL="service-centre";
PageObjectManager pageObjectManager = new PageObjectManager();
public ApiBase ab= new ApiBase();
String address="Marrickville Service Centre is located at Marrickville Metro Shopping Centre, Shop 9, 34 Victoria Road, Marrickville NSW, 2204.";
String verificationText;


  @Given("^I am a user navigating to the url \"([^\"]*)\"$")
  public void navigateToURL(String url)
	{
//		driver = webDriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage = pageObjectManager.getHomePage();
		homePage.navigateTo_HomePage(homePageURL);
	}

  @And("^I search for \"([^\"]*)\"$")
  public void enterSearchItem(String url) throws Exception
	{
	  searchResultPage = homePage.perform_Search(searchItem);
	  if(!(driver.getCurrentUrl().contains(serachResultPageURL)))
		  throw new Exception("Incorrect URL for the Page"+driver.getCurrentUrl() +"should contain"+serachResultPageURL);
	}
  
  @Then("^I am re-directed to the \"([^\"]*)\" page$")
  public void verifyPageTitle(String pageTitle)
	{
		assertEquals(pageTitle,cfl.getPageTitle(driver));
	}
  
  @When("^I click on the \"([^\"]*)\" link$")
  public void clickOnLink(String text) throws Exception
	{
	  serviceCenterPage = searchResultPage.clickOnLink(text);
	 
	}
  
  @Given("^I am a user on the \"([^\"]*)\" page$")
  public void launchURL(String url)
  {
	  cfl.navigate_to_url(url);
	  assertTrue(driver.getCurrentUrl().contains(srviceCenterPageURL));
  }
  
  @When("^I search for \"([^\"]*)\" in the Search by suburb, postcode or current location field$")
  public void enterSuburbToSearch(String searchItem)
  {
	  serviceCenterPage=pageObjectManager.getServiceCenterPage();
	  searchResultPage= serviceCenterPage.performSearch(searchItem);
	  searchResultPage.getAddress();
	  
  }
  
  @Then("^I should see \"([^\"]*)\" and its address returned in the results$")
  public void verifySearchResults(String centerName)
  {
	  assertEquals(searchResultPage.getAddress(),address);
  }
}

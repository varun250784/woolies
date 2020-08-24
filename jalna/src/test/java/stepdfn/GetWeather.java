package stepdfn;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import Managers.PageObjectManager;
import Managers.WebDriverManager;
import apireqests.ApiBase;
import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pages.HomePage;
import pages.ServiceCenterPage;
import utils.CommonFunctionLib;

public class GetWeather extends BaseStep{

	HomePage homePage;
	ServiceCenterPage serviceCenterPage;
	PageObjectManager pageObjectManager = new PageObjectManager();
	CommonFunctionLib cfl= new CommonFunctionLib();
	public ApiBase ab= new ApiBase();
	String verificationText;

	public GetWeather(TestContext testContext) throws Exception{
		super(testContext);

	}
	@Given("^I have api url$")
	public void fetchUrlFromExcel() throws Throwable {


	}

	@And("^I trigger api request with correct \"([^\"]*)\"$")
	public void triggerrequest(String val) throws IOException
	{
		ab.triggerRequest(testData.get(val).get(0));

	}

	@Then("^I receive the correct payload and Information \"([^\"]*)\"$")
	public void verifyResult(int val)
	{
		assertTrue(ab.verifyResponse(val));
	}
}

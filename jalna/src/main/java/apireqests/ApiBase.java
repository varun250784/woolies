package apireqests;

import java.io.FileInputStream;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class ApiBase {

	public int responseCode;
	private String Base_URL = "http://api.weatherbit.io/v2.0/current?";//key=6029d0acab83492e874cd4bdd71aaa5e&lat=40.730610&lon=-73.935242";
	


	public void prepareAPI(Map<String, String> coordinates) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"/Config.properties");
		prop.load(ip);
		String key = prop.getProperty("key");
		Base_URL=Base_URL+"key="+key+"&lat="+coordinates.get("lat")+"&lon="+coordinates.get("lon");
	}
	public void triggerRequest(Map<String, String> coordinates) throws IOException
	{
		prepareAPI(coordinates);
		RestAssured.baseURI=Base_URL;
		responseCode=given().get(Base_URL).then().extract().response().statusCode();
	}
	public boolean verifyResponse(int expectedResponse)
	{
		if(responseCode==expectedResponse)
			return true;
		else return false;
	}

}

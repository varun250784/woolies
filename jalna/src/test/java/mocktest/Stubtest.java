package mocktest;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;

import io.restassured.RestAssured;


import org.junit.Test;

public class Stubtest {

	private WireMockServer wireMockServer;
	private String getURL="api/user?id=1";
	private String postURL="api/user/234";
	private String baseURL="http://localhost:8080/";
	
	public Stubtest()
	{
		 wireMockServer = new WireMockServer(); 
		configureFor("localhost", 8080);
		wireMockServer.start();
		System.out.println("Sever Started");
	}
	
	@Test
	public void testGet_User_ById()
	{
		String url=baseURL+getURL;
		String response=given().get(url).then().extract().response().body().asString();
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(response).getAsJsonObject();
		assertEquals("Varun",obj.get("firstName").toString().replaceAll("\"", ""));
	}
	
	/*
	 * Task2 Scenario 2
	 * Using a mock server (your choice which mock framework to use), develop a dummy POST request and verify the new record has been created.
	 */
	@Test
	public void testPostRequest()
	{
		String url=baseURL+postURL;
		String response=given().post(url).then().extract().response().body().asString();
		assertEquals("User created!",response);
	}
	
	@After
	public void teardown()
	{
		wireMockServer.stop();
	}
}

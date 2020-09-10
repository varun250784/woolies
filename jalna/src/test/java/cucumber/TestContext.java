package cucumber;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import managers.WebDriverManager;
import utils.ExcelReader;

public class TestContext {

	private HashMap<String,List<Map<String, String>>> testData;
	public String scenarioName;
	 private WebDriverManager webDriverManager;
	 private PageObjectManager pageObjectManager;

	/**
	 * @throws Exception 
	 * 
	 */
	public void setTestData(Object[][]data) throws Exception {
		ExcelReader er= new ExcelReader();
		testData=er.getTestDataFromExcel();
    }
	
	/**
	 * @throws Exception 
	 * 
	 */
	public HashMap<String,List<Map<String, String>>> getTestData() throws Exception {
		ExcelReader er= new ExcelReader();
		testData=er.getTestDataFromExcel();
        return this.testData;
    }
	
	 public TestContext() throws IOException{
		 webDriverManager = new WebDriverManager();
		// pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		 }
		 
		 public WebDriverManager getWebDriverManager() {
		 return webDriverManager;
		 }
		 
		 public PageObjectManager getPageObjectManager() {
		 return pageObjectManager;
		 }
	
	
	
}

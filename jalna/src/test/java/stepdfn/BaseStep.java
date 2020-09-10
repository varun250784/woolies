package stepdfn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cucumber.TestContext;

public class BaseStep {
	 
	    public HashMap<String,List<Map<String, String>>> testData;
	    public String scenarioName;
	 
	    public BaseStep(String name) throws Exception {
	    	scenarioName=name;
	    }

		public String getScenarioName(String scenarioName) {
			return scenarioName;
		}

		public BaseStep(TestContext testContext) throws Exception {
	    	testData = testContext.getTestData();
	    }
	 
	   

}

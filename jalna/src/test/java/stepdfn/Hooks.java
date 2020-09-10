package stepdfn;



import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before
	public void BeforeSteps(Scenario scenario) {
		System.out.println("###Starting Scenaerio ###");
	}

	@After
	public void AfterSteps() {
	//	testContext.getWebDriverManager().closeDriver();
	}

}

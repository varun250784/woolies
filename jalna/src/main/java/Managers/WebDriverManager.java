package Managers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import enums.DriverType;
import utils.CommonFunctionLib;

public class WebDriverManager {
	private WebDriver driver;
	CommonFunctionLib cfl = new CommonFunctionLib();
	private static DriverType driverType;
	
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
	}

	/*
	 * CRete the driver
	 */
	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cfl.setDriver(driver);
		return driver;
	}

	private WebDriver createDriver() {
		driver = createLocalDriver();
		return driver;
	}

	/*
	 * Create Web Driver
	 */
	private WebDriver createLocalDriver() {
		switch (driverType) {     
		case IE : 
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+FileReaderManager.getInstance().getConfigReader().getDriverPath()); 
		break;
		case CHROME : 
			if (System.getProperty("os.name").toLowerCase().equals("mac os x"))
			System.setProperty(CHROME_DRIVER_PROPERTY, System.getProperty("user.dir")+FileReaderManager.getInstance().getConfigReader().getDriverPath());
			else 
				System.setProperty(CHROME_DRIVER_PROPERTY, System.getProperty("user.dir")+FileReaderManager.getInstance().getConfigReader().getDriverPathWindows());
			driver = new ChromeDriver();
			break;
		}

		if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	} 

	/*
	 * Close and Quit the driver
	 */
	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}
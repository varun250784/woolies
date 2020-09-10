package managers;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import enums.DriverType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import utils.CommonFunctionLib;

public class WebDriverManager {
	//private WebDriver driver;
	private AndroidDriver<AndroidElement> androidDriver;
	CommonFunctionLib cfl = new CommonFunctionLib();
	private static DriverType driverType;
	private AndroidDriverFactory adf = new AndroidDriverFactory();

	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	//	public WebDriverManager() {

	/*
	 * CRete the driver
	 */
	AndroidDriver<AndroidElement>  getDriver() throws IOException {
		if(androidDriver == null) androidDriver = createDriver();
		androidDriver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		cfl.setDriver(androidDriver);
		return androidDriver;
	}

	public AndroidDriver<AndroidElement> createDriver() throws IOException{
		return adf.getDriver();
	}

	/*
	 * Close and Quit the driver
	 */
	public void closeDriver() {
		androidDriver.close();
		androidDriver.quit();
	}

	//driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
	//	}


	//
	//	private WebDriver createDriver() throws IOException {
	//		driver = createLocalDriver();
	//		return driver;
	//	}

	/*
	 * Create Web Driver
	 */
	//private WebDriver createLocalDriver() throws IOException {
	//	switch (driverType) {     
	//		case IE : 
	//			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+FileReaderManager.getInstance().getConfigReader().getDriverPath()); 
	//		break;
	//		case CHROME : 
	//			if (System.getProperty("os.name").toLowerCase().equals("mac os x"))
	//			System.setProperty(CHROME_DRIVER_PROPERTY, System.getProperty("user.dir")+FileReaderManager.getInstance().getConfigReader().getDriverPath());
	//			else 
	//				System.setProperty(CHROME_DRIVER_PROPERTY, System.getProperty("user.dir")+FileReaderManager.getInstance().getConfigReader().getDriverPathWindows());
	//			driver = new ChromeDriver();
	//			break;

	//		}
	//
	//		 driver.manage().window().maximize();
	//		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
	//		return driver;
	//} 



}
package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class CommonFunctionLib {

	private static WebDriver driver;
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	/*
	 * Click the Web Element
	 */
	public void webdriverClick (WebElement webElement)
	{
	webElement.click();
	}
	/*
	 * Return the title of page
	 */
	public String getPageTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
	/*
	 * Navigate to specific URL
	 */
	public void navigate_to_url(String url)
	{
		driver.get(url);
	}
}

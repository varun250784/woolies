package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ServiceCenter_OR {
	
	@FindBy(how=How.XPATH, using="//input[@aria-label='Search'and @class='form__text']")
	protected WebElement searchBox;

	
	@FindBy(how=How.XPATH, using="//button[@type='submit']")
	protected WebElement searchButton;
	
	@FindBy(how=How.XPATH, using="//a[normalize-space(text())='Marrickville Service Centre']")
	protected WebElement serviceCenterLocation;

}

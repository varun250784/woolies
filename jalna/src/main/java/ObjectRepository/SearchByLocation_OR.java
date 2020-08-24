package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchByLocation_OR {
	
	
	@FindBy(how=How.XPATH, using="//input[@id='locatorTextSearch']//preceding-sibling::label")
	protected WebElement searchBox;

}

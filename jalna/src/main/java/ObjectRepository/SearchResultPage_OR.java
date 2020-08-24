package ObjectRepository;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class SearchResultPage_OR {
	
	@FindBy(how=How.XPATH, using="//h3/a[normalize-space(text())='Find a Service NSW location']")
	protected WebElement searchedLink;
	
	@FindBy(how=How.XPATH, using="//div[@class='search__result']//h3//a[normalize-space(text())='Marrickville Service Centre']/../following-sibling::p")
	protected WebElement addressValue;
	
}


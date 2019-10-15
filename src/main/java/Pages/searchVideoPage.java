package Pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseP.BaseClass;

public class searchVideoPage extends BaseClass{
	
	
	public searchVideoPage(){
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@class='input__control']")
	private WebElement textSearchBox;
	
	public WebElement getTextSearchBox() {
		return textSearchBox;
	}

	@FindBy(xpath="//div[@class='websearch-button__text']")
	private WebElement buttonSearch;
	
	public WebElement getButtonSearch() {
		return buttonSearch;
	}

	@FindBy(xpath="//div[@class='serp-item__snippet serp-item__snippet_new-summary_yes']/a")
	private List<WebElement> getVideoLinks;

	public List<WebElement> getGetVideoLinks() {
		return getVideoLinks;
	}
	
	public void launch(){
		new HomePage().launch();
		new HomePage().getButtonVideo().click();
	}
	


	public List<String> getVideoLinkText(){
		
	List<String> videosText = new ArrayList<String>();
	
	for(WebElement element:getGetVideoLinks()){
		
		videosText.add(element.getAttribute("href"));
	}
	return videosText;
		
	}
}

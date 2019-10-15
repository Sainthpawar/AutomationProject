package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import BaseP.BaseClass;

public class searchResultsPage  extends BaseClass{

	public searchResultsPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='navigation__region']//a")
	private List<WebElement> linkNavigationTab;
	
	public List<WebElement> getLinkNavigationTab() {
		return linkNavigationTab;
	}
	
	@FindBy(xpath="//div[@class='organic__url-text']")
	private List<WebElement> headersearchResults;
	
	public List<WebElement> getHeadersearchResults() {
		return headersearchResults;
	}
	
	
	@FindBy(xpath="//div[@class='path path_show-https organic__path']//a")
	private List<WebElement> links;
	
	public List<WebElement> getLinks() {
		return links;
	}
	
	@FindBy(xpath="//div[@class='misspell__message']")
	private WebElement textSyntaxError;
	
	public WebElement getTextSyntaxError() {
		return textSyntaxError;
	}
	
	

	public String getNaviagtionTab(){
		for(WebElement link:getLinkNavigationTab()){
			
			if(!link.getAttribute("target").equals("_blank")){
				
				return link.findElement(By.xpath("//span[@class='service__name']")).getAttribute("innerText");
				
			}
		}
		
		throw new NoSuchElementException("Locator didnot return any result,Please check your locator it might have been modified");
	}
	
	public List<String>  getSearchTextDispalyedInBold(){
		
		List<String> text = new ArrayList<String>();
		
		for(WebElement resultLink:getHeadersearchResults()){
			
			text.add(resultLink.findElement(By.xpath("//b")).getAttribute("innerText"));
			
				
		}
		return text;
	}
	
	public List<String> getLinkText(){
		
		List<String> linkText = new ArrayList<String>();
		
		for(WebElement element:getLinks()){
			
			linkText.add(element.getAttribute("href"));
		}
		return linkText;
			
		}
	

}

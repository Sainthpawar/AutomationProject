package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseP.BaseClass;

public class HomePage  extends BaseClass {

	public HomePage() {
		
		PageFactory.initElements(driver, this);	
	}
	
	
	@FindBy(xpath="//input[@id='text']")
	private WebElement textBoxUserName;
	public WebElement getTextBoxUserName(){
		return textBoxUserName;
	}
	
	@FindBy(xpath="//button[contains(@class,'websearch')]")
	private WebElement buttonSearch;
	public WebElement getButtonSearch(){
		return buttonSearch;
	}
	
	@FindBy(xpath="//div[contains(@class,'video')]")
	private WebElement buttonVideo;
	public WebElement getButtonVideo(){
		return buttonVideo;
	}
	
	
	public void launch(){
		invoke();
	}
	
	
	

}

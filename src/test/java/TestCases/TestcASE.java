package TestCases;

import java.util.List;

import org.testng.annotations.Test;
import BaseP.BaseClass;
import Pages.HomePage;
import Pages.searchResultsPage;
import Utilities.UtilityClass;

public class TestcASE extends BaseClass{

	/**
	 * Scenario : Verify when text is searched,search Result page is displayed
	 */
	@Test(enabled=false)
	public void m1(){
		HomePage homePage = new HomePage();
		homePage.launch();
		/*homePage.getTextBoxUserName().sendKeys("sainath");
		homePage.getButtonSearch().click();*/
		homePage.getButtonVideo().click();
		searchResultsPage searchResultsPage = new searchResultsPage();
		verifyTrue(searchResultsPage.getNaviagtionTab().equals("Video"));

	}
	
	/**
	 * Scenario : Verify if search results are displayed
	 */
	@Test(enabled=false)
	public void m2(){
		HomePage homePage = new HomePage();
		homePage.launch();
		homePage.loadData();
		homePage.getTextBoxUserName().sendKeys(prop.getProperty("searchText"));
		homePage.getButtonSearch().click();
		searchResultsPage searchResultsPage = new searchResultsPage();
		verifyTrue(searchResultsPage.getLinks().size()>0);

	}
	
	/**
	 * Scenario : Verify if search results keyword displayed in bold
	 */
	@Test(enabled=false)
	public void m3(){
		HomePage homePage = new HomePage();
		homePage.launch();
		homePage.loadData();
		homePage.getTextBoxUserName().sendKeys(prop.getProperty("searchText"));
		homePage.getButtonSearch().click();
		searchResultsPage searchResultsPage = new searchResultsPage();
		List<String> searchTextDispalyedInBold = searchResultsPage.getSearchTextDispalyedInBold();
		verifyTrue(UtilityClass.verifyLinksText(searchTextDispalyedInBold, "sainath"));

	}
	
	
	
	/**
	 * Scenario : Verify if search results keyword displayed in bold
	 */
	@Test(enabled=false)
	public void m4(){
		HomePage homePage = new HomePage();
		homePage.launch();
		homePage.loadData();
		String searchText = prop.getProperty("searchText");
		homePage.getTextBoxUserName().sendKeys(searchText);
		homePage.getButtonSearch().click();
		searchResultsPage searchResultsPage = new searchResultsPage();
		List<String> linkText = searchResultsPage.getLinkText();
		verifyTrue(UtilityClass.verifyLinksText(linkText, searchText));

	}
	
	
	
	/**
	 * Scenario : Verify if search results are not when entered only special characters as search text(E.g, #####)
	 */
	@Test(enabled=false)
	public void m5(){
		HomePage homePage = new HomePage();
		homePage.launch();
		homePage.loadData();
		homePage.getTextBoxUserName().sendKeys(prop.getProperty("specialCharacterText"));
		homePage.getButtonSearch().click();
		searchResultsPage searchResultsPage = new searchResultsPage();
		searchResultsPage.waitForPageToLoad();
		verifyTrue(searchResultsPage.getNaviagtionTab().equals("Web"));
		verifyTrue(searchResultsPage.getTextSyntaxError().getText().equals("Syntax error"));

	}
	
	/**
	 * Scenario : Verify if search text box and button search displayed on search result page
	 */
	@Test
	public void m6(){
		HomePage homePage = new HomePage();
		homePage.launch();
		verifyTrue(homePage.getTextBoxUserName().isDisplayed());
		verifyEquals(homePage.getButtonSearch().getText(), "Search");
	}
}

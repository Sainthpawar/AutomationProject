package BaseP;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseClass {
	public static  WebDriver driver;
	public static Properties prop;
	SoftAssert softAssert;
	
	public Properties loadData(){
		
		try {
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");
			prop= new Properties();
			prop.load(fis);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return prop;	
	}
	
	
	public static void init(){
		
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
		driver =  new ChromeDriver();
		}
		else if (browser.equals("chrome")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driver\\firefoxdriver.exe");
			driver =  new FirefoxDriver();
		}
	}

	
	
	
	@BeforeMethod
	public void setUp(){
		init();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		softAssert = new SoftAssert();
	}
	
	@AfterMethod
	public void tearDown(){
		softAssert.assertAll();
		driver.quit();
	}
	
	public void invoke(){
		driver.get(prop.getProperty("url"));
	}
	
	public void waitForPageToLoad(){
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
	}

	public void verifyEquals(String actual,String expected){
		
		 softAssert.assertEquals(actual, expected, "actual value is"+actual+"expected value"+expected);;
		 
		
	}

	public void verifyTrue(boolean conditions){
		
		 softAssert.assertTrue(conditions);
		 
		
	}





}

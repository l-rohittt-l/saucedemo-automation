package base;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		Map<String,Object> prefs = new HashMap<>();
		
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--incognito");
		
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-save-password-bubble");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-extensions");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com");
	}
	
	@AfterMethod
	public void teardown() {
		if(driver!=null) {
			try {
				Thread.sleep(10000);
			} catch(Exception e) {
				
			}
			driver.quit();
		}
	}

}

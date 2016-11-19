package selenium.junit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
	private WebDriver driver;
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver(String url, String browserType, String... browserProfile){
		WebDriver driver;
		switch (browserType.toLowerCase()) {
		case "ie": case "internet explorer":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;

		case "ff": case "firefox":
			System.setProperty("webdriver.firefox.marionette",System.getProperty("user.dir")+"\\geckodriver.exe");
//			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
			DesiredCapabilities capabilities=DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			if(browserProfile.length>0){
				ProfilesIni profile = new ProfilesIni();
				FirefoxProfile myProfile = profile.getProfile(browserProfile[0]);
				driver = new FirefoxDriver(myProfile);
			}else{
				driver = new FirefoxDriver(capabilities);
			}
			
			break;
		
		case "chrome": case "googlechrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		default:
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		driver.get(url);
		driver.manage().window().maximize();
		this.driver = driver;
		setDriver(this.driver);
		return this.driver;
	}
	
	public WebDriver getDriver(){
		return driver;
	}
}

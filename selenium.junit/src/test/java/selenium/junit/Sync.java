package selenium.junit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Sync {
	ProfilesIni profile = new ProfilesIni();
	public WebDriver driver;
	public WebDriver driver1 = new FirefoxDriver();
//	public DefaultSelenium selenium = new DefaultSelenium("localhost", 1234, "firefox", "http://www.google.com");
	
	@After
	public void tearDown(){
		System.out.println("Method execution completed");
		driver.quit();
	}
	
	@Test
	public void testCase() throws InterruptedException{
		FirefoxProfile myProfile = profile.getProfile("SeleniumProfile");
		driver = new FirefoxDriver(myProfile);
		driver.get("http://www.google.com");
//		selenium.waitForPageToLoad("1000");
		
		thisone();
	}
	
	public void thisone() throws InterruptedException{
		Thread.sleep(1000);
		WebElement actObj = driver.findElement(By.xpath(".//*[@id='lst-ib']"));
//		selenium.click(".//*[@id='lst-ib']");
//		selenium.typeKeys(".//*[@id='lst-ib']", "India");
		/*actObj.click();
		actObj.sendKeys("India");*/
	}
}

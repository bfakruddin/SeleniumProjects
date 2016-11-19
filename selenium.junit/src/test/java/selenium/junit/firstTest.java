package selenium.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import selenium.junit.DriverFactory;

public class firstTest{
	private WebDriver drive=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(System.getProperty("user.dir"));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		DriverFactory dd = new DriverFactory();
		drive = dd.getDriver("http://www.google.com", "ff", "Baba");
	}

	@After
	public void tearDown() throws Exception {
		drive.quit();
	}

	@Test
	public void test() {
		
	}

}

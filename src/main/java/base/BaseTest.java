package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;

public class BaseTest {
	protected WebDriver driver;
	private ConfigReader configreader;

	@BeforeMethod
	public void setup() {
		configreader = new ConfigReader();
		configreader.initProperties();
		String browser = ConfigReader.getproperty("browser");
		boolean headless = Boolean.parseBoolean(ConfigReader.getproperty("headless"));
		DriverFactory.initDriver(browser, headless);
		driver = DriverFactory.getDriver();
		driver.get(ConfigReader.getproperty("url"));
	}

	@AfterMethod
	public void teardown() {
		DriverFactory.quitDriver();
	}
}

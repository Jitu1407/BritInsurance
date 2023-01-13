package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {

	private static WebDriver driver;

	public static void init_browser(String browser) {
		switch (browser.toLowerCase()) {
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "chrome":
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		}
		driver.manage().window().maximize();
		driver.get("https://www.britinsurance.com/");
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
}

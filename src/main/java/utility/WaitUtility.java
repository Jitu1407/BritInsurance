package utility;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseDriver;

public class WaitUtility {

	public static void waitForVisibility(WebElement element)
	{
	   waitForVisibility(element,15);
	}
	
	public static void waitForVisibility(WebElement element, int duration)
	{
		new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(duration)).until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForClickability(WebElement element, int duration)
	{
		new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(duration)).until(ExpectedConditions.elementToBeClickable(element));
	}
	

	public static void waitForClickability(WebElement element)
	{
		waitForClickability(element,15);
	}
	
	public static void waitForTitle(String title)
	{
	   new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.titleIs(title));
	}
}

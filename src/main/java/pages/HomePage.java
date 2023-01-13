package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static utility.WaitUtility.*;

import base.BaseDriver;

public class HomePage {
	
	@FindBy(css = "div.component--header__search button")
	WebElement searchIcon;
	
	@FindBy(name= "k")
	WebElement searchTextBox;
	
	@FindBy(className = "header--search__results")
	WebElement resultList;
	
	@FindBy(css = "div.header--search__results a")
    List<WebElement> resultListValues;
	
	@FindBy(css = ".component--header__burger")
	WebElement menu;
	
	@FindBy(css = ".component--header__burger.active")
	WebElement crossmenu;
	
	@FindBy(linkText = "contact")
	WebElement contactlink;
	
	@FindBy(id="CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
	WebElement acceptCookie;
	
	@FindBy(linkText = "INSURANCE")
	WebElement insurancelink;
	
	public HomePage()
	{
		PageFactory.initElements(BaseDriver.getDriver(),this);
	}
	
	public void clickSearchIcon()
	{
waitForVisibility(insurancelink);
try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 searchIcon.click();
		 

	}
	
	public void enterSearchBoxtext(String text)
	{
		waitForVisibility(searchTextBox);
		searchTextBox.sendKeys(text);
	}
	
	public List<String> getResultsValues()
	{
		List<String> list=new ArrayList<String>();
		waitForVisibility(resultList);
		for(WebElement element:resultListValues)
		{
			list.add(element.getText());
		}
		return list;
	}
	
	public void clickMenuIcon()
	{
		waitForVisibility(insurancelink);
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 menu.click();
		 waitForVisibility(crossmenu);
	}
	
	public ContactPage clickContactLink()
	{
		boolean isclicked =false;
			while(!isclicked)
			{
				try
				{
					contactlink.click();
					isclicked=true;
				}
				catch(Exception e)
				{
					try
					{
				Robot robot=new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
            	robot.keyPress(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_CONTROL);	
					}
					catch (AWTException e1) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		waitForTitle("Contact");
		return new ContactPage();
		
	}
	
	
	public void acceptCookies()
	{
		waitForVisibility(acceptCookie);
		acceptCookie.click();
	}
	
	

}

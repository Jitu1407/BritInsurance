package basetest;

import base.BaseDriver;
import pages.HomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	
	protected HomePage home;
	
  @BeforeMethod
  public void beforeMethod() {
	  BaseDriver.init_browser("chrome");
	  home=new HomePage();
  }

  @AfterMethod
  public void afterMethod() {
	  BaseDriver.getDriver().quit();
  }

}

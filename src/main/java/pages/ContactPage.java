package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseDriver;

public class ContactPage {
	
@FindBy(xpath="//h2[text()='Bermuda Office']/parent::div/following-sibling::div//a")
WebElement bermudaPhoneNumber;


@FindBy(xpath="//h2[text()='Bermuda Office']/parent::div/following-sibling::div//address")
WebElement bermudaAddress;


@FindBy(xpath="//h2[text()='Bermuda Office']/parent::div/following-sibling::div//p")
WebElement bermudaCity;

public ContactPage()
{
	PageFactory.initElements(BaseDriver.getDriver(),this);
}

public String getBermudaPhoneNumber()
{
	return bermudaPhoneNumber.getText();
	}


public String getBermudaAddress()
{
	return bermudaAddress.getText();
	}


public String getBermudaCity()
{
	return bermudaCity.getText();
	}

}

package britinsurance;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static base.BaseDriver.*;
import basetest.BaseTest;
import pages.ContactPage;


public class DemoTests extends BaseTest {
	@Test(description = "Scenario 1 - Perform Search and Validate Expected Results")
	public void validateSearch() {
		home.clickSearchIcon();
		home.enterSearchBoxtext("IRF 17");
		List<String> list = new ArrayList<String>();
		list.add("Interim results for the six months ended 30 June 2022");
		list.add("Gavin Wilkinson");
		list.add("John King");
		List<String> actualResults = home.getResultsValues();
		assertEquals(actualResults.size(), 3);
		for (String s : list) {
			assertTrue(actualResults.contains(s));
		}

	}
	
	@Test(description = "Scenario 2 - Click Contact and verify Address" )
	public void validateContactAddress() {
		home.acceptCookies();
		home.clickMenuIcon();
        ContactPage contact=home.clickContactLink();
        assertEquals(contact.getBermudaCity(), "Pembroke");
        assertEquals(contact.getBermudaAddress(),"Ground Floor, Chesney House\n"
        		+ "The Waterfront, 96 Pitts Bay Road,\n"
        		+ "Pembroke, Hamilton HM 08, Bermuda");

        assertEquals(contact.getBermudaPhoneNumber(),"+1 441 278 0660");


	}

}

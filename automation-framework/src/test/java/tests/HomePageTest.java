package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class HomePageTest extends BaseTest {

	@Test
	public void openMakeMyTrip() {
		String title=Driver.getTitle();
		System.out.println("Title of the page is "+title);
		
		Assert.assertTrue(title.contains("MakeMyTrip") ,"Expected title to be MakeMyTrip but got" +title);
	}
}

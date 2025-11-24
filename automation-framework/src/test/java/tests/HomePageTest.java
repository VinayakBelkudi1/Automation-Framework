package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class HomePageTest extends BaseTest {

	@Test
	public void testOpenMakeMyTrip() {
		
		String title=Driver.getTitle();
		System.out.println("Title of the page is "+title);
		System.out.println("Feature branch practice");
		System.out.println("Feature branch practice11/24/2025");
		
		Assert.assertTrue(title.contains("MakeMyTrip") ,"Remote changes" +title);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

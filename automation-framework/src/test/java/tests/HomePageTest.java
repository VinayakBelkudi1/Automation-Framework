package tests;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class HomePageTest extends BaseTest {

	@Test
	public void testOpenMakeMyTrip() throws InterruptedException {

	    HomePage h = new HomePage(Driver);

	    // Close login popup
	    h.cancelHomePopup();

	    // Get title
	    String title = Driver.getTitle();
	    System.out.println("Page title: " + title);
	    Assert.assertTrue(title.contains("MakeMyTrip"));

	    // Close AI popup
	    h.closeAiPopup();

	    // Store parent
	    String parent = Driver.getWindowHandle();
	    
	    Thread.sleep(2000);
	    // Click List Your Property
	    h.clickOnListProperty();

	    Thread.sleep(2000);
	    // Switch back to parent (if new tab opened)
	    for (String handle : Driver.getWindowHandles()) {
	        if (!handle.equals(parent)) {
	            Driver.switchTo().window(handle);
	        }
	    }
	    Thread.sleep(3000);

	    System.out.println("Switched to List Your Property page.");
	}

}

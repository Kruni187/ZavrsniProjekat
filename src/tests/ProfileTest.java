package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AuthPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;

public class ProfileTest extends BasicTest {
	
	
	
	@Test (priority=0)
	
       public void editProfileTest() throws InterruptedException, IOException {
		LocationPopupPage lpp = new LocationPopupPage(driver, wait, executor);
		LoginPage lp = new LoginPage(driver,wait, executor);
		NotificationSistemPage nsp = new NotificationSistemPage(driver, wait, executor);
		ProfilePage pp = new ProfilePage(driver, wait, executor);
		AuthPage ap = new AuthPage(driver,wait, executor);
				
		this.driver.navigate().to(this.baseUrl + "/guest-user/login-form");		
		lpp.closePopup();
		Thread.sleep(1000);
		lp.logIn(email, password);
	    Assert.assertTrue(nsp.getMessage().equals("Login Successfull"));
	    
	    this.driver.navigate().to(this.baseUrl + "/member/profile");
	    
	    pp.updateProfile("Norghus", "Novus", "Necropolis123", "214124", "124125", "United Kingdom", "Brechin","Angus");
	    Assert.assertTrue(nsp.getMessage().equals("Setup Successful"),"Nije pronadjena poruka");
	    ap.logOut();
	    Assert.assertTrue(nsp.getMessage().equals("Logout Successfull!"),"Nije pronadjena poruka");	    
	   }
	
	
	@Test (priority=5)
	public void changeProfileImageTest() throws IOException, InterruptedException {
		
		LocationPopupPage lpp = new LocationPopupPage(driver, wait,executor);
		LoginPage lp = new LoginPage(driver,wait,executor);
		NotificationSistemPage nsp = new NotificationSistemPage(driver, wait,executor);
		ProfilePage pp = new ProfilePage(driver, wait,executor);
		AuthPage ap = new AuthPage(driver,wait,executor);
		
		this.driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		
		lpp.closePopup();
		lp.logIn(email, password);
	    Assert.assertTrue(nsp.getMessage().equals("Login Successfull"));
	    
	    this.driver.navigate().to(this.baseUrl + "/member/profile");	    
		pp.uploadImg();
		Assert.assertTrue(nsp.getMessage().equals("Profile Image Uploaded Successfully"));
		nsp.waitMsgDissapear();
		pp.removeImage();
		Assert.assertTrue(nsp.getMessage().equals("Profile Image Deleted Successfully"));
		nsp.waitMsgDissapear();
		ap.logOut();
		Assert.assertTrue(nsp.getMessage().equals("Logout Successfull!"));
	}
}

package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;


public class MealItemTest extends BasicTest {
	
	@Test (priority=0)
	
    public void addMealToCart() throws InterruptedException, IOException {
		LocationPopupPage lpp = new LocationPopupPage(driver, wait, executor);
		NotificationSistemPage nsp = new NotificationSistemPage(driver, wait, executor);
		MealPage mp = new MealPage(driver,wait, executor);
				
		this.driver.navigate().to(this.baseUrl + "/meal/soup-shrimp-salad-combo");
		lpp.closePopup();
		mp.addToCart("10");
		Assert.assertTrue(nsp.getMessage().contains("Please Select Location"));
		nsp.waitMsgDissapear();
		lpp.openLocation();
		Thread.sleep(1000);
		lpp.setLocation("City Center - Albany");
		mp.addToCart("15");
		Assert.assertTrue(nsp.getMessage().equals("Meal Added To Cart"));
		
	 }
	
@Test (priority=5)
	
    public void addMealToFavorite() throws InterruptedException, IOException {
		LocationPopupPage lpp = new LocationPopupPage(driver, wait, executor);
		LoginPage lp = new LoginPage(driver,wait, executor);
		NotificationSistemPage nsp = new NotificationSistemPage(driver, wait, executor);
		MealPage mp = new MealPage(driver,wait, executor);
				
		this.driver.navigate().to(this.baseUrl + "/meal/soup-shrimp-salad-combo");
		lpp.closePopup();		
		mp.favoriteMeal();	
		Thread.sleep(500);
		Assert.assertTrue(nsp.getMessage().equals("Please login first!"));
		this.driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		lp.logIn(email, password);
		this.driver.navigate().to(this.baseUrl + "/meal/soup-shrimp-salad-combo");				
		mp.favoriteMeal();
		Thread.sleep(600);
		Assert.assertTrue(nsp.getMessage().contains("Product has been added to your favorites"));
		
	 }
	
@Test (priority=10)

public void clearCart() throws InterruptedException, IOException {
	LocationPopupPage lpp = new LocationPopupPage(driver, wait, executor);	
	NotificationSistemPage nsp = new NotificationSistemPage(driver, wait, executor);
	MealPage mp = new MealPage(driver,wait, executor);	
	CartSummaryPage csp = new CartSummaryPage(driver,wait,executor);
	SoftAssert sa= new SoftAssert();
			
	this.driver.navigate().to(this.baseUrl + "/meals");
	
	lpp.setLocation("City Center - Albany");	
	File myFile = new File("data/Data.xlsx"); 
	FileInputStream fis = new FileInputStream(myFile);
	XSSFWorkbook wb = new XSSFWorkbook (fis);
	XSSFSheet mySheet = wb.getSheetAt(1);
	for(int i=1;i<mySheet.getLastRowNum();i++) {
		XSSFRow row = mySheet.getRow(i);
		this.driver.navigate().to(row.getCell(0).getStringCellValue());
		mp.addToCart("5");
		sa.assertTrue(nsp.getMessage().equals("Meal Added To Cart"));
	}
	csp.clearCart();
	Assert.assertTrue(nsp.getMessage().equals("All meals removed from Cart successfully"));
	wb.close();
 }
}

package pages;



import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	

	
	
	public ProfilePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
		super(driver, wait, executor);
	}
	public WebElement getProfilePicture() {
		return this.driver.findElement(By.xpath("//*[@id='profileInfo']/div/div[1]/div/a[1]"));
	}
	public WebElement getPictureCloseBtn() {
		return this.driver.findElement(By.xpath("//body/div[@id='body']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[2]"));
	}
	public WebElement getToHoverEle() {
		return this.driver.findElement(By.xpath("//div[@class='avatar']//img"));
	}
	public WebElement getFname() {
		return this.driver.findElement(By.xpath("//input[@name='user_first_name']"));
	}
	public WebElement getLName() {
		return this.driver.findElement(By.xpath("//input[@name='user_last_name']"));
	}	
	public WebElement getAdress() {
		return this.driver.findElement(By.xpath("//input[@name='user_address']"));
	}
	public WebElement getPhone() {
		return this.driver.findElement(By.xpath("//input[@name='user_phone']"));
	}
	public WebElement getZipCode() {
		return this.driver.findElement(By.xpath("//input[@name='user_zip']"));
	}
	public WebElement getCountry() {
		return this.driver.findElement(By.xpath("//select[@id='user_country_id']"));
	}
	public WebElement getState() {
		return this.driver.findElement(By.xpath("//select[@id='user_state_id']"));
	}
	public WebElement getCity() {
		return this.driver.findElement(By.xpath("//select[@name='user_city']"));
	}
	public WebElement getSaveBtn() {
		return this.driver.findElement(By.xpath("//form[@name='frmProfileInfo']//input[@name='btn_submit']"));
	}
	public void uploadImg() throws IOException, InterruptedException {
	executor.executeScript("arguments[0].click();", this.getProfilePicture());
	Thread.sleep(1000);
	WebElement uploadEle = driver.findElement(By.xpath("//input[@name='file']"));
	String imgPath = new File("images/Troll.jpg").getAbsolutePath();
	uploadEle.sendKeys(imgPath);
	}

	public void removeImage() {
		executor.executeScript("arguments[0].click();", this.getPictureCloseBtn());
	}
	
	public void countrySelect(String country) {
		Select select = new Select(this.getCountry());
		select.selectByVisibleText(country);
	}
	public void stateSelect(String state) {		
		Select select = new Select(this.getState());
		select.selectByVisibleText(state);
	}
	public void citySelect(String city) {
		Select select = new Select(this.getCity());
		select.selectByVisibleText(city);
	}
	
	
	
	public void updateProfile(String fName,String lName,String address,String phone,String zipCode,String country,String state,String city) throws InterruptedException {
		this.getFname().clear();
		this.getLName().clear();
		this.getAdress().clear();
		this.getPhone().clear();
		this.getZipCode().clear();
		
		this.getFname().sendKeys(fName);
		this.getLName().sendKeys(lName);
		this.getAdress().sendKeys(address);
		this.getPhone().sendKeys(phone);
		this.getZipCode().sendKeys(zipCode);		
		this.countrySelect(country);
		Thread.sleep(500);
		this.stateSelect(state);		
		this.citySelect(city);
		
		this.getSaveBtn().click();
	}
	
}

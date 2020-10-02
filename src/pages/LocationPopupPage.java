package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {

	
	
    public LocationPopupPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
		super(driver, wait, executor);
		// TODO Auto-generated constructor stub
	}
	public WebElement getCloseButton() {
    	return this.driver.findElement(By.xpath("//a[@class='close-btn close-btn-white']"));
    }
    public WebElement getLocation() {
    	return this.driver.findElement(By.xpath("//div[@class='location-selector']//a[1]"));
    }
    public WebElement getKeyword() {
    	return this.driver.findElement(By.xpath("//*[@id='locality_keyword']"));
    }
    public WebElement getLocationItem(String locationName) {
    	return this.driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
    }
    public WebElement getLocationInput() {
    	return this.driver.findElement(By.xpath("//*[@id='location_id']"));
    }
    public WebElement getSubmit() {
    	return this.driver.findElement(By.xpath("//*[@name='btn_submit']"));
    }
    public void openLocation() {
    	this.getLocation().click();
    }
    public void setLocation(String locationName) {
    	this.getKeyword().click();
    	
        String argValue = getLocationItem(locationName).getAttribute("data-value");
        String enterLocation ="arguments[0].value=arguments[1]";    	
    	executor.executeScript(enterLocation, getLocationInput(),argValue);
    	executor.executeScript("arguments[0].click();",this.getSubmit());   	   	   	
    }
    public void closePopup() {
    	this.getCloseButton().click();
    }
}

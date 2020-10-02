package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage{

	

	public AuthPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
		super(driver, wait, executor);
		// TODO Auto-generated constructor stub
	}
	public WebElement getDropdownList() {
		return this.driver.findElement(By.xpath("//header/div[2]/div[1]/div[2]/div[2]/ul[1]/li[1]/a[1]"));
	}
	public void myAccount() {
		Select select = new Select(this.getDropdownList());
		select.selectByVisibleText("Ronald Williams");
	}
	public void logOut() {
	this.getDropdownList().click();
	this.driver.findElement(By.xpath("//header/div[2]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[1]/ul[1]/li[2]/a[1]")).click();
	}
	
	public WebElement getMealsEle() {
		return this.driver.findElement(By.xpath("//header/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/a[1]"));
	}
	public void getMeals() {
		this.getMealsEle().click();
	}
	
}

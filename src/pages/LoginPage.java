package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	

	public LoginPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
		super(driver, wait, executor);
		// TODO Auto-generated constructor stub
	}
	public WebElement getEmailInput() {
		return this.driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
	}
	public WebElement getPasswordInput() {
		return this.driver.findElement(By.xpath("//input[@placeholder='Password']"));
	}
	public WebElement getSubmitBtn() {
		return this.driver.findElement(By.xpath("//input[@name='btn_submit']"));
	}
	public void logIn(String email, String password) {
		this.getEmailInput().sendKeys(Keys.CONTROL+"a");
		this.getEmailInput().sendKeys(Keys.BACK_SPACE);
		this.getEmailInput().sendKeys(email);
		this.getPasswordInput().sendKeys(Keys.CONTROL+"a");
		this.getPasswordInput().sendKeys(Keys.BACK_SPACE);
		this.getPasswordInput().sendKeys(password);
		this.getSubmitBtn().click();
	}
}

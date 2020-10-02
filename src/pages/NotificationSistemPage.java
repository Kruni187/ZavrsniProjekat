package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage {


	public NotificationSistemPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
		super(driver, wait, executor);
		// TODO Auto-generated constructor stub
	}

	public WebElement getMessageEle() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or "
				+ "contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}

	public String getMessage() {
		return getMessageEle().getText();
	}
	
	public void waitMsgDissapear() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'system_message')][contains(@style, 'display: none;')]")));
		
	}
}

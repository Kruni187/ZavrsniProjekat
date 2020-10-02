package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage {

	
	
	public CartSummaryPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
		super(driver, wait, executor);
		// TODO Auto-generated constructor stub
	}
	public WebElement getClearAllBtn() {
		return this.driver.findElement(By.xpath("//a[contains(text(),'Clear All')]"));
	}
	public void clearCart() {
		this.getClearAllBtn().click();
	}

}

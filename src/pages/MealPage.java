package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	

	public MealPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
		super(driver, wait, executor);	
	}
	public WebElement getFavoriteBtn() {
		return this.driver.findElement(By.xpath("/html[1]/body[1]/div[6]/section[1]/div[1]/div[1]/div[1]/div[1]/a[1]"));
	}
	public WebElement getAddToCartBtn() {
		return this.driver.findElement(By.xpath("//a[contains(text(),'Add To Cart')]"));
	}
	public WebElement getQuantityInput() {
		return this.driver.findElement(By.xpath("//body/div[@id='body']/section[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/ul[1]/li[3]/input[1]"));
	}
	
	public void favoriteMeal() {
		this.getFavoriteBtn().click();
	}
	public void addToCart(String qty) throws InterruptedException {
		this.getQuantityInput().sendKeys(Keys.CONTROL+"a");
		this.getQuantityInput().sendKeys(Keys.BACK_SPACE);
		this.getQuantityInput().sendKeys(qty);
		Thread.sleep(2000);
		this.getAddToCartBtn().click();
	}
}

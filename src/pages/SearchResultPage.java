package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasicPage {

	public SearchResultPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
		super(driver, wait, executor);
		// TODO Auto-generated constructor stub
	}

	/*public List<WebElement> getAllElements() {
		return this.driver.findElements(By.xpath("//*[@class='product-name']/a"));
	}
	public String getMealNames() {
		for(int i = 0;i<this.getAllElements().size();i++) {
			
		}
	}*/
}

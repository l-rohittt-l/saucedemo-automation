package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By addToCart = By.id("add-to-cart-sauce-labs-backpack");
	By cartIcon = By.className("shopping_cart_link");
	
	public void addProductToCart() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.findElement(addToCart).click();
		driver.findElement(cartIcon).click();
	}
}

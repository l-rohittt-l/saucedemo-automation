package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

public class CheckoutTest extends BaseTest {
	@Test
	public void testCompletePurchase() {
		System.out.println("Login");
		LoginPage login = new LoginPage(driver);
		login.login("standard_user", "secret_sauce");
		
		System.out.println("ProductPage");
		ProductPage product = new ProductPage(driver);
		product.addProductToCart();
		
		System.out.println("Checkout");
		CheckoutPage checkout = new CheckoutPage(driver);
		checkout.commpleteCheckout();
		
		System.out.println("Assertion");
		Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"));
		
		
	}
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class ValidLoginTest extends BaseTest {
	@Test
	public void validLogin() {
		LoginPage login = new LoginPage(driver);
		login.login("standard_user", "secret_sauce");
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory") || driver.getTitle().toLowerCase().contains("sauce"));
	}
}

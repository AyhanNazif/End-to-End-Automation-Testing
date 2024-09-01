package com.simplelearn.MovieCatalogId;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	protected String url = "http://moviecatalog-env.eba-ubyppecf.eu-north-1.elasticbeanstalk.com/User/Login";
	
	protected By EmailField = By.cssSelector("input[type='email']");
	protected By PasswordField = By.cssSelector("input[type='password']");
	protected By LoginButton = By.cssSelector("button[type='submit']");
	
	public void EnterEmail(String email) {
		
		driver.findElement(EmailField).sendKeys(email);
	}
	
	public void EnterPassword(String password) {
		
		driver.findElement(PasswordField).sendKeys(password);
	}
	
	public void ClickLoginButton() {
		WebElement loginBtn = driver.findElement(LoginButton);
		action.scrollToElement(loginBtn).perform();
		loginBtn.click();
	}
	
	public void PerformLogin(String email, String password) {
		
		EnterEmail(email);
		EnterPassword(password);
		ClickLoginButton();
	}
	
	public void Open() {
		
		driver.navigate().to(url);
	}
}

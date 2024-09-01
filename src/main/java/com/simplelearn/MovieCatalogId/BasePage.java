package com.simplelearn.MovieCatalogId;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class BasePage 
{
	protected WebDriver driver;
	protected Actions action;
	
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		action = new Actions(driver);
	}
}

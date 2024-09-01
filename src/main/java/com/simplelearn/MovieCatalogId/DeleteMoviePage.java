package com.simplelearn.MovieCatalogId;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteMoviePage extends BasePage {

	public DeleteMoviePage(WebDriver driver) {
		super(driver);
	}

	protected By YesButton = By.cssSelector("form > .mb-4 > .btn");
	
	public void ClickYesButton() {
		
		driver.findElement(YesButton).click();
	}
}

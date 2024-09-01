package com.simplelearn.MovieCatalogId;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMoviePage extends BasePage {
	
	public AddMoviePage(WebDriver driver) {
		super(driver);
	}
	
	protected String url = "http://moviecatalog-env.eba-ubyppecf.eu-north-1.elasticbeanstalk.com/Catalog/Add#add";	
	
	protected By TitleField = By.cssSelector("input[name='Title']");
	protected By DescriptionField = By.cssSelector("textarea[name='Description']");
	protected By AddEditButton = By.cssSelector("form > .mb-4 > .btn");
	protected By AddErrorMessage = By.cssSelector(".toast-message");
	
	public void Open() {
		
		driver.navigate().to(url);
	}
	
	public void EnterTitle(String title) {
		
		driver.findElement(TitleField).sendKeys(title);
	}
	
	public void ClearTitle() {
		
		driver.findElement(TitleField).clear();
	}
	
	public void EnterDescription(String description) {
		
		driver.findElement(DescriptionField).sendKeys(description);
	}
	
	public void ClearDescription() {
		
		driver.findElement(DescriptionField).clear();
	}
	
	public void ClickAddEditMovieButton() {

		WebElement addMovie = driver.findElement(AddEditButton);
		action.scrollToElement(addMovie).perform();
		addMovie.click();		
	}
	
	public String GetAddErrorMessage() {
		
		return driver.findElement(AddErrorMessage).getText();
	}
}

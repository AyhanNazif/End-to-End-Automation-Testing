package com.simplelearn.MovieCatalogId;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllMoviesPage extends BasePage {
	
	public AllMoviesPage(WebDriver driver) {
		super(driver);
	}
	
	protected String url = "http://moviecatalog-env.eba-ubyppecf.eu-north-1.elasticbeanstalk.com/Catalog/All#all";
	
	private WebElement LastAddedMovie;

	private By AllMovies = By.cssSelector(".row > .col-lg-4");
	private By LastMovieTitle = By.cssSelector(".col-lg-4 > h2");
	private By EditButton = By.linkText("Edit");
	private By DeleteButton = By.linkText("Delete");
	private By MarkAsWatchedButton = By.cssSelector(".btn-info");
	private By AllPages = By.cssSelector(".pagination > .page-item");
	
	public void Open() {
		
		driver.navigate().to(url);
	}
	
	public void GotoLastPage() {
		
		List<WebElement> ListAllPages = driver.findElements(AllPages);
		WebElement LastPage = ListAllPages.get(ListAllPages.size() - 1);
		action.scrollToElement(LastPage).perform();
		LastPage.click();
	}
	
	public WebElement FindLastAddedMovie() {
		
		List<WebElement> ListAllMoviesOnCurrentPage = driver.findElements(AllMovies);
		LastAddedMovie = ListAllMoviesOnCurrentPage.get(ListAllMoviesOnCurrentPage.size() - 1);
		
		return LastAddedMovie;
	}
	
	public String FindLastAddedMovieTitle() {

		return LastAddedMovie.findElement(LastMovieTitle).getText();
	}
	
	public void ClickEditButtonOnLastAddedMovie() {
		
		LastAddedMovie.findElement(EditButton).click();
	}

	public void ClickDeleteButtonOnLastAddedMovie() {
		
		LastAddedMovie.findElement(DeleteButton).click();
	}
	
	public String GetLastAddedMovieMarkAsButtonText() {
		
		return LastAddedMovie.findElement(MarkAsWatchedButton).getText();
	}
	
	public void ClickMarkAsButton() {
		
		LastAddedMovie.findElement(MarkAsWatchedButton).click();
	}
}


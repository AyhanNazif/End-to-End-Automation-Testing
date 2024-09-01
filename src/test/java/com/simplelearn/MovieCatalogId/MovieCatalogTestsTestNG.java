package com.simplelearn.MovieCatalogId;

import java.util.Random;

import org.testng.annotations.Test;

import org.testng.Assert;

public class MovieCatalogTestsTestNG extends BaseTest {
	
	public String randomTitle;
	public String randomDescription;
	
  @Test(priority = 1)
  public void AddMovieTest() {
	  
	Random random = new Random();
	randomTitle = "Random Title" + random.nextInt(100,999);
	randomDescription = "Random Description" + random.nextInt(100, 999);
	
	addMoviePage.Open();
	addMoviePage.EnterTitle(randomTitle);
	addMoviePage.EnterDescription(randomDescription);
	addMoviePage.ClickAddEditMovieButton();
		
	allMoviesPage.GotoLastPage();
	allMoviesPage.FindLastAddedMovie();
	
	String movieTitle = allMoviesPage.FindLastAddedMovieTitle();

	Assert.assertEquals(movieTitle.trim(), randomTitle.toUpperCase());
  }
  
  @Test(priority = 2)
  public void AddMovieWithEmptyTitleTest() {
	  	
	addMoviePage.Open();
	addMoviePage.ClearTitle();
	addMoviePage.EnterDescription(randomDescription);
	addMoviePage.ClickAddEditMovieButton();

	Assert.assertTrue(driver.getCurrentUrl().contains("Catalog/Add"));
	Assert.assertEquals(addMoviePage.GetAddErrorMessage(), "The Title field is required.");
  }
  
  @Test(priority = 3)
  public void AddMovieWithEmtpyDescriptionTest() {
	
	addMoviePage.Open();
	addMoviePage.EnterTitle(randomTitle);
	addMoviePage.ClearDescription();
	addMoviePage.ClickAddEditMovieButton();

	Assert.assertTrue(driver.getCurrentUrl().contains("Catalog/Add"));
	Assert.assertEquals(addMoviePage.GetAddErrorMessage(), "The Description field is required.");
  }

  @Test(priority = 4)
  public void EditMovieTest() {
	  
	randomTitle = "Changed " + randomTitle;
	randomDescription = "Changed " + randomDescription;
	
	allMoviesPage.Open();			
	allMoviesPage.GotoLastPage();
	allMoviesPage.FindLastAddedMovie();
	allMoviesPage.ClickEditButtonOnLastAddedMovie();
		
	editMoviePage.ClearTitle();
	editMoviePage.EnterTitle(randomTitle);
	editMoviePage.ClearDescription();
	editMoviePage.EnterDescription(randomDescription);
	editMoviePage.ClickAddEditMovieButton();
		
	allMoviesPage.GotoLastPage();
	allMoviesPage.FindLastAddedMovie();
	
	String updatedMovieTitle = allMoviesPage.FindLastAddedMovieTitle();
		
	Assert.assertEquals(updatedMovieTitle, randomTitle.toUpperCase());  
  }
  
  @Test(priority = 5)
  public void EditMovieWithEmptyTitleTest() {
		
	allMoviesPage.Open();			
	allMoviesPage.GotoLastPage();
	allMoviesPage.FindLastAddedMovie();
	allMoviesPage.ClickEditButtonOnLastAddedMovie();
		
	editMoviePage.ClearTitle();
	editMoviePage.ClearDescription();
	editMoviePage.EnterDescription(randomDescription);
	editMoviePage.ClickAddEditMovieButton();
		
	Assert.assertTrue(driver.getCurrentUrl().contains("Movie/Edit"));
	Assert.assertEquals(editMoviePage.GetAddErrorMessage(), "The Title field is required.");
  }
  
  @Test(priority = 6)
  public void EditMovieWithEmptyDescriptionTest() {
	
	allMoviesPage.Open();			
	allMoviesPage.GotoLastPage();
	allMoviesPage.FindLastAddedMovie();
	allMoviesPage.ClickEditButtonOnLastAddedMovie();
		
	editMoviePage.ClearTitle();
	editMoviePage.EnterTitle(randomTitle);
	editMoviePage.ClearDescription();
	editMoviePage.ClickAddEditMovieButton();
		
	Assert.assertTrue(driver.getCurrentUrl().contains("Movie/Edit"));
	Assert.assertEquals(editMoviePage.GetAddErrorMessage(), "The Description field is required.");
  }
  
  @Test(priority = 7)
  public void MarkLastAddedMovieAsWatchedTest() {
	  
	allMoviesPage.Open();
	allMoviesPage.GotoLastPage();
	allMoviesPage.FindLastAddedMovie();
	allMoviesPage.ClickMarkAsButton();
	allMoviesPage.GotoLastPage();
	allMoviesPage.FindLastAddedMovie();
	
	Assert.assertEquals(allMoviesPage.GetLastAddedMovieMarkAsButtonText(), "Mark as Unwatched");
	
	watchedMoviesPage.Open();
	watchedMoviesPage.GotoLastPage();
	watchedMoviesPage.FindLastAddedMovie();
	
	Assert.assertEquals(watchedMoviesPage.FindLastAddedMovieTitle(),randomTitle.toUpperCase());
  }
  
  @Test(priority = 8)
  public void MarkLastAddedMovieAsUnWatchedTest() {
	  
	allMoviesPage.Open();
	allMoviesPage.GotoLastPage();
	allMoviesPage.FindLastAddedMovie();
	allMoviesPage.ClickMarkAsButton();
	allMoviesPage.GotoLastPage();
	allMoviesPage.FindLastAddedMovie();
	
	Assert.assertEquals(allMoviesPage.GetLastAddedMovieMarkAsButtonText(), "Mark as Watched");
	
	nonWatchedMoviesPage.Open();
	nonWatchedMoviesPage.GotoLastPage();
	nonWatchedMoviesPage.FindLastAddedMovie();
	
	Assert.assertEquals(nonWatchedMoviesPage.FindLastAddedMovieTitle(),randomTitle.toUpperCase());
  }
  
  @Test(priority = 9)
  public void DeleteLastAddedMovieTest() {

	allMoviesPage.Open();
	allMoviesPage.GotoLastPage();
	allMoviesPage.FindLastAddedMovie();
	allMoviesPage.ClickDeleteButtonOnLastAddedMovie();
	deleteMoviePage.ClickYesButton();
	allMoviesPage.GotoLastPage();
	allMoviesPage.FindLastAddedMovie();

	String lastMovie = allMoviesPage.FindLastAddedMovieTitle();
	
	Assert.assertNotEquals(lastMovie, randomTitle);
  }
}

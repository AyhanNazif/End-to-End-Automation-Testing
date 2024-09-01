package com.simplelearn.MovieCatalogId;

import org.openqa.selenium.WebDriver;

public class NonWatchedMoviesPage extends AllMoviesPage {

	public NonWatchedMoviesPage(WebDriver driver) {
		super(driver);
	}

	protected String url = "http://moviecatalog-env.eba-ubyppecf.eu-north-1.elasticbeanstalk.com/Catalog/NonWatched#unwatched";
	
	@Override public void Open() {
		
		driver.navigate().to(url);
	}
}

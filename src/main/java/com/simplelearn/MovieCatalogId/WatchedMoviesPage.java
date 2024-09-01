package com.simplelearn.MovieCatalogId;

import org.openqa.selenium.WebDriver;

public class WatchedMoviesPage extends AllMoviesPage {

	public WatchedMoviesPage(WebDriver driver) {
		super(driver);
	}
	
	protected String url = "http://moviecatalog-env.eba-ubyppecf.eu-north-1.elasticbeanstalk.com/Catalog/Watched#watched";
	
	@Override public void Open() {
		
		driver.navigate().to(url);
	}
}

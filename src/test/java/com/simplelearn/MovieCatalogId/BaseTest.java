package com.simplelearn.MovieCatalogId;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest 
{
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected AddMoviePage addMoviePage;
	protected AllMoviesPage allMoviesPage;
	protected EditMoviePage editMoviePage;
	protected DeleteMoviePage deleteMoviePage;
	protected WatchedMoviesPage watchedMoviesPage;
	protected NonWatchedMoviesPage nonWatchedMoviesPage;
	
	@BeforeTest
	public void SetUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0xid\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-search-engine-choice-screen");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		loginPage = new LoginPage(driver);
		addMoviePage = new AddMoviePage(driver);
		allMoviesPage = new AllMoviesPage(driver);
		editMoviePage = new EditMoviePage(driver);
		deleteMoviePage = new DeleteMoviePage(driver);
		watchedMoviesPage = new WatchedMoviesPage(driver);
		nonWatchedMoviesPage = new NonWatchedMoviesPage(driver);

		loginPage.Open();
		loginPage.PerformLogin("guardian@abv.bg", "ignore");
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
}

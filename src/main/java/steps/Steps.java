package steps;

import Pages.HomePage;
import Pages.SearchPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static io.netty.util.internal.SystemPropertyUtil.contains;


public class Steps {

    public WebDriver driver;
    public String URL = "https://www.bookdepository.com/";
//    WebElement acceptCoockiesbtn = driver.findElement(By.xpath("//button[@class='btn btn-sm btn-yes']"));


    @Given("I am an anonymous customer with clear cookies")
    public void clearCookies() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\Coursework\\src\\main\\resources\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

//        Selenide.clearBrowserCookies();
//        WebDriverManager.chromedriver().setup();
//        Configuration.browser = "chrome";
//        Configuration.browserSize = "1920x1080";
//        Configuration.headless = false;
//        Selenide.open(URL);
    }

    @And("I open the {string}")
    public void openWebSite(String arg0) {
        driver.get(URL);
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//
//        acceptCoockiesbtn.click();

    }


    @And("I search for {string}")
    public void iSearchFor(String arg0) {
        HomePage homePage = new HomePage(driver);
        homePage.goToSearchPage();

    }

    @And("I am redirected to a {string}")
    public void searchPage(String arg0) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.redirectedToSP();

    }

    @And("Search result contains the following products")
    public void searchResult(List<String> list) {
    List<WebElement> books = driver.findElements(By.xpath("//h3[@class='title']/a"));

    List<String> listOfBooks = books.stream().map(WebElement::getText).collect(Collectors.toList());

    for(String el : list){
        Assertions.assertEquals(true, listOfBooks.contains(el));
    }
    }

    @And("I apply the following search filters")
    public void searchFilters() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchFilter();
    }

    @And("Search results contain only the following products")
    public void searchResultsContainOnlyTheFollowingProducts(List<String> list) {
        List<WebElement> books2 = driver.findElements(By.xpath("//h3[@class='title']/a"));

        List<String> listOfBooks = books2.stream().map(WebElement::getText).collect(Collectors.toList());
        for(String el : list){
            Assertions.assertEquals(true, listOfBooks.contains(el));
        }

    }
}

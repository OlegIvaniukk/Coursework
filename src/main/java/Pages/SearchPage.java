package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends ConfigPage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    String expectedSearchUrl = "https://www.bookdepository.com/search?searchTerm=Thinking+in+Java&search=Find+book";
    String actualSearchUrl = driver.getCurrentUrl();
//    String expectedBook1 = "Thinking in Java";
//    String expectedBook2 = "Think Java";
//    String expectedBook3 = "Thinking Java part 1";
//
    WebElement actualBook1 = driver.findElement(By.xpath("/html/body/div[3]/div[6]/div[5]/div[4]/div/div/div/div/div[1]/div[2]/h3/a"));
    WebElement actualBook2 = driver.findElement(By.xpath("/html/body/div[3]/div[6]/div[5]/div[4]/div/div/div/div/div[2]/div[2]/h3/a"));
    WebElement actualBook3 = driver.findElement(By.xpath("/html/body/div[3]/div[6]/div[5]/div[4]/div/div/div/div/div[3]/div[2]/h3/a"));
    WebElement priseRangeField = driver.findElement(By.id("filterPrice"));

    WebElement priseOver30 = driver.findElement(By.xpath("//option[@value='high']"));

    WebElement availabilityField = driver.findElement(By.id("filterAvailability"));

    WebElement inStock = driver.findElement(By.xpath("//*[@id=\"filterAvailability\"]/option[2]"));

    WebElement languageField = driver.findElement(By.id("filterLang"));

    WebElement languageValue = driver.findElement(By.xpath("//option[@value='123']"));

    WebElement formatField = driver.findElement(By.id("filterFormat"));
    WebElement formatValue = driver.findElement(By.xpath("//*[@id=\"filterFormat\"]/option[2]"));
    WebElement primaryButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));

    public SearchPage redirectedToSP(){
        Assertions.assertEquals(expectedSearchUrl, actualSearchUrl);
        return new SearchPage(driver);
    }
//    public void searchResultContains(){
//        List<String> expectedBookList = new ArrayList<>();
//        expectedBookList.add(expectedBook1);
//        expectedBookList.add(expectedBook2);
//        expectedBookList.add(expectedBook3);
//
//        List<String> actuallBookList = new ArrayList<>();
//        actuallBookList.add(actualBook1.toString());
//        actuallBookList.add(actualBook2.toString());
//        actuallBookList.add(actualBook3.toString());
//        Assertions.assertEquals(expectedBookList, actuallBookList);
//
//    }
    public SearchResutPage searchFilter(){
        priseRangeField.click();
        priseOver30.click();
        availabilityField.click();
        inStock.click();
        languageField.click();
        languageValue.click();
        formatField.click();
        formatValue.click();
        primaryButton.click();
        return new SearchResutPage(driver);
    }

}

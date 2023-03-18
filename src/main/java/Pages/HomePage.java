package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends ConfigPage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private final WebElement inputField = driver.findElement(By.xpath("//input[@type='text']"));

    private final WebElement searchButton = driver.findElement(By.xpath("//span[@class='text']"));


   public SearchPage goToSearchPage(){
       inputField.sendKeys("Thinking in Java");
       searchButton.click();
       return new SearchPage(driver);
   }


}

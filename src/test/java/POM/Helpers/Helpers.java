package POM.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {
    public void waitElementDisplayed(WebDriver driver, int timeToWait, By targetElement){
        new WebDriverWait(driver, timeToWait).until(d -> (driver.findElement(targetElement).isDisplayed()));
    }
    public void waitElementToBeVisible(WebDriver driver, int timeToWait, By targetElement){
        new WebDriverWait(driver, timeToWait).until(ExpectedConditions.visibilityOfElementLocated(targetElement));
    }
}

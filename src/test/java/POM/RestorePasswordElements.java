package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordElements extends TestFixtures{
    private By emailInput = By.name("name");
    private By restoreButton = By.xpath("//button[contains(text(),'Восстановить')]");
    private By loginLink = By.xpath("//a[contains(text(),'Войти')]");

    public RestorePasswordElements(WebDriver driver) {
        this.driver = driver;
    }


    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

}

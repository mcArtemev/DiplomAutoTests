package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorElements extends TestFixtures {

    private By constructorContainer = By.xpath("//main[contains(@class,'App_componentContainer')]");
    private By enterInAccount = By.xpath("//section[2]/div/button");
    private By bunsTab = By.xpath("//section[1]/div[1]/div[1]");
    private By saucesTab = By.xpath("//section[1]/div[1]/div[2]");
    private By fillingsTab = By.xpath("//section[1]/div[1]/div[3]");
    private By bunsSection = By.xpath("//h2[contains(text(),'Булки')]");
    private By saucesSection = By.xpath("//h2[contains(text(),'Соусы')]");
    private By fillingsSection = By.xpath("//h2[contains(text(),'Начинки')]");

    public ConstructorElements(WebDriver driver) {
        this.driver = driver;
    }

    public By getBunsTab() {
        return bunsTab;
    }

    public By getSaucesTab() {
        return saucesTab;
    }

    public By getFillingsTab() {
        return fillingsTab;
    }


    public By getBunsSection() {
        return bunsSection;
    }

    public By getSaucesSection() {
        return saucesSection;
    }

    public By getFillingsSection() {
        return fillingsSection;
    }
    public void clickTab(By tab){
        driver.findElement(tab).click();
    }

    public void clickEnterInAccount() {
        driver.findElement(enterInAccount).click();

    }
    public By getConstructorContainer() {
        return constructorContainer;
    }
}

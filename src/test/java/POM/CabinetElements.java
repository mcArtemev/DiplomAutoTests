package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CabinetElements extends TestFixtures {

    private By nameInput = By.xpath("//input[contains(@name,'Name')]");
    private By loginInput = By.xpath("//input[contains(@name,'name')][1]");
    private By logoutButton = By.xpath("//nav/ul/li[3]/button");

    private By cabinetData = By.xpath("//div[contains(@class,'Account_account')]");
    public By getCabinetData() {
        return cabinetData;
    }
    public void clickLogoutButton(){
        driver.findElement(logoutButton).click();
    }

    public String getUserName(){
       return driver.findElement(nameInput).getAttribute("value");
    }
    public String getUserLogin(){
        return driver.findElement(loginInput).getAttribute("value");
    }
    public CabinetElements(WebDriver driver) {
        this.driver = driver;
    }

}

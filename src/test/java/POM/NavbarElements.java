package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavbarElements extends TestFixtures{

    private By navbar = By.xpath("//nav[contains(@class,'AppHeader_header')]");
    private By constructorButton = By.xpath("//*[contains(text(),'Конструктор')]");
    private By cabinetButton = By.xpath("//*[contains(text(),'Личный Кабинет')]");
    private By logo = By.xpath("//div[contains(@class,'AppHeader_header__logo')]");

    public NavbarElements(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }
    public void clickCabinetButton(){
        driver.findElement(cabinetButton).click();
    }

    public void clickLogo(){
        driver.findElement(logo).click();
    }

}

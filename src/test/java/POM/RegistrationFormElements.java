package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class RegistrationFormElements extends TestFixtures{
    private By registrationForm = By.xpath("//div[contains(@class,'Auth_login')]//h2[contains(text(),'Регистрация')]");
    private By nameInput = By.xpath("//fieldset[1]/div/div/input");
    private By emailInput = By.xpath("//fieldset[2]/div/div/input");
    private By passwordInput = By.name("Пароль");
    private By signUpButton = By.xpath("//button[contains(text(),'Зарегистрироваться')]");
    private By loginLink = By.xpath("//a[contains(text(),'Войти')]");
    private By errorMessage = By.xpath("//p[contains(@class,'input__error')]");
    public RegistrationFormElements(WebDriver driver) {
        this.driver = driver;
    }

    public By getRegistrationForm() {
        return registrationForm;
    }

    public void completeRegistrationForm(String name, String email, String password){
        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);

        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);

        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public String clickSignUpButton(){
        driver.findElement(signUpButton).click();
        try {
            return driver.findElement(errorMessage).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}

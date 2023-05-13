package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginFormElements extends TestFixtures{
    private By loginForm = By.xpath("//div[contains(@class,'Auth_login')]//h2[contains(text(),'Вход')]");
    private By emailInput = By.name("name");
    private By passwordInput = By.name("Пароль");
    private By loginButton = By.xpath("//button[contains(text(),'Войти')]");
    private By signUpLink = By.xpath("//a[contains(text(),'Зарегистрироваться') and contains(@class, 'Auth_link')]");
    private By restorePasswordLink = By.xpath("//a[contains(text(),'Восстановить пароль')]");
    private By errorMessage = By.xpath("//p[contains(@class,'input__error')]");

    private String errorText;
    public LoginFormElements(WebDriver driver) {
        this.driver = driver;
    }

    public By getLoginForm() {
        return loginForm;
    }

    public void completeLoginForm(String email, String password){
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);

        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public String clickLoginButton(){
        driver.findElement(loginButton).click();
        try {
            return driver.findElement(errorMessage).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void clickSignUpLink() {
        driver.findElement(signUpLink).click();
    }

    public void clickRestorePasswordLink() {
        driver.findElement(restorePasswordLink).click();
    }
}

import POM.*;
import POM.Helpers.APICalls;
import POM.Helpers.Helpers;
import POM.Helpers.UserSerializer;
import org.junit.Assert;
import org.junit.Test;

public class PrivateCabinetTests extends TestFixtures {
    NavbarElements navbarElements = new NavbarElements(driver);
    LoginFormElements loginFormElements = new LoginFormElements(driver);
    ConstructorElements constructorElements = new ConstructorElements(driver);
    APICalls apiCalls = new APICalls();
    Helpers helpers = new Helpers();
    CabinetElements cabinetElements = new CabinetElements(driver);


    @Test
    public void EnterInPrivateCabinet() {
        name = "example";
        email = "example@example.com";
        password = "123456";
        apiCalls.createUser(new UserSerializer(name, email, password));
        isUserCreated = apiCalls.checkCreatedUser(new UserSerializer(email, password));

        navbarElements.clickCabinetButton();
        loginFormElements.completeLoginForm(email, password);
        loginFormElements.clickLoginButton();
        navbarElements.clickCabinetButton();
        helpers.waitElementDisplayed(driver, 5, cabinetElements.getCabinetData());
        Assert.assertTrue(cabinetElements.getUserName().equals(name));
        Assert.assertTrue(cabinetElements.getUserLogin().equals(email));

    }

    @Test
    public void LogoutFromPrivateCabinet() {
        name = "example";
        email = "example@example.com";
        password = "123456";
        apiCalls.createUser(new UserSerializer(name, email, password));
        isUserCreated = apiCalls.checkCreatedUser(new UserSerializer(email, password));

        navbarElements.clickCabinetButton();
        loginFormElements.completeLoginForm(email, password);
        loginFormElements.clickLoginButton();
        navbarElements.clickCabinetButton();
        helpers.waitElementDisplayed(driver, 5, cabinetElements.getCabinetData());
        cabinetElements.clickLogoutButton();
        helpers.waitElementDisplayed(driver, 5, loginFormElements.getLoginForm());
        navbarElements.clickCabinetButton();
        Assert.assertTrue(driver.findElement(loginFormElements.getLoginForm()).isDisplayed());
    }

    @Test
    public void OpenContsructorFromPrivateCabinetWithButton() {
        name = "example";
        email = "example@example.com";
        password = "123456";
        apiCalls.createUser(new UserSerializer(name, email, password));
        isUserCreated = apiCalls.checkCreatedUser(new UserSerializer(email, password));

        navbarElements.clickCabinetButton();
        loginFormElements.completeLoginForm(email, password);
        loginFormElements.clickLoginButton();
        navbarElements.clickCabinetButton();
        helpers.waitElementDisplayed(driver, 5, cabinetElements.getCabinetData());
        navbarElements.clickConstructorButton();
        Assert.assertTrue(driver.findElement(constructorElements.getConstructorContainer()).isDisplayed());
    }

    @Test
    public void OpenContsructorFromPrivateCabinetWithLogo() {
        name = "example";
        email = "example@example.com";
        password = "123456";
        apiCalls.createUser(new UserSerializer(name, email, password));
        isUserCreated = apiCalls.checkCreatedUser(new UserSerializer(email, password));

        navbarElements.clickCabinetButton();
        loginFormElements.completeLoginForm(email, password);
        loginFormElements.clickLoginButton();
        navbarElements.clickCabinetButton();
        helpers.waitElementDisplayed(driver, 5, cabinetElements.getCabinetData());
        navbarElements.clickLogo();
        Assert.assertTrue(driver.findElement(constructorElements.getConstructorContainer()).isDisplayed());
    }


}

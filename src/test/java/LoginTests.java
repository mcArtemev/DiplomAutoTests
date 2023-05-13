import POM.*;
import POM.Helpers.APICalls;
import POM.Helpers.Helpers;
import POM.Helpers.UserSerializer;
import org.junit.Assert;
import org.junit.Test;

// Чисто в теории, я бы написал эти кейсы с помощью параметризации.
// Но для этого надо красиво переписать Элементы страниц.
// Особенно красиво было бы сделать динамическое отслеживание URL и полей на странице.
// Тогда будет чисто 1 класс FormElements
// Но времени мало для этого. Поэтому все так, как у Толстого - много про дуб)))
public class LoginTests extends TestFixtures {
    ConstructorElements constructorElements = new ConstructorElements(driver);
    LoginFormElements loginFormElements = new LoginFormElements(driver);
    NavbarElements navbarElements = new NavbarElements(driver);
    CabinetElements cabinetElements = new CabinetElements(driver);
    RestorePasswordElements restorePasswordElements = new RestorePasswordElements(driver);
    RegistrationFormElements registrationFormElements = new RegistrationFormElements(driver);
    Helpers helpers = new Helpers();
    APICalls apiCalls = new APICalls();

    @Test
    public void enterInAccountFromConstructorPageEnterInAccountButton(){
        name = "example";
        email = "example@example.com";
        password = "123456";
        apiCalls.createUser(new UserSerializer(name, email, password));
        isUserCreated = apiCalls.checkCreatedUser(new UserSerializer(email, password));

        constructorElements.clickEnterInAccount();
        loginFormElements.completeLoginForm(email, password);
        loginFormElements.clickLoginButton();
        navbarElements.clickCabinetButton();
        helpers.waitElementDisplayed(driver, 5, cabinetElements.getCabinetData());
        Assert.assertTrue(cabinetElements.getUserName().equals(name));
        Assert.assertTrue(cabinetElements.getUserLogin().equals(email));
    }

    @Test
    public void enterInAccountFromNavbarPrivateCabinet(){
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
    public void enterInAccountFromRegistrationFormLinkSingIn(){
        name = "example";
        email = "example@example.com";
        password = "123456";
        apiCalls.createUser(new UserSerializer(name, email, password));
        isUserCreated = apiCalls.checkCreatedUser(new UserSerializer(email, password));

        navbarElements.clickCabinetButton();
        loginFormElements.clickSignUpLink();
        registrationFormElements.clickLoginLink();

        loginFormElements.completeLoginForm(email, password);
        loginFormElements.clickLoginButton();
        navbarElements.clickCabinetButton();
        helpers.waitElementDisplayed(driver, 5, cabinetElements.getCabinetData());
        Assert.assertTrue(cabinetElements.getUserName().equals(name));
        Assert.assertTrue(cabinetElements.getUserLogin().equals(email));
    }

    @Test
    public void enterInAccountFromRestorePasswordLinkSingIn(){
        name = "example";
        email = "example@example.com";
        password = "123456";
        apiCalls.createUser(new UserSerializer(name, email, password));
        isUserCreated = apiCalls.checkCreatedUser(new UserSerializer(email, password));

        navbarElements.clickCabinetButton();
        loginFormElements.clickRestorePasswordLink();
        restorePasswordElements.clickLoginLink();

        loginFormElements.completeLoginForm(email, password);
        loginFormElements.clickLoginButton();
        navbarElements.clickCabinetButton();
        helpers.waitElementDisplayed(driver, 5, cabinetElements.getCabinetData());
        Assert.assertTrue(cabinetElements.getUserName().equals(name));
        Assert.assertTrue(cabinetElements.getUserLogin().equals(email));
    }
}

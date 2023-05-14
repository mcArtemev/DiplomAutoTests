import POM.*;
import POM.Helpers.APICalls;
import POM.Helpers.UserSerializer;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationTests extends TestFixtures {
    private NavbarElements navbarElements = new NavbarElements(driver);
    private LoginFormElements loginFormElements = new LoginFormElements(driver);
    private RegistrationFormElements registrationFormElements= new RegistrationFormElements(driver);
    private APICalls apiCalls = new APICalls();

    @Test
    public void registrateNewUserWithCorrectData() throws InterruptedException {
        name = "example";
        email = "example@example.com";
        password = "123456";
        navbarElements.clickCabinetButton();
        loginFormElements.clickSignUpLink();
        registrationFormElements.completeRegistrationForm(name, email, password);
        registrationFormElements.clickSignUpButton();
        // Я пытался всячески обработать ожидание создание пользователя.
        // При запуске всех тестов в данном классе - все норм проходит.
        // А при запуске отчета Allure - падает на 401 для метода checkCreatedUser. Там какая то задержка с фронта
        // Знаю что такие наглые слипы не очень хорошо делать
        Thread.sleep(1000);

        isUserCreated = apiCalls.checkCreatedUser(new UserSerializer(email, password));
        Assert.assertTrue(isUserCreated==true);
    }

    @Test
    public void registrateNewUserWithIncorrectPasswordLength3(){
        name = "example";
        email = "example@example.com";
        password = "123";
        navbarElements.clickCabinetButton();
        loginFormElements.clickSignUpLink();
        registrationFormElements.completeRegistrationForm(name, email, password);
        String errorMessage = registrationFormElements.clickSignUpButton();
        Assert.assertTrue(errorMessage.equals("Некорректный пароль"));
    }
}

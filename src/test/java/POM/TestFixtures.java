package POM;

import POM.Helpers.APICalls;
import POM.Helpers.UserDeserializer;
import POM.Helpers.UserSerializer;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestFixtures {
    public static WebDriver driver;
    APICalls apiCalls = new APICalls();
    public Response createdUserData;
    public boolean isUserCreated;
    public String name;
    public String email;
    public String password;

    @Before
    public void setUpFixture(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("disable-gpu");
        driver = new ChromeDriver(chromeOptions);
        driver.get(BaseData.baseURI);
    }
    @After
    public void tearDownFixture(){
        if(isUserCreated) {
            createdUserData = apiCalls.loginUser(new UserSerializer(email, password));
            apiCalls.deleteUser(createdUserData.as(UserDeserializer.class).getAccessToken());
        }
        driver.quit();
    }
}

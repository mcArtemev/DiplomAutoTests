import POM.ConstructorElements;
import POM.Helpers.Helpers;
import POM.TestFixtures;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;

@RunWith(Parameterized.class)
public class ConstructorTests extends TestFixtures {
    static ConstructorElements constructorElements = new ConstructorElements(driver);
    Helpers helpers = new Helpers();
    private By ingredientTab;
    private By ingredientHeader;

    public ConstructorTests(By ingredientTab, By ingredientHeader) {
        this.ingredientTab=ingredientTab;
        this.ingredientHeader=ingredientHeader;
    }

    @Parameterized.Parameters(name = "Для вкладки: {0}, ингредиенты: {1}")
    public static Object[][] openTabExpectHeader(){
        return new Object[][] {
                {constructorElements.getSaucesTab(),constructorElements.getSaucesSection()},
                {constructorElements.getFillingsTab(),constructorElements.getFillingsSection()},
                {constructorElements.getBunsTab(),constructorElements.getBunsSection()},
        };
    }
    @Test
    public void openIngredientTabCheckIngredientSection(){
        try {
            constructorElements.clickTab(ingredientTab);
            helpers.waitElementToBeVisible(driver, 2, ingredientHeader);
            Assert.assertTrue(driver.findElement(ingredientHeader).isDisplayed());
        } catch (ElementClickInterceptedException e) {
            Assert.assertTrue(driver.findElement(ingredientHeader).isDisplayed());
        }
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;
import static org.testng.Assert.assertEquals;
public class AddRemoveElements {
    private WebDriver browser;
    @BeforeTest
    public void driverSetup() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        browser.quit();
    }
    @Test
    public void addRemoveElementsTest() {
        browser.get("http://the-internet.herokuapp.com/add_remove_elements/");
        By addManually = (By.xpath("//button[text()='Add Element']"));
        browser.findElement(addManually).click();
        browser.findElement(addManually).click();
        browser.findElement(By.className("added-manually")).click();
        int deletedButtonsQuantity = browser.findElements(By.xpath("//button[text()='Delete']")).size();
        assertEquals(deletedButtonsQuantity, 1, "One button is remaining");
    }
}

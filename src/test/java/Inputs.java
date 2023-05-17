import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;
import static org.testng.AssertJUnit.assertEquals;
public class Inputs {
    private WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void inputsTest() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        String upKeyResult = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals(upKeyResult, "1");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
        String downKeyResult = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals(downKeyResult, "-3");
        driver.navigate().refresh();
        driver.findElement(By.tagName("input")).sendKeys("www");
        String alphaResult = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals(alphaResult, "");
        driver.navigate().refresh();
        driver.findElement(By.tagName("input")).sendKeys("12");
        String numericResult = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals(numericResult, "12");
    }
}
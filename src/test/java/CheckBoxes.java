import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.List;
import static org.testng.Assert.assertEquals;
import java.time.Duration;

public class CheckBoxes {
    private static final String URL="http://the-internet.herokuapp.com/checkboxes";
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        @AfterMethod(alwaysRun = true)
        public void tearDown() {

        }

    @Test
    public void checkBoxesTest() {
        By checkboxes = By.tagName("input");
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        assertEquals(checkBoxes.get(0).isSelected(), false, "the 1st checkbox is unchecked");
        checkBoxes.get(0).click();
        assertEquals(checkBoxes.get(0).isSelected(), true, "the 1st checkbox is checked");
        assertEquals(checkBoxes.get(1).isSelected(), true, "the 2nd checkbox is checked");
        checkBoxes.get(1).click();
        assertEquals(checkBoxes.get(1).isSelected(), false, "the 2nd checkbox is unchecked");
    }
}
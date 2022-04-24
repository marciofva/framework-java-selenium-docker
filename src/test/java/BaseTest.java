import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import com.typesafe.config.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseTest {

    protected static Config config = EnvFactory.getInstance().getConfig();
    protected static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    protected WebDriver driver = DriverFactory.getDriver();

    @BeforeEach
    public void setUp(){
        driver.get(HOME_PAGE_URL);
        assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, " +
                "Shoes and More - Amazon.in", driver.getTitle());
    }

    @AfterEach
    public void tearDown(){
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            driver.close();
        }
    }
}

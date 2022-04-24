package amazon.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    private static final int MAX_SECONDS_TIMEOUT = 20;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_SECONDS_TIMEOUT));
    }

    protected void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected List<WebElement> getAllElements(List<WebElement> elements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    protected WebElement getElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void scrollByElement(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void selectOptionComboBoxByText(WebElement element, String textSelect) {
        Select comboBox = new Select(element);
        comboBox.selectByVisibleText(textSelect);
    }

    protected boolean isVisible(WebElement... elements) {
        for (WebElement element : elements) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
            } catch (TimeoutException e) {
                return false;
            }
        }
        return true;
    }

    protected void waitForTitle(String title) {
        wait.until(ExpectedConditions.titleContains(title));
    }
}

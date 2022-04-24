package amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ProductDetailsPage extends BasePage {

    @FindBy(css = "h1[class='a-size-base-plus a-text-bold']")
    private WebElement aboutThisLabel;

    @FindBy(css = "ul[class='a-unordered-list a-vertical a-spacing-mini'] li")
    private List<WebElement> productDetailsLog;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isVisible() {
        if(isVisible(aboutThisLabel)) logDetails();
        return isVisible(aboutThisLabel);
    }

    public void logDetails() {
        System.out.println("\n---------------------------------------------------------------------------------");
        for(WebElement element : getAllElements(productDetailsLog)) {
            System.out.println(element.getText());
        }
        System.out.println("---------------------------------------------------------------------------------\n");
    }
}

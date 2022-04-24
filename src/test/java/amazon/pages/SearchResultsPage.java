package amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(id = "s-result-sort-select")
    private WebElement sortByDropdown;

    @FindBy(css = "a[class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")
    private List<WebElement> ListOfResults;

    private String selectedItemDescription = "";

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void sortProducts(String sortByText) {
        selectOptionComboBoxByText(getElement(sortByDropdown), sortByText);
    }

    public ProductDetailsPage pickProductFromDisplayedResults(String sortByText, int index) {
        sortProducts(sortByText);
        clickOnProductInListOfResults(index);
        switchScreenToProductDetails();
        return new ProductDetailsPage(driver);
    }

    private void clickOnProductInListOfResults(int index) {
        selectedItemDescription = getAllElements(ListOfResults).get(index).getText();
        ListOfResults.get(index).click();
    }

    public SearchResultsPage switchScreenToProductDetails() {
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));
        waitForTitle(selectedItemDescription);
        return this;
    }
}

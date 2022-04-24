package amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "nav-hamburger-menu")
    private WebElement burguerMenuLink;

    @FindBy(css = "ul.hmenu.hmenu-visible li a")
    private List<WebElement> mainMenuItens;

    @FindBy(css = "li.a-spacing-micro a")
    private List<WebElement> refinementFilter;

    @FindBy(css = "div.s-main-slot.s-result-list.s-search-results.sg-row")
    private WebElement resultTable;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void OpenBurguerMenu() {
        getElement(burguerMenuLink).click();
    }

    public SearchResultsPage selectItemsByBurguerMenu(String category, String item, List<String> filter) {
        OpenBurguerMenu();
        clickOnItemByDescription(category);
        clickOnItemByDescription(item);
        checkFilters(filter);
        return new SearchResultsPage(driver);
    }

    public void clickOnItemByDescription(String text) {
        for(WebElement element : mainMenuItens) {
            if (element.getText().equalsIgnoreCase(text)){
                clickElement(element);
                break;
            }
        }
    }

    public void checkFilters(List<String> ListOfFilters) {
        for(String item: ListOfFilters) {
            for(WebElement element: getAllElements(refinementFilter)) {
                if (item.equalsIgnoreCase(element.getText())) {
                    scrollByElement(element);
                    clickElement(element);
                    getElement(resultTable);
                    break;
                }
            }
        }
    }
}

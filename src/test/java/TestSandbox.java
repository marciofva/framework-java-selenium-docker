import amazon.pages.HomePage;
import amazon.data.ScenariosForShopping;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSandbox extends BaseTest {

    @Tag("smokeTest")
    @DisplayName("This test is for viewing the product details")
    @ParameterizedTest
    @EnumSource(ScenariosForShopping.class)
    void assertThatProductDetailIsVisible(ScenariosForShopping prod) {
       assertTrue(new HomePage(driver)
               .selectItemsByBurguerMenu(prod.getCategory(), prod.getSubItem(), prod.getFilter())
               .pickProductFromDisplayedResults(prod.getSortedBy(), 1)
               .isVisible());
    }
}

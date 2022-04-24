package amazon.data;

import amazon.productItens.Brands;
import amazon.productItens.Category;
import amazon.productItens.SortedBy;
import amazon.productItens.SubItem;
import amazon.productItens.Years;

import java.util.Arrays;
import java.util.List;

public enum ScenariosForShopping {

    /**
     * -----------------------------------------------------------------------------
     *                                Template
     * -----------------------------------------------------------------------------
     * - Category: Description to select on the burguer (main menu)
     * - SubItem: Description to select the sub-item on menu
     * - Filter: Contain the types of filters to be checked
     * - Sort By: Contain the type of sorting to list the products
     * -----------------------------------------------------------------------------
     */

    TV_WITH_ONE_BRAND(
            Category.ELECTRONICS.getValue(),
            SubItem.TELEVISIONS.getValue(),
            Arrays.asList(Brands.SAMSUNG.getValue()),
            SortedBy.HIGH_TO_LOW.getValue()),

    TV_WITH_MULTIPLE_BRANDS(
            Category.ELECTRONICS.getValue(),
            SubItem.TELEVISIONS.getValue(),
            Arrays.asList(Brands.SAMSUNG.getValue(), Brands.ONEPLUS.getValue(), Years.YEAR_2022.getValue()),
            SortedBy.LOW_TO_HIGH.getValue()),

    MOBILE_WITH_MULTIPLE_BRANDS(
            Category.MOBILE_COMPUTERS.getValue(),
            SubItem.ALL_PHONES.getValue(),
            Arrays.asList(Brands.ONEPLUS.getValue(), Brands.APPLE.getValue(), Brands.SAMSUNG.getValue()),
            SortedBy.AVG_CUSTOMER_REVIEW.getValue());

    private String category;
    private String subItem;
    private List<String> filter;
    private String sortedBy;

    ScenariosForShopping(String category, String subItem, List<String> filter, String sortedBy){
        this.category = category;
        this.subItem = subItem;
        this.filter = filter;
        this.sortedBy = sortedBy;
    }

    public String getCategory() {
        return category;
    }

    public String getSubItem() {
        return subItem;
    }

    public List<String> getFilter() {
        return filter;
    }

    public String getSortedBy() {
        return sortedBy;
    }
}



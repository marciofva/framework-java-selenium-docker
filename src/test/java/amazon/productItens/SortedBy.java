package amazon.productItens;

public enum SortedBy {

    LOW_TO_HIGH("Price: Low to High"),
    HIGH_TO_LOW("Price: High to Low"),
    AVG_CUSTOMER_REVIEW("Avg. Customer Review"),
    NEWEST_ARRIVALS("Newest Arrivals");

    private String value;

    SortedBy(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

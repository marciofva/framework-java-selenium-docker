package amazon.productItens;

public enum SubItem {

    TELEVISIONS("Televisions"),
    ALL_PHONES("All Mobile Phones"),
    HOME_ENTERTAINMENT("Home Entertainment Systems"),
    HEADPHONES("Headphones"),
    SPEAKERS("Speakers");

    private String value;

    SubItem(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

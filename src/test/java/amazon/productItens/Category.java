package amazon.productItens;

public enum Category {

    MOBILE_COMPUTERS("Mobiles, Computers"),
    ELECTRONICS("TV, Appliances, Electronics"),
    MEN_FASHION("Men's Fashion");

    private String value;

    Category(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}



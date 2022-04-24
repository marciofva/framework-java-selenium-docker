package amazon.productItens;

public enum Brands {

    ONEPLUS("OnePlus"),
    SAMSUNG("Samsung"),
    APPLE("Apple"),
    ACER("Acer");

    private String value;

    Brands(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

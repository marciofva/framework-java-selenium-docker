package amazon.productItens;

public enum Years {

    YEAR_2020("2020"),
    YEAR_2021("2021"),
    YEAR_2022("2022");

    private String value;

    Years(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

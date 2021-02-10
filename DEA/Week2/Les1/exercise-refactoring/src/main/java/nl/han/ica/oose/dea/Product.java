package nl.han.ica.oose.dea;

public class Product {
    private String code;
    private int color;
    private int size;
    public final int SIZE_NOT_VALID = -1;
    private double price;
    private String currency;

    public Product(String code, int color, int size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public int getColor() {
        return color;
    }

    public String getColorString() {
        switch (this.getColor()) {
            case 1:
                return "blue";
            case 2:
                return "red";
            case 3:
                return "yellow";
            default:
                return "no color";
        }
    }

    public int getSize() {
        return size;
    }

    public String getSizeString() {
        switch (this.getSize()) {
            case 1:
                return "XS";
            case 2:
                return "S";
            case 3:
                return "M";
            case 4:
                return "L";
            case 5:
                return "XL";
            case 6:
                return "XXL";
            default:
                return "Invalid Size";
        }
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}

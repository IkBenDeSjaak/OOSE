package nl.han.ica.oose.dea.helpers;

import static nl.han.ica.oose.dea.helpers.ProductCategory.GADGETS;

public class Product {
    private String name;
    private int price;
    private ProductCategory category;

    public Product(String name, int price) {
        this(name, price, GADGETS);
    }

    public Product(String name, int price, ProductCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public ProductCategory getCategory() { return category; }

}

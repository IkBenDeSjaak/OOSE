package nl.han.ica.oose.dea.domain;

public class Item {
    public static final int UNKNOWN = -1;

    private int id;
    private String sku;
    private String category;
    private String title;

    public Item(){}

    public Item(int id, String sku, String category, String title) {
        this.id = id;
        this.sku = sku;
        this.category = category;
        this.title = title;
    }

    public Item(String sku, String category, String title) {
        this(UNKNOWN, sku, category, title);
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Item{" +
                "sku='" + sku + '\'' +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

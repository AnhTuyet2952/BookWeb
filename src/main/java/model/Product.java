package model;

public class Product {
    private int productId;
    private String product_name;
    private String description;
    private String product_name_en;
    private String description_en;
    private String image;
    private double price;
    private String author;
    private int publicationYear;
    private String publisher;
    private String origin;
    private Category category;

    public Product(int productId, String product_name, String description, String product_name_en, String description_en, String image, double price, String author, int publicationYear, String publisher, String origin, Category category) {
        this.productId = productId;
        this.product_name = product_name;
        this.description = description;
        this.product_name_en = product_name_en;
        this.description_en = description_en;
        this.image = image;
        this.price = price;
        this.author = author;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.origin = origin;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduct_name_en() {
        return product_name_en;
    }

    public void setProduct_name_en(String product_name_en) {
        this.product_name_en = product_name_en;
    }

    public String getDescription_en() {
        return description_en;
    }

    public void setDescription_en(String description_en) {
        this.description_en = description_en;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

package model;

public class Product {
    private String productUrl;
    private int count;

    public Product(String productUrl, int count) {
        this.productUrl = productUrl;
        this.count = count;
    }

    public Product(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

package service;


import model.Product;

public class ProductCreator {
    public static final String PRODUCT_URL="test.data.product.%s.url";
    public static final String PRODUCT_COUNT="test.data.product.%s.count";

    public static Product withAllProperty(String productNumber){
        String productUrl=String.format(PRODUCT_URL,productNumber);
        String productCount=String.format(PRODUCT_COUNT,productNumber);
        return new Product(TestDataReader.getTestData(productUrl),
                Integer.parseInt(TestDataReader.getTestData(productCount)));
    }

    public static Product withEmptyProductSize(String productNumber){
        String productUrl=String.format(PRODUCT_URL,productNumber);
        return new Product(TestDataReader.getTestData(productUrl));
    }

}

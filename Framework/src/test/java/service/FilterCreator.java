package service;

import model.Filter;

public class FilterCreator {
    public static final String COLOR="test.data.filter.color";
    public static final String CATEGORY="test.data.filter.category";

    public static Filter withEmptyColor(){
        return new Filter.Builder()
                .withCategory(TestDataReader.getTestData(CATEGORY))
                .build();
    }

    public static Filter withEmptyCategory(){
        return new Filter.Builder()
                .withColor(TestDataReader.getTestData(COLOR))
                .build();
    }

    public static Filter withAllProperty(){
        return new Filter.Builder()
                .withColor(TestDataReader.getTestData(COLOR))
                .withCategory(TestDataReader.getTestData(CATEGORY))
                .build();
    }
}

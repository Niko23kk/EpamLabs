package service;

import model.User;

public class UserCreator {

    public static final String USER_NAME="test.data.user.username";
    public static final String USER_PASSWORD="test.data.user.userpassword";
    public static final String USER_PLACE_LIFE="test.data.user.userplacelife";
    public static final String USER_TYPE_PLACE_LIFE="test.data.user.usertypeplacelife";
    public static final String USER_PHONE_NUMBER="test.data.user.userphonenumber";
    public static final String USER_EMAIL="test.data.user.useremail";

    public static User withAllProperty(){
        return new User(TestDataReader.getTestData(USER_NAME),
                TestDataReader.getTestData(USER_PASSWORD),
                TestDataReader.getTestData(USER_PLACE_LIFE),
                TestDataReader.getTestData(USER_TYPE_PLACE_LIFE),
                TestDataReader.getTestData(USER_PHONE_NUMBER),
                TestDataReader.getTestData(USER_EMAIL));
    }

    public static User withEmptyPlaceOfLife(){
        return new User(TestDataReader.getTestData(USER_NAME),
                TestDataReader.getTestData(USER_PASSWORD),
                TestDataReader.getTestData(USER_PHONE_NUMBER),
                TestDataReader.getTestData(USER_EMAIL));
    }
}

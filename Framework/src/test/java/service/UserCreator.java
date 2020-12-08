package service;

import model.User;

public class UserCreator {

    public static final String USER_NAME="Alexsey Nikolaenkov";
    public static final String USER_PASSWORD="agaaga";

    public static User withCredentialsFromProperty(){
        return new User(USER_NAME,USER_PASSWORD);
    }

    public static User withEmpryUsername(){
        return new User("",USER_PASSWORD);
    }

    public static User withEmptyPassword(){
        return new User(USER_NAME,"");
    }
}

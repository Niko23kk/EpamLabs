package model;

import java.util.Objects;

public class User {
    private String username;
    private String password;
    private String placeOfLife;
    private String typePlaceOfLife;
    private String phoneNumber;
    private String email;

    public User(String username, String password, String placeOfLife, String typePlaceOfLife, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.placeOfLife = placeOfLife;
        this.typePlaceOfLife = typePlaceOfLife;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User(String username, String password, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPlaceOfLife() {
        return placeOfLife;
    }

    public void setPlaceOfLife(String city) {
        this.placeOfLife = city;
    }

    public String getTypePlaceOfLife() {
        return typePlaceOfLife;
    }

    public void setTypePlaceOfLife(String placeOfLifeType) {
        typePlaceOfLife = placeOfLifeType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User(" +
                "username= '" + username+ "'" +
                ", password= '" + password + "'" +
                "}";
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof User)) return false;
        User user=(User) o;
        return Objects.equals(getUsername(),user.getUsername()) &&
                Objects.equals(getPassword(),user.getPassword());
    }
}

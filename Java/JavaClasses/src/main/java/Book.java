import java.time.Year;
import java.util.Date;

public class Book {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String publisher;
    private int yearOfPublish;
    private int numberOfPage;
    private float price;
    private BinddingTypes binddingType;

    public Book(int id, String name, String surname, String patronymic, String publisher, int yearOfPublish,
                int numberOfPage, float price, BinddingTypes binddingType) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.publisher = publisher;
        this.yearOfPublish = yearOfPublish;
        this.numberOfPage = numberOfPage;
        this.price = price;
        this.binddingType = binddingType;
    }

    public Book(int id) {
        this.id = id;
    }

    public Book(int id, String name, String surname, String patronymic) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public Book(int id, String name, String surname, String publisher, int yearOfPublish, int numberOfPage,
                float price, BinddingTypes binddingType) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.publisher = publisher;
        this.yearOfPublish = yearOfPublish;
        this.numberOfPage = numberOfPage;
        this.price = price;
        this.binddingType = binddingType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public BinddingTypes getBinddingType() {
        return binddingType;
    }

    public void setBinddingType(BinddingTypes binddingType) {
        this.binddingType = binddingType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", publisher='" + publisher + '\'' +
                ", yearOfPublish='" + yearOfPublish + '\'' +
                ", numberOfPage=" + numberOfPage +
                ", price=" + price +
                ", binddingType=" + binddingType +
                '}';
    }
}

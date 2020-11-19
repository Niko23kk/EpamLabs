import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        BookArray repository = new BookArray();

        repository.addBook(new Book(1, "Alexey","Nikolaenkov","Olegovich", "Буслик",
                2010,2000,20,BinddingTypes.SOFT));

        repository.addBook(new Book(2, "Oleg","Mucha","Andreevich", "GQ",
                1970,250,25,BinddingTypes.HARD));

        repository.addBook(new Book(3, "Alexsandr","Pushkin","Sergeevich", "Харвест",
                2002,2000,20,BinddingTypes.SOFT));

        repository.addBook(new Book(4, "Joe","Baiden","President", "Буслик",
                2017,1000,15,BinddingTypes.NORMAL));

        repository.addBook(new Book(5, "Patrick","Bad", "Харвест",
                2019,2500,20,BinddingTypes.SOFT));

        repository.addBook(new Book(6, "Alexey","Nikolaenkov","Olegovich", "Харвест",
                1999,500,12,BinddingTypes.NORMAL));

        repository.printAll();
        System.out.println();

        repository.printBooksOfAuthor("Alexey Nikolaenkov Olegovich");
        System.out.println();

        repository.printBooksOfPublisher("Буслик");
        System.out.println();

        repository.printBooksPublishBefore(2010);
    }
}

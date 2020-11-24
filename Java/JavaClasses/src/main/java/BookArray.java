import java.util.ArrayList;
import java.util.stream.Collectors;

public class BookArray {
    private ArrayList<Book> books;

    public BookArray() {
        books = new ArrayList<Book>();
    }

    public BookArray(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getAllBooks(){
        return new ArrayList<Book>(books);
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }

    public Book getById(int id){
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).getId() == id){
                return books.get(i);
            }
        }
        return null;
    }

    public void removeById(int id){
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).getId() == id){
                books.remove(i);
            }
        }
    }

    public void printAll(){
        for(int i = 0; i < books.size(); i++){
            System.out.println(books.get(i).toString());
        }
    }

    public void printCollection(ArrayList<Book> collection){
        for(int i = 0; i < collection.size(); i++){
            System.out.println(collection.get(i).toString());
        }
    }

    public void printBooksOfAuthor(String fullName) {
        printCollection(books.stream().filter(book->(book.getName()+" "+book.getSurname()+" " +book.getPatronymic()).equals(fullName))
                .collect(Collectors.toCollection(()->new ArrayList<Book>())));
    }

    public void printBooksOfPublisher(String publisher) {
        printCollection(books.stream().filter(book->book.getPublisher()==publisher).collect(Collectors.toCollection(()->new ArrayList<Book>())));
    }

    public void printBooksPublishBefore(int year) {
        printCollection(books.stream().filter(book->book.getYearOfPublish()>year).collect(Collectors.toCollection(()->new ArrayList<Book>())));
    }

    public  int size(){
        return books.size();
    }
}

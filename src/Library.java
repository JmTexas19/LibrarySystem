import java.util.ArrayList;

public class Library {
    public ArrayList<Book> bookList = new ArrayList<>();
    BookFactory bookFactory = new BookFactory();

    public static void main(String args[]){
        //Test stuff here
        Library lib = new Library();
        lib.bookList.add(lib.bookFactory.createBook("Comic", "Avengers", "Marvel", "1999", "123123"));
    }
}
import java.util.ArrayList;

public interface LibraryIF {
    Book checkoutBook(String bookID);
    void receiveBook(String bookID);
    ArrayList<Book> searchLibrary(String search);
}

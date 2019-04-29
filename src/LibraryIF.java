import java.util.ArrayList;

public interface LibraryIF {
    void checkoutBook(User u, String bookID);
    void receiveBook(User u, String bookID);
    void reserveBook(User u, String bookID);
    void unReserveBook(User u, String bookID);
    ArrayList<Book> searchLibrary(String search);
}

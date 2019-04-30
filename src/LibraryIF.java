import java.util.ArrayList;

public interface LibraryIF {
    void checkoutBook(User u, String bookID) throws InterruptedException;
    void receiveBook(User u, String bookID) throws InterruptedException;
    void reserveBook(User u, String bookID) throws InterruptedException;
    void unReserveBook(User u, String bookID) throws InterruptedException;
    ArrayList<Book> searchLibrary(String search);
}

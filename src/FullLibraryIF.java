public interface FullLibraryIF extends LibraryIF{
    void createBook(String type, String name, String author, String year);
    void removeBook(String bookID) throws InterruptedException;
    void editBook(String bookID) throws InterruptedException;
}

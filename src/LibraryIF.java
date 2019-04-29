public interface LibraryIF {
    Book checkoutBook(String bookID);
    void receiveBook(String bookID);
}

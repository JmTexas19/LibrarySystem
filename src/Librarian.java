//Manages Library
public class Librarian extends User{
    private FullLibraryIF lib;

    public Librarian(Library lib){
        this.lib = lib;
    }

    //Checkout Books for visitor by using library
    public void checkoutBook(String bookID) throws InterruptedException {
        lib.checkoutBook(this, bookID);
    }

    //Return books
    public void returnBook(String bookID) throws InterruptedException {
        Book book = getBook(bookID);

        //Return to library
        if(book != null) {
            lib.receiveBook(this, book.bookID);
        }
        else{
            System.out.println("No book with that ID exists, can't return");
        }
    }

    //Create book and add it to the library
    public void createBook(String type, String name, String author, String year){
        lib.createBook(type, name, author, year);
    }

    //Edit book
    public void editBook(String bookID) throws InterruptedException {
        lib.editBook(bookID);
    }

    //Delete book from library
    public void removeBook(String bookID) throws InterruptedException {
        lib.removeBook(bookID);
    }
}

//Manages Library
public class Librarian extends User{
    private FullLibraryIF lib;

    public Librarian(Library lib){
        this.lib = lib;
    }

    //Checkout Books for visitor by using library
    public void checkoutBook(String bookID){
        lib.checkoutBook(this, bookID);
    }

    //Return books
    public void returnBook(String bookID){
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
    public void editBook(String bookID){
        lib.editBook(bookID);
    }

    //Delete book from library
    public void removeBook(String bookID){
        lib.removeBook(bookID);
    }
}

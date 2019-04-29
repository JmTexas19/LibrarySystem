import java.util.ArrayList;

//Manages Library
public class Librarian extends User{
    private ArrayList<Book> checkoutList = new ArrayList<>();
    private ArrayList<Book> reserveList = new ArrayList<>();
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

    //Delete book from library
    public void removeBook(String bookID){
        lib.removeBook(bookID);
    }

    //Get book from checkoutList
    private Book getBook(String bookID){
        for(Book b : checkoutList){
            if(b.bookID.equals(bookID)){
                return b;
            }
        }
        return null;
    }
}

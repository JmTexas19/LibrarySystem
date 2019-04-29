import java.util.ArrayList;

//Regular user for library
public class Visitor extends User{
    private LibraryIF lib;

    public Visitor(Library lib){
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

    //Reserve Book
    public void reserveBook(String bookID){
        lib.reserveBook(this, bookID);
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

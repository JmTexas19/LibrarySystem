import java.util.ArrayList;

//Regular user for library
public class Visitor extends User {
    private LibraryIF lib;

    public Visitor(Library lib){
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

    //Reserve Book
    public void reserveBook(String bookID) throws InterruptedException {
        lib.reserveBook(this, bookID);
    }

    //UnReserve Book
    public void unReserveBook(String bookID) throws InterruptedException {
        lib.unReserveBook(this, bookID);
    }

    //View Book
    public void viewBook(String bookID) throws InterruptedException {
        lib.viewBook(bookID);
    }

    //Notify User
    public void notifyUser(String bookName){
        System.out.println("The book " + bookName + " has copies available.");
    }
}

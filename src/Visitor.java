import java.util.ArrayList;

//Regular user for library
public class Visitor {
    private ArrayList<Book> checkoutList = new ArrayList<>();
    private LibraryIF lib;

    public Visitor(Library lib){
        this.lib = lib;
    }

    //Checkout Books for visitor by using library
    public void checkoutBook(String bookID){
        Book book = lib.checkoutBook(bookID);

        //Check null
        if(book != null){
            checkoutList.add(book);
        }
    }

    //Return books
    public void returnBook(String bookID){
        Book book = getBook(bookID);

        //Return to library
        if(book != null) {
            lib.receiveBook(book.bookID);
            checkoutList.remove(book);
        }
        else{
            System.out.println("No book with that ID exists, can't return");
        }
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

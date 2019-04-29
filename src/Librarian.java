import java.util.ArrayList;

//Manages Library
public class Librarian {
    private ArrayList<Book> checkoutList = new ArrayList<>();
    private LibraryIF lib;

    public Librarian(Library lib){
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
}

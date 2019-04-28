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
        checkoutList.add(lib.getBook(bookID));
    }
}

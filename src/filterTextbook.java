import java.util.ArrayList;
import java.util.Iterator;

public class filterTextbook implements SearchFilterIF {
    @Override
    public ArrayList<Book> filterResults(ArrayList<Book> resultsList) {
        //Remove Non-Textbook Books
        resultsList.removeIf(book -> !book.type.equals("Textbook"));

        return resultsList;
    }
}

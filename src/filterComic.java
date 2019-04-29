import java.util.ArrayList;
import java.util.Iterator;

public class filterComic implements SearchFilterIF {
    @Override
    public ArrayList<Book> filterResults(ArrayList<Book> resultsList) {
        //Remove Non-Comic Books
        resultsList.removeIf(book -> !book.type.equals("Novel"));

        return resultsList;
    }
}

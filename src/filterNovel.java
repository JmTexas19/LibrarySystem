import java.util.ArrayList;
import java.util.Iterator;

public class filterNovel implements SearchFilterIF{
    @Override
    public ArrayList<Book> filterResults(ArrayList<Book> resultsList) {
        //Remove Non-Novel Books
        resultsList.removeIf(book -> book.type.equals("Novel"));

        return resultsList;
    }
}

import java.util.ArrayList;
import java.util.Iterator;

public class filterTextbook implements SearchFilterIF {
    @Override
    public ArrayList<Book> filterResults(ArrayList<Book> resultsList) {
        ArrayList<Book> filteredResults = resultsList;
        Iterator<Book> iterator = resultsList.iterator();

        //Remove Non-Textbook Books
        while(iterator.hasNext()) {
            if (!iterator.next().type.equals("Textbook")) {
                iterator.remove();
            }
        }

        return filteredResults;
    }
}

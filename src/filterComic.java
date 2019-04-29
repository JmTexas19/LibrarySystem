import java.util.ArrayList;
import java.util.Iterator;

public class filterComic implements SearchFilterIF {
    @Override
    public ArrayList<Book> filterResults(ArrayList<Book> resultsList) {
        ArrayList<Book> filteredResults = resultsList;

        Iterator<Book> iterator = resultsList.iterator();

        //Remove Non-Comic Books
        while(iterator.hasNext()) {
            if (!iterator.next().type.equals("Novel")) {
                iterator.remove();
            }
        }

        return filteredResults;
    }
}

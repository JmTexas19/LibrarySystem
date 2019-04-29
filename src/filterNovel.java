import java.util.ArrayList;
import java.util.Iterator;

public class filterNovel implements SearchFilterIF{
    @Override
    public ArrayList<Book> filterResults(ArrayList<Book> resultsList) {
        ArrayList<Book> filteredResults = resultsList;
        Iterator<Book> iterator = resultsList.iterator();

        //Remove Non-Novel Books
        while(iterator.hasNext()) {
            if (iterator.next().type.equals("Novel")) {
                iterator.remove();
            }
        }

        return filteredResults;
    }
}

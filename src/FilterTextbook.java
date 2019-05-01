import java.util.ArrayList;

public class FilterTextbook extends AbstractFilter {
    public FilterTextbook(SearchFilterIF filter) {
        super(filter);
    }
    public FilterTextbook(ArrayList<Book> resultsList){
        super(resultsList);
    }

    @Override
    public ArrayList<Book> filterResults(ArrayList<Book> resultsList) {
        //Remove Non-Textbook Books
        resultsList.removeIf(book -> book.type.equals("Textbook"));

        return resultsList;
    }
}

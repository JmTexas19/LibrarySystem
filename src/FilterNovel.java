import java.util.ArrayList;

public class FilterNovel extends AbstractFilter {
    public FilterNovel(SearchFilterIF filter) {
        super(filter);
    }
    public FilterNovel(ArrayList<Book> resultsList){
        super(resultsList);
    }

    @Override
    public ArrayList<Book> filterResults(ArrayList<Book> resultsList) {
        //Remove Non-Novel Books
        resultsList.removeIf(book -> book.type.equals("Novel"));

        return resultsList;
    }
}

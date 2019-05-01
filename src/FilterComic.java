import java.util.ArrayList;

public class FilterComic extends AbstractFilter {
    public FilterComic(SearchFilterIF filter) {
        super(filter);
    }
    public FilterComic(ArrayList<Book> resultsList){
        super(resultsList);
    }

    @Override
    public ArrayList<Book> filterResults(ArrayList<Book> resultsList) {
        //Remove Non-Comic Books
        resultsList.removeIf(book -> !book.type.equals("Novel"));

        return resultsList;
    }
}

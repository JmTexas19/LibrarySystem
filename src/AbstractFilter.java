import java.util.ArrayList;

public abstract class AbstractFilter implements SearchFilterIF {
    public SearchFilterIF filter;
    public ArrayList<Book> resultsList;
    public abstract ArrayList<Book> filterResults(ArrayList<Book> resultsList);

    public AbstractFilter(SearchFilterIF filter){
        this.filter = filter;
    }
    public AbstractFilter(ArrayList<Book> resultsList){
        this.resultsList = resultsList;
    }
}

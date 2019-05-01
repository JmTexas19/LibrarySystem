import java.util.ArrayList;

public class ANDFilter implements SearchFilterIF {
    private SearchFilterIF[] filters;

    public ANDFilter(SearchFilterIF... filters) {
        this.filters = filters;
    }

    @Override
    public ArrayList<Book> filterResults(ArrayList<Book> books) {
        ArrayList<Book> filteredBooks = books;

        for (SearchFilterIF filter : filters) {
            filteredBooks = filter.filterResults(filteredBooks);
        }

        return filteredBooks;
    }
}

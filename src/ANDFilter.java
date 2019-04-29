import java.util.ArrayList;

public class ANDFilter implements SearchFilterIF {
    private SearchFilterIF[] filters;

    public ANDFilter(SearchFilterIF... filters) {
        this.filters = filters;
    }

    @Override
    public ArrayList<Book> filterResults(ArrayList<Book> books) {
        ArrayList<Book> filteredLaptops = books;

        for (SearchFilterIF filter : filters) {
            filteredLaptops = filter.filterResults(filteredLaptops);
        }

        return filteredLaptops;
    }
}

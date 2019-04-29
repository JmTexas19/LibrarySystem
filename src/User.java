import java.util.ArrayList;

public abstract class User implements ObserverIF{
    public ArrayList<Book> checkoutList = new ArrayList<>();
    public ArrayList<Book> reserveList = new ArrayList<>();

    public ArrayList<Book> getReserveList(){
        return reserveList;
    }
}

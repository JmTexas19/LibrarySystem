import java.util.ArrayList;

public interface ObserverIF {
    void notifyUser(String name);
    ArrayList<Book> getReserveList();
}

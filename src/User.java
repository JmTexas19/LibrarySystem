import java.util.ArrayList;

public abstract class User implements ObserverIF{
    public ArrayList<Book> checkoutList = new ArrayList<>();
    public ArrayList<Book> reserveList = new ArrayList<>();

    //Get book from checkoutList
    protected Book getBook(String bookID){
        for(Book b : checkoutList){
            if(b.bookID.equals(bookID)){
                return b;
            }
        }
        return null;
    }

    //Notify User
    public void notifyUser(String bookName){
        System.out.println("The book " + bookName + " has copies available.");
    }

    public ArrayList<Book> getReserveList(){
        return reserveList;
    }
}

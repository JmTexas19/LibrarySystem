import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Library implements FullLibraryIF {
    private ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<ObserverIF> observerList = new ArrayList<>();
    private BookFactory bookFactory = new BookFactory();
    private ReadWriteLock lockManager = new ReadWriteLock();
    boolean filterComics = false;
    boolean filterNovels = false;
    boolean filterTextbooks = false;

    //Get book from library
    private Book getBook(String bookID) throws InterruptedException {
        lockManager.readLock(); //Lock

        for (Book b : bookList) {
            if (bookID.equals(b.bookID)) {
                lockManager.done(); //Release Lock
                return b;
            }
        }

        //No book with that ID found
        lockManager.done();
        System.out.println("No book with that ID found");
        return null;
    }

    //Get book checked out by visitors
    public void checkoutBook(User u, String bookID) throws InterruptedException {
        Book book = getBook(bookID);

        if(book != null && book.copies > 0){
            if(!u.checkoutList.contains(book)) {
                book.copies--;
                u.checkoutList.add(book);
                System.out.println("Checked Out " + book.name);
            }
            else{
                System.out.println("You already have a copy of this book.");
            }
        }
        else{
            System.out.println("No copies for book left");
        }
    }

    //Receive books from users
    public void receiveBook(User u, String bookID) throws InterruptedException {
        Book book = getBook(bookID);

        //If not null remove book from user list
        if(book != null){
            book.copies++;
            u.checkoutList.remove(book);

            //Notify users who reserved book
            for(ObserverIF user : observerList){
                for(Book b : user.getReserveList()){
                    if(b.bookID.equals(bookID)){
                        user.notifyUser(b.name);
                    }
                }
            }

            System.out.println(book.name + " Returned");
        }
        else{
            System.out.println("We don't store that book");
        }
    }

    //Reserve Book
    public void reserveBook(User u, String bookID) throws InterruptedException {
        Book book = getBook(bookID);

        //Reserve
        if(book != null && book.copies > 0){
            System.out.println("Book has copies available... Checking out instead");
            checkoutBook(u, book.bookID);
        }
        else if(!u.reserveList.contains(book)){
            //Register as observer
            if(!observerList.contains(u)){
                observerList.add(u);
            }

            u.reserveList.add(book);
        }
        else{
            System.out.println("No book with that ID found or book already reserved");
        }
    }

    //UnReserve Book
    public void unReserveBook(User u, String bookID) throws InterruptedException {
        Book book = getBook(bookID);

        if(book != null && u.reserveList.contains(book)){
            //Remove as observer
            observerList.remove(u);
            u.reserveList.remove(book);
        }
        else{
            System.out.println("No book with that ID found or book isn't reserved");
        }
    }

    //Create Book
    public void createBook(String type, String name, String author, String year) {
        boolean exists = false;

        //If book already exists, add copy.
        for (Book b : bookList) {
            if (b.type.equals(type) && b.name.equals(name) && b.author.equals(author) && b.year.equals(year)) {
                b.copies++;
                exists = true;
            }
        }

        if (!exists) this.bookList.add(bookFactory.createBook(type, name, author, year));
    }

    //Remove Book
    public void removeBook(String bookID) throws InterruptedException {
        Book book = getBook(bookID);

        if(book != null){
            bookList.remove(book);
        }
        else{
            System.out.println("No book with that ID found");
        }
    }

    //Edit Book
    public void editBook(String bookID) throws InterruptedException {
        //Get book
        Book book = getBook(bookID);

        //Lock
        lockManager.writeLock(); //Lock

        //Edit Book if not null
        if(book != null){
            System.out.println("Editing book " + book.name);
            Scanner scanner = new Scanner(System.in);
            String name, author, year;
            //Get each attribute of book
            System.out.println("Name");
            name = scanner.nextLine();
            System.out.println("Author");
            author = scanner.nextLine();
            System.out.println("Year");
            year = scanner.nextLine();

            //Replace
            book.name = name;
            book.author = author;
            book.year = year;

            //Close scanner
            scanner.close();
        }
        else{
            System.out.println("No book with that ID found");
        }

        //Unlock
        lockManager.done();
    }

    //View Book
    public void viewBook(String bookID) throws InterruptedException {
        Book book = getBook(bookID);

        //Print if not null
        if(book != null){
            System.out.println("Type: " + book.type);
            System.out.println("Name: " + book.name);
            System.out.println("Author: " + book.author);
            System.out.println("Year: " + book.year);
            System.out.println("Copies: " + book.copies);
            System.out.println("ID: " + book.bookID);
        }
    }

    //Search Books
    public ArrayList<Book> searchLibrary(String search) {
        ArrayList<Book> resultsList = new ArrayList<>();

        //Search all books and return matching. O(n)
        for (Book b : bookList) {
            if (b.name.contains(search) || b.year.contains(search) || b.author.contains(search) || b.type.contains(search)) {
                resultsList.add(b);
            }
        }

        //Filters
        SearchFilterIF filter;
        if(filterComics) {
            filter = new FilterComic(resultsList);
            resultsList = filter.filterResults(resultsList);
            if(filterNovels){
                filter = new FilterNovel(filter);
                resultsList = filter.filterResults(resultsList);
                if(filterTextbooks){
                    filter = new FilterTextbook(filter);
                    resultsList = filter.filterResults(resultsList);
                }
            }
            else if(filterTextbooks){
                filter = new FilterTextbook(filter);
                resultsList = filter.filterResults(resultsList);
            }
        }
        else if(filterNovels){
            filter = new FilterNovel(resultsList);
            resultsList = filter.filterResults(resultsList);
            if(filterTextbooks){
                filter = new FilterTextbook(filter);
                resultsList = filter.filterResults(resultsList);
            }
        }
        else if(filterTextbooks){
            filter = new FilterTextbook(resultsList);
            resultsList = filter.filterResults(resultsList);
        }

        filterComics = false;
        filterNovels = false;
        filterTextbooks = false;

        //Sort lists by name
        resultsList.sort(Comparator.comparing(o -> o.name));
        return resultsList;
    }

    //MAIN
    public static void main(String[] args) throws InterruptedException {
        //Test stuff here
        Library lib = new Library();

        //Import books with Dynamic Linkage pattern
        AbstractLoadInventory inventory = new LoadableInventory();
        inventory.setLibrary(lib);
        inventory.startImport();

        Visitor v = new Visitor(lib);
        Visitor v2 = new Visitor(lib);

        v.checkoutBook("1");
        v.checkoutBook("4");
        v.checkoutBook("7");
        v.checkoutBook("3");

        lib.searchLibrary("Marvel");
        v.returnBook("1");
        v.returnBook("3");
        v.returnBook("6");

        Librarian librarian = new Librarian(lib);
        librarian.createBook("Textbook", "Calculus 3", "Bob Barker", "2006");
        librarian.removeBook("8");
        librarian.removeBook("9");

        v2.checkoutBook("4");
        v.reserveBook("4");
        v.unReserveBook("4");

        //Test Read/Write Lock (Uncomment to test)
//        lib.lockManager.readLock();
//        librarian.editBook("1");

        //DEBUG TO SEE ALL VALUES IN LIBRARY FOR TESTING
    }
}
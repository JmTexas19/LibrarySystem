import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Library implements FullLibraryIF {
    public ArrayList<Book> bookList = new ArrayList<>();
    public ArrayList<User> UserList = new ArrayList<>();
    public BookFactory bookFactory = new BookFactory();

    //Get book from library
    public Book getBook(String bookID) {
        for (Book b : bookList) {
            if (bookID.equals(b.bookID)) {
                return b;
            }
        }

        //No book with that ID found
        System.out.println("No book with that ID found");
        return null;
    }

    //Get book checked out by visitors
    public void checkoutBook(User u, String bookID){
        Book book = getBook(bookID);

        //If User is not registered, register
        if(!UserList.contains(u)){
            UserList.add(u);
        }

        if(book != null){
            book.copies--;
            u.checkoutList.add(book);
        }
        else{
            System.out.println("No copies for book left");
        }
    }

    //Receive books from users
    public void receiveBook(User u, String bookID){
        Book book = getBook(bookID);

        if(book != null){
            book.copies++;
        }
        else{
            System.out.println("We don't store that book");
        }
    }

    //Reserve Book
    public void reserveBook(User u, String bookID){
        //If visitor is not registered, register
        if(!UserList.contains(u)){
            UserList.add(u);
        }

        Book book = getBook(bookID);

        //Reserve
        if(book.copies > 0){
            System.out.println("Book has copies available... Checking out instead");
            checkoutBook(u, book.bookID);
        }
        else if(book != null && !u.reserveList.contains(book)){
            u.reserveList.add(book);
        }
        else{
            System.out.println("No book with that ID found or book already reserved");
        }
    }

    //Create Book
    public void createBook(String type, String name, String author, String year) {
        boolean exists = false;

        //If book already exists, add copy.
        for (Book b : bookList) {
            if (b.type.equals(type) && b.name.equals(name) && b.author.equals(author) && b.year.equals(year)) {
                b.copies++;
                System.out.println("Book already exists, added copy");
                exists = true;
            }
        }

        if (!exists) this.bookList.add(bookFactory.createBook(type, name, author, year));
    }

    //Remove Book
    public void removeBook(String bookID){
        Book book = getBook(bookID);

        if(book != null){
            bookList.remove(book);
        }
        else{
            System.out.println("No book with that ID found");
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
        ANDFilter filter = new ANDFilter(new filterComic());
        resultsList = filter.filterResults(resultsList);

        //Sort lists by name
        Collections.sort(resultsList, Comparator.comparing(o -> o.name));
        return resultsList;
    }

    //MAIN
    public static void main(String[] args) {
        //Test stuff here
        Library lib = new Library();

        //Create Books
        lib.createBook("Comic", "Avengers", "Marvel", "1999");
        lib.createBook("Comic", "Avengers", "Marvel", "1999");
        lib.createBook("Comic", "Avengers", "Marvel", "1999");
        lib.createBook("Comic", "Avengers", "Not Marvel", "1999");
        lib.createBook("Comic", "Avengers", "Marvel", "1996");
        lib.createBook("Novel", "Avengers", "Marvel", "1999");
        lib.createBook("Comic", "Iron Man", "Marvel", "1999");
        lib.createBook("Comic", "Iron Man", "Marvel", "1999");
        lib.createBook("Comic", "Captain America", "Marvel", "1999");
        lib.createBook("Comic", "Thor", "Marvel", "1999");
        lib.createBook("Novel", "Animal Farm", "George Orwell", "1945");
        lib.createBook("Novel", "Murder Time", "John Sin", "1986");
        lib.createBook("Novel", "Feel Something", "Laura Kian", "1999");
        lib.createBook("Novel", "Rising Dragon", "Xiao Sen", "1976");
        lib.createBook("Novel", "Martial World", "Lin Ming", "2004");
        lib.createBook("Textbook", "Algebra 1", "Bob Barker", "2004");
        lib.createBook("Textbook", "Algebra 2", "Bob Barker", "2004");
        lib.createBook("Textbook", "Algebra 3", "Bob Barker", "2005");
        lib.createBook("Textbook", "Calculus 1", "Bob Barker", "2005");
        lib.createBook("Textbook", "Calculus 2", "Bob Barker", "2006");

        Visitor v = new Visitor(lib);
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

        v.reserveBook("4");

    }
}
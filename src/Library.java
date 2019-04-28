import java.util.ArrayList;

public class Library implements LibraryIF{
    public ArrayList<Book> bookList = new ArrayList<>();
    public BookFactory bookFactory = new BookFactory();

    //Allow visitors to checkout books
    public Book getBook(String bookID){
        for(Book b : bookList){
            if(bookID.equals(b.bookID)){
                return b;
            }
        }

        //No book with that ID found
        System.out.println("No book with that ID found");
        return null;
    }


    //MAIN
    public static void main(String args[]){
        //Test stuff here
        Library lib = new Library();

        //Create Books
        lib.bookList.add(lib.bookFactory.createBook("Comic", "Avengers", "Marvel", "1999"));
        lib.bookList.add(lib.bookFactory.createBook("Comic", "Avengers2", "Marvel", "1999"));
        lib.bookList.add(lib.bookFactory.createBook("Comic", "Avengers3", "Marvel", "1999"));
        lib.bookList.add(lib.bookFactory.createBook("Comic", "Avengers4", "Marvel", "1999"));
        lib.bookList.add(lib.bookFactory.createBook("Comic", "Avengers5", "Marvel", "1999"));
        lib.bookList.add(lib.bookFactory.createBook("Comic", "Avengers6", "Marvel", "1999"));
        lib.bookList.add(lib.bookFactory.createBook("Comic", "Iron Man", "Marvel", "1999"));
        lib.bookList.add(lib.bookFactory.createBook("Comic", "Spiderman", "Marvel", "1999"));
        lib.bookList.add(lib.bookFactory.createBook("Comic", "Captain America", "Marvel", "1999"));
        lib.bookList.add(lib.bookFactory.createBook("Comic", "Thor", "Marvel", "1999"));
        lib.bookList.add(lib.bookFactory.createBook("Novel", "Animal Farm", "George Orwell", "1945"));
        lib.bookList.add(lib.bookFactory.createBook("Novel", "Murder Time", "John Sin", "1986"));
        lib.bookList.add(lib.bookFactory.createBook("Novel", "Feel Something", "Laura Kian", "1999"));
        lib.bookList.add(lib.bookFactory.createBook("Novel", "Rising Dragon", "Xiao Sen", "1976"));
        lib.bookList.add(lib.bookFactory.createBook("Novel", "Martial World", "Lin Ming", "2004"));
        lib.bookList.add(lib.bookFactory.createBook("Textbook", "Algebra 1", "Bob Barker", "2004"));
        lib.bookList.add(lib.bookFactory.createBook("Textbook", "Algebra 2", "Bob Barker", "2004"));
        lib.bookList.add(lib.bookFactory.createBook("Textbook", "Algebra 3", "Bob Barker", "2005"));
        lib.bookList.add(lib.bookFactory.createBook("Textbook", "Calculus 1", "Bob Barker", "2005"));
        lib.bookList.add(lib.bookFactory.createBook("Textbook", "Calculus 2", "Bob Barker", "2006"));

        Visitor v = new Visitor(lib);
        v.checkoutBook("4");
    }
}
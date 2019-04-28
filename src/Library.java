import java.util.ArrayList;

public class Library implements FullLibraryIF{
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

    //Create Book
    public void createBook(String type, String name, String author, String year){
        boolean exists = false;
        //If book already exists, add copy.
        for(Book b : bookList){
            if(b.type.equals(type) && b.name.equals(name) && b.author.equals(author) && b.year.equals(year)){
                b.copies++;
                System.out.println("Book already exists, added copy");
                exists = true;
            }
        }

        if(!exists) this.bookList.add(bookFactory.createBook(type, name, author, year));
    }


    //MAIN
    public static void main(String args[]){
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
        v.checkoutBook("4");
    }
}
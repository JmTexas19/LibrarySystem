public abstract class Book {
    public String name;
    public String author;
    public String year;
    public String bookID;

    //Constructor
    public Book(String name, String author, String year, String bookID){
        this.name = name;
        this.author = author;
        this.year = year;
        this.bookID = bookID;
    }
}

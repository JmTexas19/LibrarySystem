public abstract class Book {
    public String type;
    public String name;
    public String author;
    public String year;
    public String bookID;
    public int copies;

    //Constructor
    public Book(String name, String author, String year, String bookID){
        this.name = name;
        this.author = author;
        this.year = year;
        this.bookID = bookID;
        this.copies = 1;
    }
}

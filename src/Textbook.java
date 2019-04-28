public class Textbook extends Book {
    public Textbook(String name, String author, String year, String bookID) {
        super(name, author, year, bookID);
        this.type = "Textbook";
    }
}

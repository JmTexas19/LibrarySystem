public class Comic extends Book{

    public Comic(String name, String author, String year, String bookID) {
        super(name, author, year, bookID);
        this.type = "Comic";
    }
}

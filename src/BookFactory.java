public class BookFactory {
    //Return book based on type
    public Book createBook(String type, String name, String author, String year, String bookID){
        switch (type) {
            case "Comic":
                return new Comic(name, author, year, bookID);
            case "Novel":
                return new Novel(name, author, year, bookID);
            case "Textbook":
                return new Textbook(name, author, year, bookID);
            default:
                return null;
        }
    }
}

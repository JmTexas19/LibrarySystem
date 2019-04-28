public class BookFactory {
    private String bookID = "0";

    //Return book based on type
    public Book createBook(String type, String name, String author, String year){
        switch (type) {
            case "Comic":
                bookID = Integer.toString((Integer.parseInt(bookID) + 1));
                return new Comic(name, author, year, bookID);
            case "Novel":
                bookID = Integer.toString((Integer.parseInt(bookID) + 1));
                return new Novel(name, author, year, bookID);
            case "Textbook":
                bookID = Integer.toString((Integer.parseInt(bookID) + 1));
                return new Textbook(name, author, year, bookID);
            default:
                return null;
        }
    }
}

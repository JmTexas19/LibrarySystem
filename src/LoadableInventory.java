public class LoadableInventory extends AbstractLoadInventory {
    @Override
    public void startImport() {
        //Create Books
        getLibrary().createBook("Comic", "Avengers", "Marvel", "1999");
        getLibrary().createBook("Comic", "Avengers", "Marvel", "1999");
        getLibrary().createBook("Comic", "Avengers", "Marvel", "1999");
        getLibrary().createBook("Comic", "Avengers", "Not Marvel", "1999");
        getLibrary().createBook("Comic", "Avengers", "Marvel", "1996");
        getLibrary().createBook("Novel", "Avengers", "Marvel", "1999");
        getLibrary().createBook("Comic", "Iron Man", "Marvel", "1999");
        getLibrary().createBook("Comic", "Iron Man", "Marvel", "1999");
        getLibrary().createBook("Comic", "Captain America", "Marvel", "1999");
        getLibrary().createBook("Comic", "Thor", "Marvel", "1999");
        getLibrary().createBook("Novel", "Animal Farm", "George Orwell", "1945");
        getLibrary().createBook("Novel", "Murder Time", "John Sin", "1986");
        getLibrary().createBook("Novel", "Feel Something", "Laura Kian", "1999");
        getLibrary().createBook("Novel", "Rising Dragon", "Xiao Sen", "1976");
        getLibrary().createBook("Novel", "Martial World", "Lin Ming", "2004");
        getLibrary().createBook("Textbook", "Algebra 1", "Bob Barker", "2004");
        getLibrary().createBook("Textbook", "Algebra 2", "Bob Barker", "2004");
        getLibrary().createBook("Textbook", "Algebra 3", "Bob Barker", "2005");
        getLibrary().createBook("Textbook", "Calculus 1", "Bob Barker", "2005");
        getLibrary().createBook("Textbook", "Calculus 2", "Bob Barker", "2006");
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class DemoLibrary {
    public static void main(String[] args) throws InterruptedException {
        //Create Library
        Library library = new Library();
        DemoLibrary demo = new DemoLibrary();

        //Import books with Dynamic Linkage pattern
        AbstractLoadInventory inventory = new LoadableInventory();
        inventory.setLibrary(library);
        inventory.startImport();

        //Scanner for input
        Scanner scanner = new Scanner(System.in);
        int inputInt = -1;
        String bookID;
        String searchStr;

        //Check user input
        while(inputInt != 1 && inputInt != 2) {
            //Choose User
            System.out.println("Choose type of user:\n1:Visitor\n2:Librarian");
            inputInt = scanner.nextInt();
        }

        //Visitor Options
        if(inputInt == 1){
            Visitor v = new Visitor(library);

            while(inputInt != 0) {
                System.out.println("Choose an option:\n" +
                        "1: Search Library\n" +
                        "2: View Book\n" +
                        "3: Checkout Book:\n" +
                        "4: Return Book:\n" +
                        "5: Reserve Book\n" +
                        "6: Unreserve Book\n" +
                        "7: View My Books\n" +
                        "0: Quit\n");
                inputInt = scanner.nextInt();

                switch (inputInt){
                    case 1:
                        //Search
                        System.out.print("Enter search string: ");
                        searchStr = scanner.next();

                        //Filters
                        System.out.print("Filter Comics? (y/n): ");
                        if(scanner.next().equals("y")) library.filterComics = true;
                        else library.filterComics = false;
                        System.out.print("Filter Novels? (y/n): ");
                        if(scanner.next().equals("y")) library.filterNovels = true;
                        else library.filterNovels = false;
                        System.out.print("Filter Textbooks? (y/n): ");
                        if(scanner.next().equals("y")) library.filterTextbooks = true;
                        else library.filterTextbooks = false;

                        //Print Results
                        ArrayList<Book> results = library.searchLibrary(searchStr);
                        System.out.println("Results:");
                        if(!results.isEmpty()) {
                            for (Book book : results) {
                                System.out.println(book.bookID + ": " + book.name);
                            }
                        }
                        else{
                            System.out.println("No Results");
                        }
                        break;
                    case 2:
                        //View Book
                        System.out.print("Enter bookID: ");
                        bookID = scanner.next();
                        v.viewBook(bookID);
                        break;
                    case 3:
                        //Checkout Book
                        System.out.print("Enter bookID: ");
                        bookID = scanner.next();
                        v.checkoutBook(bookID);
                        break;
                    case 4:
                        //Return Book
                        //Print books for user
                        System.out.println("Checked Out Books:");
                        for(Book book : v.checkoutList){
                            System.out.println(book.bookID + ": " + book.name);
                        }

                        System.out.print("Enter bookID: ");
                        bookID = scanner.next();
                        v.returnBook(bookID);
                        break;
                    case 5:
                        //Reserve Book
                        System.out.print("Enter bookID: ");
                        bookID = scanner.next();
                        v.reserveBook(bookID);
                        break;
                    case 6:
                        //Print books for user
                        System.out.println("Reserved Books:");
                        for(Book book : v.reserveList){
                            System.out.println(book.bookID + ": " + book.name);
                        }

                        //Unreserve Book
                        System.out.print("Enter bookID: ");
                        bookID = scanner.next();
                        v.unReserveBook(bookID);
                        break;
                    case 7:
                        //Print books for user
                        System.out.println("Checked Out Books:");
                        for(Book book : v.checkoutList){
                            System.out.println(book.bookID + ": " + book.name);
                        }
                        break;
                }
            }
        }
        else{
            Librarian l = new Librarian(library);







        }
    }
}

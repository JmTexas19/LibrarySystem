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

        //Check user input
        while(inputInt != 1 && inputInt != 2) {
            //Choose User
            System.out.println("Choose type of user:\n1:Visitor\n2:Librarian");
            inputInt = scanner.nextInt();
        }

        //Visitor Options
        if(inputInt == 1){
            Visitor v = new Visitor(library);

            while(inputInt > 0 && inputInt < 8) {
                System.out.println("Choose an option:\n" +
                        "1: Search Library\n" +
                        "2: View Book\n" +
                        "3: Checkout Book:\n" +
                        "4: Return Book:\n" +
                        "5: Reserve Book\n" +
                        "6: Unreserve Book\n" +
                        "7: View My Books\n");
                inputInt = scanner.nextInt();

                switch (inputInt){
                    case 1:
                        //Search
                        System.out.print("Enter search string: ");
                        String searchStr = scanner.nextLine();

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

                        ArrayList<Book> results = library.searchLibrary(searchStr);
                        System.out.println(results);
                    case 2:
                        //View Book
                        System.out.print("Enter bookID: ");
                        bookID = scanner.nextLine();
                        v.viewBook(bookID);
                    case 3:
                        library.checkoutBook(v, bookID);
                    case 4:
                        demo.returnBook(v, bookID);
                    case 5:
                        demo.reserveBook(v, bookID);
                    case 6:
                        demo.unreserveBook(v, bookID);
                    case 7:
                        demo.viewMyBooks(v);
                }
            }






        }
        else{
            Librarian l = new Librarian(library);







        }
    }
}

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DemoLibrary {
    public static void main(String[] args) throws InterruptedException {
        //Create Library
        Library library = new Library();
        DemoLibrary demo = new DemoLibrary();
        Visitor v = new Visitor(library);
        Librarian l = new Librarian(library);

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
        while(inputInt != 3) {
            //Handle Invalid Input
            try {
                //Choose User
                System.out.println("Choose type of user:\n1:Visitor\n2:Librarian\n3:Quit");
                inputInt = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                scanner.next();
            }


            //Visitor Options
            if (inputInt == 1) {
                while (inputInt != 0) {
                    System.out.println("Choose an option:\n" +
                            "1: Search Library\n" +
                            "2: View Book\n" +
                            "3: Checkout Book:\n" +
                            "4: Return Book:\n" +
                            "5: Reserve Book\n" +
                            "6: Unreserve Book\n" +
                            "7: View My Books\n" +
                            "0: Quit\n");

                    //Handle Invalid Input
                    try {
                        inputInt = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input");
                        inputInt = -1;
                        scanner.next();
                    }

                    switch (inputInt) {
                        case 1:
                            //Search
                            System.out.print("Enter search string: ");
                            searchStr = scanner.next();

                            //Filters
                            System.out.print("Filter Comics? (y/n): ");
                            if (scanner.next().equals("y")) library.filterComics = true;
                            else library.filterComics = false;
                            System.out.print("Filter Novels? (y/n): ");
                            if (scanner.next().equals("y")) library.filterNovels = true;
                            else library.filterNovels = false;
                            System.out.print("Filter Textbooks? (y/n): ");
                            if (scanner.next().equals("y")) library.filterTextbooks = true;
                            else library.filterTextbooks = false;

                            //Print Results
                            ArrayList<Book> results = library.searchLibrary(searchStr);
                            System.out.println("Results:");
                            if (!results.isEmpty()) {
                                for (Book book : results) {
                                    System.out.println(book.bookID + ": " + book.name);
                                }
                            } else {
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
                            for (Book book : v.checkoutList) {
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
                            for (Book book : v.reserveList) {
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
                            if (v.checkoutList != null) {
                                for (Book book : v.checkoutList) {
                                    System.out.println(book.bookID + ": " + book.name);
                                }
                            } else {
                                System.out.println("No books checked out");
                            }
                            if (!v.reserveList.isEmpty()) {
                                //Print books for user
                                System.out.println("Reserved Books:");
                                for (Book book : v.reserveList) {
                                    System.out.println(book.bookID + ": " + book.name);
                                }
                            } else {
                                System.out.println("No books reserved");
                            }
                            break;
                    }
                }
            } else if(inputInt == 2) {
                while (inputInt != 0) {
                    System.out.println("Choose an option:\n" +
                            "1: Search Library\n" +
                            "2: View Book\n" +
                            "3: Checkout Book:\n" +
                            "4: Return Book:\n" +
                            "5: Reserve Book\n" +
                            "6: Unreserve Book\n" +
                            "7: View My Books\n" +
                            "8: Edit Library Book\n" +
                            "9: Add Library Book\n" +
                            "0: Quit\n");

                    //Handle Invalid Input
                    try {
                        inputInt = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input");
                        inputInt = -1;
                        scanner.next();
                    }

                    switch (inputInt) {
                        case 1:
                            //Search
                            System.out.print("Enter search string: ");
                            searchStr = scanner.next();

                            //Filters
                            System.out.print("Filter Comics? (y/n): ");
                            if (scanner.next().equals("y")) library.filterComics = true;
                            else library.filterComics = false;
                            System.out.print("Filter Novels? (y/n): ");
                            if (scanner.next().equals("y")) library.filterNovels = true;
                            else library.filterNovels = false;
                            System.out.print("Filter Textbooks? (y/n): ");
                            if (scanner.next().equals("y")) library.filterTextbooks = true;
                            else library.filterTextbooks = false;

                            //Print Results
                            ArrayList<Book> results = library.searchLibrary(searchStr);
                            System.out.println("Results:");
                            if (!results.isEmpty()) {
                                for (Book book : results) {
                                    System.out.println(book.bookID + ": " + book.name);
                                }
                            } else {
                                System.out.println("No Results");
                            }
                            break;
                        case 2:
                            //View Book
                            System.out.print("Enter bookID: ");
                            bookID = scanner.next();
                            l.viewBook(bookID);
                            break;
                        case 3:
                            //Checkout Book
                            System.out.print("Enter bookID: ");
                            bookID = scanner.next();
                            l.checkoutBook(bookID);
                            break;
                        case 4:
                            //Return Book
                            //Print books for user
                            System.out.println("Checked Out Books:");
                            for (Book book : l.checkoutList) {
                                System.out.println(book.bookID + ": " + book.name);
                            }

                            System.out.print("Enter bookID: ");
                            bookID = scanner.next();
                            l.returnBook(bookID);
                            break;
                        case 5:
                            //Reserve Book
                            System.out.print("Enter bookID: ");
                            bookID = scanner.next();
                            l.reserveBook(bookID);
                            break;
                        case 6:
                            //Print books for user
                            System.out.println("Reserved Books:");
                            for (Book book : l.reserveList) {
                                System.out.println(book.bookID + ": " + book.name);
                            }

                            //Unreserve Book
                            System.out.print("Enter bookID: ");
                            bookID = scanner.next();
                            l.unReserveBook(bookID);
                            break;
                        case 7:
                            //Print books for user
                            System.out.println("Checked Out Books:");
                            if (l.checkoutList != null) {
                                for (Book book : l.checkoutList) {
                                    System.out.println(book.bookID + ": " + book.name);
                                }
                            } else {
                                System.out.println("No books checked out");
                            }
                            if (!l.reserveList.isEmpty()) {
                                //Print books for user
                                System.out.println("Reserved Books:");
                                for (Book book : l.reserveList) {
                                    System.out.println(book.bookID + ": " + book.name);
                                }
                            } else {
                                System.out.println("No books reserved");
                            }
                            break;
                        case 8:
                            //Edit Book in Library
                            System.out.print("Enter bookID: ");
                            bookID = scanner.next();
                            l.editBook(bookID);
                            break;
                        case 9:
                            try {
                                //Add Library Book
                                System.out.println("Enter Type");
                                String type = scanner.next();
                                System.out.println("Enter Name");
                                String name = scanner.next();
                                System.out.println("Enter Author");
                                String author = scanner.next();
                                System.out.println("Enter Year");
                                String year = scanner.next();
                                l.createBook(type, name, author, year);
                            } catch (NoSuchElementException e) {
                                System.out.println("Cannot create a book of that type");
                            }
                            break;
                    }
                }
            }
        }
    }
}

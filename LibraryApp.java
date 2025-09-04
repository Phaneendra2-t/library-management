import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library();
        seedSample(library);

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Enter choice: ");
            switch (choice) {
                case 1:
                    addBookFlow(library);
                    break;
                case 2:
                    listBooksFlow(library);
                    break;
                case 3:
                    borrowFlow(library);
                    break;
                case 4:
                    returnFlow(library);
                    break;
                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("===== Library Management System =====");
        System.out.println("1. Add Book");
        System.out.println("2. List Books");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. Exit");
    }

    private static void addBookFlow(Library library) {
        System.out.println("-- Add Book --");
        String id = readString("ID: ");
        String title = readString("Title: ");
        String author = readString("Author: ");
        Book b = new Book(id, title, author);
        boolean ok = library.addBook(b);
        System.out.println(ok ? "Added." : "Failed: duplicate ID or invalid.");
    }

    private static void listBooksFlow(Library library) {
        System.out.println("-- Books --");
        List<Book> books = library.listBooks();
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private static void borrowFlow(Library library) {
        System.out.println("-- Borrow Book --");
        String id = readString("Enter Book ID: ");
        boolean ok = library.borrowBook(id);
        System.out.println(ok ? "Borrowed." : "Failed: not found or already borrowed.");
    }

    private static void returnFlow(Library library) {
        System.out.println("-- Return Book --");
        String id = readString("Enter Book ID: ");
        boolean ok = library.returnBook(id);
        System.out.println(ok ? "Returned." : "Failed: not found or not borrowed.");
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    private static void seedSample(Library library) {
        library.addBook(new Book("B1", "The Hobbit", "Tolkien"));
        library.addBook(new Book("B2", "Clean Code", "Robert C. Martin"));
        library.addBook(new Book("B3", "1984", "George Orwell"));
    }
}

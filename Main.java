package bookStoredProject;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBook Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    dbHandler.addBook(new Book(title, author, isbn));
                    break;
                case 2:
                    List<Book> books = dbHandler.getAllBooks();
                    for (Book book : books) {
                        System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() +
                                ", Author: " + book.getAuthor() + ", ISBN: " + book.getIsbn());
                    }
                    break;
                case 3:
                    System.out.print("Enter book ID to delete: ");
                    int id = scanner.nextInt();
                    dbHandler.deleteBook(id);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

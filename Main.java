// Main.java
// Entry point for the Personal Library Tracker console application.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManager manager = new LibraryManager();
        int choice = -1;

        do {
            System.out.println("\n=== Personal Library Tracker ===");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search by Genre");
            System.out.println("4. Mark Book as Read");
            System.out.println("5. Delete Book");
            System.out.println("6. View Summary");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                String invalid = sc.next();
                sc.nextLine(); // consume rest of line
                System.out.println("Invalid choice. Please enter a valid number (1-7).");
                continue;
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine().trim();
                    while (title.isEmpty()) {
                        System.out.print("Title cannot be empty. Enter Title: ");
                        title = sc.nextLine().trim();
                    }

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine().trim();
                    while (author.isEmpty()) {
                        System.out.print("Author cannot be empty. Enter Author: ");
                        author = sc.nextLine().trim();
                    }

                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine().trim();
                    while (genre.isEmpty()) {
                        System.out.print("Genre cannot be empty. Enter Genre: ");
                        genre = sc.nextLine().trim();
                    }

                    System.out.print("Status (Read/Unread): ");
                    String statusInput = sc.nextLine().trim();
                    String status = statusInput.equalsIgnoreCase("Read") || statusInput.equalsIgnoreCase("r") ? "Read" : "Unread";

                    manager.addBook(new Book(title, author, genre, status));
                    break;

                case 2:
                    manager.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Genre to search: ");
                    String searchGenre = sc.nextLine().trim();
                    manager.searchByGenre(searchGenre);
                    break;

                case 4:
                    System.out.print("Enter Title to mark as Read: ");
                    String readTitle = sc.nextLine().trim();
                    manager.markAsRead(readTitle);
                    break;

                case 5:
                    System.out.print("Enter Title to delete: ");
                    String delTitle = sc.nextLine().trim();
                    manager.deleteBook(delTitle);
                    break;

                case 6:
                    manager.showSummary();
                    break;

                case 7:
                    System.out.println("Goodbye! Happy reading.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        } while (choice != 7);

        sc.close();
    }
}

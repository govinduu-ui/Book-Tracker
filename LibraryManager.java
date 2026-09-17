// LibraryManager.java
// Handles adding, viewing, searching, updating, and persisting books to file.

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private static final String FILE_PATH = "data/books.txt";
    private List<Book> books;

    public LibraryManager() {
        books = new ArrayList<>();
        loadFromFile();
    }

    // Adds a new book, saves it to memory and file.
    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
            saveToFile();
            System.out.println("Book Added Successfully!");
        }
    }

    // Displays all books currently tracked.
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found in your library.");
            return;
        }
        System.out.println("\n=== Your Library ===");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    // Displays books filtered by genre (case-insensitive).
    public void searchByGenre(String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            System.out.println("Invalid genre search criteria.");
            return;
        }
        String cleanGenre = genre.trim();
        boolean found = false;
        System.out.println("\n=== Books in genre: " + cleanGenre + " ===");
        for (Book b : books) {
            if (b.getGenre().equalsIgnoreCase(cleanGenre)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found in this genre.");
        }
    }

    // Marks a book (by title, case-insensitive) as Read.
    public void markAsRead(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Book not found.");
            return;
        }
        String cleanTitle = title.trim();
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(cleanTitle)) {
                b.setStatus("Read");
                saveToFile();
                System.out.println("Marked \"" + b.getTitle() + "\" as Read.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Deletes a book (by title, case-insensitive) from the library.
    public void deleteBook(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Book not found.");
            return;
        }
        String cleanTitle = title.trim();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(cleanTitle)) {
                books.remove(i);
                saveToFile();
                System.out.println("Book deleted successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Prints a simple summary: total books, read count, unread count.
    public void showSummary() {
        int total = books.size();
        long readCount = books.stream().filter(b -> "Read".equalsIgnoreCase(b.getStatus())).count();
        long unreadCount = total - readCount;
        System.out.println("\n=== Library Summary ===");
        System.out.println("Total Books : " + total);
        System.out.println("Read        : " + readCount);
        System.out.println("Unread      : " + unreadCount);
    }

    // Writes all in-memory books to the data file, overwriting old contents.
    private void saveToFile() {
        try {
            File dir = new File("data");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(FILE_PATH), StandardCharsets.UTF_8))) {
                for (Book b : books) {
                    writer.write(b.toFileString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Loads books from the data file into memory at startup, if the file exists.
    private void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Book book = Book.fromFileString(line);
                    if (book != null) {
                        books.add(book);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}

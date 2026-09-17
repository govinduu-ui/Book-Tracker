// Book.java
// Represents a single book record in the Personal Library Tracker.

public class Book {
    private String title;
    private String author;
    private String genre;
    private String status; // "Read" or "Unread"

    public Book(String title, String author, String genre, String status) {
        this.title = title != null ? title.replace(",", " ").trim() : "";
        this.author = author != null ? author.replace(",", " ").trim() : "";
        this.genre = genre != null ? genre.replace(",", " ").trim() : "";
        this.status = (status != null && (status.equalsIgnoreCase("Read") || status.equalsIgnoreCase("r"))) ? "Read" : "Unread";
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = (status != null && (status.equalsIgnoreCase("Read") || status.equalsIgnoreCase("r"))) ? "Read" : "Unread";
    }

    // Converts the book into a comma-separated line for file storage.
    public String toFileString() {
        return title + "," + author + "," + genre + "," + status;
    }

    // Rebuilds a Book object from a stored comma-separated line.
    public static Book fromFileString(String line) {
        if (line == null || line.trim().isEmpty()) {
            return null;
        }
        String[] parts = line.split(",");
        if (parts.length < 4) {
            return null;
        }
        return new Book(parts[0], parts[1], parts[2], parts[3]);
    }

    @Override
    public String toString() {
        return "Title: " + title +
                " | Author: " + author +
                " | Genre: " + genre +
                " | Status: " + status;
    }
}

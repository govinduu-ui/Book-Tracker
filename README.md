# Personal Library Tracker

## Overview
The Personal Library Tracker is a Java console application designed to help readers manage and track their personal book collection. It utilizes Java file handling for persistent data storage without requiring external database dependencies.

## Problem Statement
Readers often need a lightweight method to organize books they own, track reading status (Read vs. Unread), and filter by genre. This application provides a CLI interface for managing personal reading lists.

## Features
- Add new books with title, author, genre, and reading status
- View all cataloged books in the collection
- Search books by genre
- Update book status to Read
- Remove books from the library
- Display library statistics summary (total, read, and unread counts)
- Persistent storage using local file handling

## Technologies
- Java (JDK 8+)
- Standard File IO (BufferedReader, BufferedWriter, UTF-8 Charset)

## Project Structure
```
Book-Tracker/
├── Book.java
├── LibraryManager.java
├── Main.java
├── README.md
└── data/
    └── books.txt
```

## How to Run

### 1. Clone the Repository
```bash
git clone https://github.com/govinduu-ui/Book-Tracker.git
```

### 2. Navigate to Project Directory
```bash
cd Book-Tracker
```

### 3. Compile Java Source Files
```bash
javac *.java
```

### 4. Run Application
```bash
java Main
```

## Sample Output
```text
=== Personal Library Tracker ===
1. Add Book
2. View All Books
3. Search by Genre
4. Mark Book as Read
5. Delete Book
6. View Summary
7. Exit
Enter choice: 1

Enter Title: Atomic Habits
Enter Author: James Clear
Enter Genre: Self-Help
Status (Read/Unread): Unread
Book Added Successfully!
```

## Data Storage
All book records are stored locally in:
```text
data/books.txt
```

Format:
```text
Atomic Habits,James Clear,Self-Help,Unread
1984,George Orwell,Dystopian,Read
```

## Core Concepts
- Object-Oriented Programming (OOP)
- Encapsulation & Data Modeling
- File Handling & Data Persistence
- Java Collections Framework (ArrayList)

## Future Enhancements
- Search by author or title
- Star ratings and personal notes
- Start/finish date tracking
- Graphical User Interface (Java Swing / JavaFX)

## Author
Govinda Das
24BCY10282

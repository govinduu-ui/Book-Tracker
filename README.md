# 📚 Personal Library Tracker (Java)

## 📌 Overview
The **Personal Library Tracker** is a simple Java console application that helps readers keep track of the books they own, are reading, or have finished. It uses file handling to store data, making it lightweight and easy to run without any database setup.

---

## 🎯 Problem Statement
Many readers lose track of which books they own, which they've already read, and which are still waiting on the shelf. This project provides a simple way to log, search, and manage a personal book collection.

---

## 🚀 Features
- ➕ Add new books (title, author, genre, status)
- 📄 View all books in your library
- 🔍 Search books by genre
- ✅ Mark a book as "Read"
- ❌ Delete a book from your library
- 📊 View a summary (total, read, unread counts)
- 💾 Persistent storage using file handling

---

## 🛠️ Technologies Used
- Java
- File Handling (BufferedReader, BufferedWriter)

---

## 📂 Project Structure
```
BYOP-Book-Tracker/
│   ├── Main.java
│   ├── Book.java
│   ├── LibraryManager.java
│   ├── README.md
│   └── data/
│       └── books.txt   (created automatically on first run)
```

---

## ▶️ How to Run the Project

### 1️⃣ Clone / Download the Project
```
git clone <your-repo-url>
```

### 2️⃣ Navigate to Project Folder
```
cd BYOP-Book-Tracker
```

### 3️⃣ Compile the Java Files
```
javac *.java
```

### 4️⃣ Run the Application
```
java Main
```

---

## 📸 Sample Output
```
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

---

## 💾 Data Storage
All books are stored in:
```
data/books.txt
```

Example:
```
Atomic Habits,James Clear,Self-Help,Unread
1984,George Orwell,Dystopian,Read
```

---

## 🧠 Concepts Used
- Object-Oriented Programming (OOP)
- Classes and Objects
- Encapsulation
- File Handling in Java
- Collections (ArrayList)

---

## ⚡ Future Enhancements
- 🔍 Search by author or title
- ⭐ Add star ratings and personal notes
- 📅 Track start/finish dates for each book
- 🎨 GUI version using Java Swing

---

## 👨‍💻 Author
Built as a companion project to the Student Expense Tracker BYOP project.

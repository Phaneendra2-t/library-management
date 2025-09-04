## Library Management (Console, Java)

A simple console-based library app to add, list, borrow, and return books. Built with plain Java.

### Features
- **Add book**: Create a book with `id`, `title`, and `author`.
- **List books**: View all books with borrowed status.
- **Borrow/Return**: Toggle a book's borrowed state by `id`.
- **Sample data**: Preloads a few books on startup.

### Project Structure
```
Book.java       // Data model for a book
Library.java    // In-memory store and operations
LibraryApp.java // CLI entry point and flows
```

### Prerequisites
- **JDK**: Java 11+ (recommended: 17 or later)
- **Shell**: Any (examples use PowerShell on Windows)

Verify Java is installed:
```bash
java -version
javac -version
```

### Build
From the project directory (where the `.java` files are located):
```bash
javac Book.java Library.java LibraryApp.java
```
This generates `.class` files in the same directory.

### Run
```bash
java LibraryApp
```

You should see a menu like:
```
===== Library Management System =====
1. Add Book
2. List Books
3. Borrow Book
4. Return Book
5. Exit
```

### Usage Notes
- Book IDs must be unique (e.g., `B1`, `B2`).
- Borrowing fails if the book is already borrowed or the `id` is unknown.
- Returning fails if the book is not currently borrowed or the `id` is unknown.

### Clean/Rebuild
Delete generated class files and recompile:
```bash
Remove-Item *.class  # PowerShell
# or
rm *.class           # bash
javac Book.java Library.java LibraryApp.java
```

### Troubleshooting
- If `java` or `javac` is not found, install the JDK and add it to `PATH`.
- Ensure you run commands from the directory containing `Book.java`, `Library.java`, and `LibraryApp.java`.

### License
MIT (or your preferred license)

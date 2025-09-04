import java.util.*;

public class Library {
    private final Map<String, Book> idToBook = new LinkedHashMap<>();

    public boolean addBook(Book book) {
        if (book == null || idToBook.containsKey(book.getId())) return false;
        idToBook.put(book.getId(), book);
        return true;
    }

    public List<Book> listBooks() {
        return new ArrayList<>(idToBook.values());
    }

    public Book findById(String id) {
        return idToBook.get(id);
    }

    public boolean borrowBook(String id) {
        Book b = idToBook.get(id);
        if (b == null || b.isBorrowed()) return false;
        b.setBorrowed(true);
        return true;
    }

    public boolean returnBook(String id) {
        Book b = idToBook.get(id);
        if (b == null || !b.isBorrowed()) return false;
        b.setBorrowed(false);
        return true;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();
    private int nextBookId = 1;
    private int nextUserId = 1;

    public void addBook(String title, String author) {
        Book book = new Book(nextBookId++, title, author);
        books.add(book);
        System.out.println("✅ Book added: " + book);
    }

    public void addUser(String name) {
        User user = new User(nextUserId++, name);
        users.add(user);
        System.out.println("✅ User added: " + user);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("📚 No books in the library.");
        } else {
            System.out.println("\n📚 Book List:");
            books.forEach(System.out::println);
        }
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("🙋 No users registered.");
        } else {
            System.out.println("\n🙋 User List:");
            users.forEach(System.out::println);
        }
    }

    public void issueBook(int bookId) {
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("❌ Book not found.");
        } else if (book.isIssued()) {
            System.out.println("⚠️ Book is already issued.");
        } else {
            book.issue();
            System.out.println("✅ Book issued successfully.");
        }
    }

    public void returnBook(int bookId) {
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("❌ Book not found.");
        } else if (!book.isIssued()) {
            System.out.println("⚠️ Book is not issued.");
        } else {
            book.returnBook();
            System.out.println("✅ Book returned successfully.");
        }
    }

    private Book findBookById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }
}

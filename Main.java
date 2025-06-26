import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n========= 📘 Library Menu =========");
            System.out.println("1. View Books");
            System.out.println("2. View Users");
            System.out.println("3. Add Book");
            System.out.println("4. Add User");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("➡️ Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1 -> library.displayBooks();
                case 2 -> library.displayUsers();
                case 3 -> {
                    System.out.print("📖 Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("✍️ Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                }
                case 4 -> {
                    System.out.print("🙋 Enter user name: ");
                    String name = scanner.nextLine();
                    library.addUser(name);
                }
                case 5 -> {
                    System.out.print("📤 Enter Book ID to issue: ");
                    int bookId = Integer.parseInt(scanner.nextLine());
                    library.issueBook(bookId);
                }
                case 6 -> {
                    System.out.print("📥 Enter Book ID to return: ");
                    int bookId = Integer.parseInt(scanner.nextLine());
                    library.returnBook(bookId);
                }
                case 7 -> {
                    System.out.println("👋 Exiting... Thank you!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }
}

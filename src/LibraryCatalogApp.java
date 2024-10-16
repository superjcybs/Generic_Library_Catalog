import java.util.Scanner;

public class LibraryCatalogApp {
    // This is the main Command-line Interface
    public static void main(String[] args) {
        Catalog<LibraryItem> catalog = new Catalog<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWelcome to the TS Library Catalog,What would you like to do?");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Catalog");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter item ID: ");
                    int itemID = scanner.nextInt();
                    LibraryItem item = new LibraryItem(title, author, itemID);
                    catalog.addItem(item);
                    break;

                case 2:
                    System.out.print("Enter the item ID to remove: ");
                    int removeID = scanner.nextInt();
                    catalog.removeItem(removeID);
                    break;

                case 3:
                    System.out.println("Current Catalog:");
                    catalog.viewItems();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}
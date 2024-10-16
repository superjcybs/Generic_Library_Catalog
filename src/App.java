import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Step 1: LibraryItem class
class LibraryItem {
    private String title;
    private String author;
    private int itemID;

    public LibraryItem(String title, String author, int itemID) {
        this.title = title;
        this.author = author;
        this.itemID = itemID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getItemID() {
        return itemID;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Item ID: " + itemID;
    }
}

// Step 2: Generic Catalog class
class Catalog<T extends LibraryItem> {
    private List<T> items = new ArrayList<>();

    // Add an item to the catalog
    public void addItem(T item) {
        items.add(item);
        System.out.println(item.getTitle() + " has been added to the catalog.");
    }

    // Remove an item by itemID
    public void removeItem(int itemID) {
        boolean itemRemoved = false;
        for (T item : items) {
            if (item.getItemID() == itemID) {
                items.remove(item);
                System.out.println("Item with ID " + itemID + " has been removed.");
                itemRemoved = true;
                break;
            }
        }
        if (!itemRemoved) {
            System.out.println("Item with ID " + itemID + " not found in the catalog.");
        }
    }

    // Retrieve details of all items in the catalog
    public void viewItems() {
        if (items.isEmpty()) {
            System.out.println("The catalog is empty.");
        } else {
            for (T item : items) {
                System.out.println(item);
            }
        }
    }
}

// Step 3: Command-line Interface
public class LibraryCatalogApp {
    public static void main(String[] args) {
        Catalog<LibraryItem> catalog = new Catalog<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Catalog");
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
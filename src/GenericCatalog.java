import java.util.ArrayList;
import java.util.List;

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
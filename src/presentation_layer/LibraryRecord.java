package presentation_layer;

import business_layer.LibraryItem;
import data_access_layer.FileIO;
import java.util.ArrayList;

/**
 * The {@code LibraryRecord} class represents a record of library items and provides methods to interact with the library items.
 */
public class LibraryRecord {

	private ArrayList<LibraryItem> libraryItems;

	 /**
     * Constructor for {@code LibraryRecord} class.
     * Initializes the {@code libraryItems} ArrayList by retrieving items from the file.
     */
	public LibraryRecord() {
		libraryItems = new FileIO().getLibraryItems();
	}

	/**
     * Displays the library record by printing each library item.
     */
	public void displayRecord() {
		for (LibraryItem libraryItem : libraryItems)
			System.out.println(libraryItem);
	}

	/**
     * Searches for a library item by its name.
     *
     * @param itemName The name of the library item to search for.
     * @return A message indicating whether the item exists or not.
     */
	public String searchLibraryItem(String itemName) {
		for (LibraryItem libraryItem : libraryItems) {
			if (libraryItem.exists(itemName))
				return "Exists " + libraryItem;
		}
		return "Does not exist.";
	}

	/**
     * Searches for a library item by its name and type.
     *
     * @param itemName The name of the library item to search for.
     * @param itemType The type of the library item to search for.
     * @return A message indicating whether the item exists or not.
     */
	public String searchLibraryItem(String itemName, String itemType) {
		for (LibraryItem libraryItem : libraryItems) {
			if (libraryItem.exists(itemName, itemType))
				return "Exists " + libraryItem;
		}
		return "Does not exist.";
	}

}

package business_layer;

/**
 * Interface representing searchable functionality.
 * This interface defines methods to check the existence of items based on various criteria.
 */
public interface Searchable {

	/**
     * Checks if an item with the given title exists.
     * 
     * @param title The title to search for.
     * @return {@code true} if an item with the title exists, otherwise {@code false}.
     */
	public boolean exists(String title);

	/**
     * Checks if an item with the given title and item type exists.
     * 
     * @param title    The title to search for.
     * @param itemType The type of item to search for.
     * @return {@code true} if an item with the title and item type exists, otherwise {@code false}.
     */
	public boolean exists(String title, String itemType);
}

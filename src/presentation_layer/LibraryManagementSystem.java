package presentation_layer;

 /**
 * The main class for the Library Management System.
 * It demonstrates the functionality of the LibraryRecord class.
 */
public class LibraryManagementSystem {

	/**
	 * The main method to start the {@code LibraryManagementSystem}.
	 *
	 * @param args Command-line arguments (not used in this application).
	 */
	public static void main(String[] args) {
		LibraryRecord libraryRecord = new LibraryRecord();
		libraryRecord.displayRecord();
		System.out.println(libraryRecord.searchLibraryItem("History of Art"));
		System.out.println(libraryRecord.searchLibraryItem("Animal Farm", "book"));
	}
}

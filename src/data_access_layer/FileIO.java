package data_access_layer;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import business_layer.*;


/**
 * The {@code FileIO} class handles reading data from a file and converting it into {@code LibraryItem} objects.
 * It reads a file containing information about library items and creates {@code LibraryItem} objects
 * based on the provided data.
 */
public class FileIO {

	private final int ITEM_NUMBER_INDEX = 0;
	private final int ITEM_TITLE_INDEX = 1;
	private final int PRIORITY_OF_ITEM_INDEX = 2;
	private final int LIBRARY_ITEM_TYPE_INDEX = 3;
	private final int AUTHOR_GENRE_INDEX = 4;
	private final int PUBLISHER_PRODUCER_INDEX = 5;
	private final int CUSTOMER_TYPE_INDEX = 6;
	private final int START_BORROW_INDEX = 7;
	private final int END_BORROW_INDEX = 8;

	private File libraryItemsFile;
	private Scanner libraryItemsInputFile;

	/**
     * Constructor for {@code FileIO} class.
     * Initializes the file input stream for reading library items from a file.
     */
	public FileIO() {
		libraryItemsFile = new File("src/items.csv");
		try {
			libraryItemsInputFile = new Scanner(libraryItemsFile);
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file items.csv.");
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	 /**
     * Reads the library items data from the file and creates a list of {@code LibraryItem} objects.
     *
     * @return An ArrayList containing the {@code LibraryItem} objects read from the file.
     */
	public ArrayList<LibraryItem> getLibraryItems() {

		ArrayList<LibraryItem> libraryItems = new ArrayList<>();

		while (libraryItemsInputFile.hasNextLine()) {

			String line = libraryItemsInputFile.nextLine();
			String[] data = line.split(";");
			for (String d : data)
				d = d.trim();
			
			int itemNumber = Integer.parseInt(data[ITEM_NUMBER_INDEX]);
			String title = data[ITEM_TITLE_INDEX];
			
			int priority = Priority.valueOf(data[PRIORITY_OF_ITEM_INDEX].
					toUpperCase().replaceAll(" ", "_")).getPriority();
			
			Member customerType = getCustomer(data[CUSTOMER_TYPE_INDEX]);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			LocalDate startBorrow = LocalDate.parse(data[START_BORROW_INDEX], formatter);
			LocalDate endBorrow = LocalDate.parse(data[END_BORROW_INDEX], formatter);
			
			if (data[LIBRARY_ITEM_TYPE_INDEX].equalsIgnoreCase("book")) {
				String author = data[AUTHOR_GENRE_INDEX];
				String publisher = data[PUBLISHER_PRODUCER_INDEX];
				libraryItems.add(new Book(itemNumber, title,
						priority, customerType, startBorrow, endBorrow, author, publisher));
			} else if (data[LIBRARY_ITEM_TYPE_INDEX].equalsIgnoreCase("magazine")) {
				String genre = data[AUTHOR_GENRE_INDEX];
				String producer = data[PUBLISHER_PRODUCER_INDEX];
				libraryItems.add(new Magazine(itemNumber, title,
						priority, customerType, startBorrow, endBorrow, genre, producer));
			}
		}
		return libraryItems;
	}

	private Member getCustomer(String customerType) {
		
		if (customerType.equalsIgnoreCase("general"))
			return new General();
		
		else if (customerType.equalsIgnoreCase("studentWScholar"))
			return new StudentWithScholarship();
		
		else if (customerType.equalsIgnoreCase("studentWOScholar"))
			return new StudentWithoutScholarship();
		
		else
			return null;
	}

}

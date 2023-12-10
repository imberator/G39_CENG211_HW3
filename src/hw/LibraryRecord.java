package hw;

import java.util.ArrayList;

public class LibraryRecord {

	private ArrayList<LibraryItem> libraryItems;

	public LibraryRecord() {
		libraryItems = new FileIO().getLibraryItems();
	}

	public void display() {

		for (LibraryItem libraryItem : libraryItems)
			System.out.println(libraryItem);
		
		
	}
}

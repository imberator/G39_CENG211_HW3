package hw;

import java.time.LocalDate;

public class Book extends LibraryItem {

	private static int LATE_CHARGE = 5;
	private static int ALLOWED_BORROWING_DAYS = 10;
	private static int BORROWING_CHARGE_PER_DAY = 5;

	private String authorName;
	private String publisher;

	public Book(int itemNumber, String title, int priority, Member customerType, LocalDate startBorrow,
			LocalDate endBorrow, String authorName, String publisher) {
		super(itemNumber, title, priority, customerType, startBorrow, endBorrow);
		this.authorName = authorName;
		this.publisher = publisher;
	}

	public Book(Book book) {
		if (book == null) {
			System.out.println("Book cannot be found!");
			System.exit(0);
		}
	}

	public double borrowingCharge() {

		return 0;
	}

	public double lateCharge() {

		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if (super.equals(o)) {
			Book otherBook = (Book) o;
			return authorName.equals(otherBook.authorName) && publisher.equals(otherBook.publisher);
		}
		return false;
	}

	public String toString() {
		return "Item Number: " + getItemNumber();
	}

	@Override
	public boolean exceed() {
		return (getDifferenceInDays() <= ALLOWED_BORROWING_DAYS) ? false : true;
	}
}

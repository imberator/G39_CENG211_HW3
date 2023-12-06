package hw;

import java.time.LocalDate;

public class Magazine extends LibraryItem {

	private static int LATE_CHARGE = 2;
	private static int ALLOWED_BORROWING_DAYS = 7;
	private static int BORROWING_CHARGE_PER_DAY = 10;

	private String genre;
	private String producer;

	public Magazine(int itemNumber, String title, int priority, Member customerType, LocalDate startBorrow,
			LocalDate endBorrow, String genre, String producer) {
		super(itemNumber, title, priority, customerType, startBorrow, endBorrow);
		this.genre = genre;
		this.producer = producer;
	}

	public Magazine(Magazine magazine) {
		if (magazine == null) {
			System.out.println("Magazine cannot be found!");
			System.exit(0);
		}
	}

	@Override
	public double borrowingCharge() {
		return BORROWING_CHARGE_PER_DAY * getDifferenceInDays();
	}

	@Override
	public double lateCharge() {
		return (exceed()) ? LATE_CHARGE : 0;
	}

	@Override
	public boolean exceed() {
		return (getDifferenceInDays() <= ALLOWED_BORROWING_DAYS) ? false : true;
	}
	
	@Override
	public boolean equals(Object o) {
		if (super.equals(o)) {
			Magazine otherMagazine = (Magazine) o;
			return genre.equals(otherMagazine.genre) && producer.equals(otherMagazine.producer);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Item Number: " + getItemNumber() + " Title: " + getTitle() + " Item Type: " + getClass().getSimpleName()
				+ " Borrowing Days: " + getDifferenceInDays() + " days " + "Exceed: " + getExceedString() + "Total Price: $" + totalPrice();
	}
}
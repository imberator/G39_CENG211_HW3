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

		return 0;
	}

	@Override
	public double lateCharge() {
		return 0;
	}

	@Override
	public boolean exceed() {
		return (getDifferenceInDays() <= ALLOWED_BORROWING_DAYS) ? false : true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
package hw;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class LibraryItem implements Borrowing, Searchable {

	private int itemNumber;
	private String title;
	private int priority;
	private Member customerType;
	private LocalDate startBorrow;
	private LocalDate endBorrow;

	public LibraryItem() {
		this(0000, "No title", 0, null, LocalDate.EPOCH, LocalDate.EPOCH);
	}

	public LibraryItem(int itemNumber, String title, int priority, Member customerType, LocalDate startBorrow,
			LocalDate endBorrow) {
		this.itemNumber = itemNumber;
		this.title = title;
		this.priority = priority;
		this.customerType = customerType;
		this.startBorrow = startBorrow;
		this.endBorrow = endBorrow;
	}

	public LibraryItem(LibraryItem item) {
		if (item == null) {
			System.out.println("Library item cannot be found!");
			System.exit(0);
		}
		this.itemNumber = item.itemNumber;
		this.title = item.title;
		this.priority = item.priority;
		this.customerType = item.customerType;
		this.startBorrow = item.startBorrow;
		this.endBorrow = item.endBorrow;
	}

	public int getDifferenceInDays() {
		return (int) ChronoUnit.DAYS.between(startBorrow, endBorrow);
	}

	public abstract boolean exceed();

	public String getExceedString() {
		if (exceed())
			return "Exceeds";
		else
			return "Not Exceeds";
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Member getCustomerType() {
		return customerType;
	}

	public void setCustomerType(Member customerType) {
		this.customerType = customerType;
	}

	public LocalDate getStartBorrow() {
		return startBorrow;
	}

	public void setStartBorrow(LocalDate startBorrow) {
		this.startBorrow = startBorrow;
	}

	public LocalDate getEndBorrow() {
		return endBorrow;
	}

	public void setEndBorrow(LocalDate endBorrow) {
		this.endBorrow = endBorrow;
	}

	public double discount() {
		return customerType.getDiscount() * borrowingCharge();
	}

	public double totalPrice() {
		return borrowingCharge() + lateCharge() - discount();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		else if (getClass() != o.getClass())
			return false;
		else {
			LibraryItem otherItem = (LibraryItem) o;
			return (itemNumber == otherItem.itemNumber && title == otherItem.title && priority == otherItem.priority
					&& customerType.equals(otherItem.customerType) && startBorrow.equals(otherItem.startBorrow)
					&& endBorrow.equals(otherItem.endBorrow));
		}
	}

	public abstract String toString();
}

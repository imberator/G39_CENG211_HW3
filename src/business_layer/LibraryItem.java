package business_layer;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * The {@code LibraryItem} class represents an abstract library item, providing common
 * attributes and methods for all types of items that can be borrowed.
 * It implements the {@code Borrowing} and {@code Searchable} interfaces.
 */
public abstract class LibraryItem implements Borrowing, Searchable {

	private int itemNumber;
	private String title;
	private int priority;
	private Member customerType;
	private LocalDate startBorrow;
	private LocalDate endBorrow;

	/**
     * Default constructor for the {@code LibraryItem} class.
     * Initializes attributes with default values.
     */
	public LibraryItem() {
		this(0000, "No title", 0, null, LocalDate.EPOCH, LocalDate.EPOCH);
	}

	/**
     * Parameterized constructor for the {@code LibraryItem} class.
     * Initializes attributes with specified values.
     *
     * @param itemNumber   The item number of the library item.
     * @param title        The title of the library item.
     * @param priority     The priority of the library item.
     * @param customerType The type of customer associated with the library item.
     * @param startBorrow  The start date of the borrowing period.
     * @param endBorrow    The end date of the borrowing period.
     */
	public LibraryItem(int itemNumber, String title, int priority, Member customerType, LocalDate startBorrow,
			LocalDate endBorrow) {
		this.itemNumber = itemNumber;
		this.title = title;
		this.priority = priority;
		this.customerType = customerType;
		this.startBorrow = startBorrow;
		this.endBorrow = endBorrow;
	}

	/**
     * Copy constructor for the {@code LibraryItem} class.
     * Creates a new {@code LibraryItem} object with the same attributes as the provided item.
     *
     * @param item The {@code LibraryItem} object to be copied.
     */
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

	/**
     * Calculates the difference in days between the start and end dates of the borrowing period.
     *
     * @return The difference in days as an integer.
     */
	public int getDifferenceInDays() {
		return (int) ChronoUnit.DAYS.between(startBorrow, endBorrow);
	}

	/**
     * Abstract method to check if the borrowing period exceeds the allowed duration.
     *
     * @return {@code true} if the borrowing period exceeds, {@code false} otherwise.
     */
	public abstract boolean exceed();

	/**
     * Gets a string indicating whether the borrowing period exceeds the allowed duration.
     *
     * @return "Exceeds" if the borrowing period exceeds, "Not Exceeds" otherwise.
     */
	public String getExceedString() {
		if (exceed())
			return "Exceeds";
		else
			return "Not Exceeds";
	}

	/**
     * Gets the item number of the library item.
     *
     * @return The item number as an integer.
     */
	public int getItemNumber() {
		return itemNumber;
	}

	/**
     * Gets the title of the library item.
     *
     * @return The title as a string.
     */
	public String getTitle() {
		return title;
	}

	/**
     * Gets the priority of the library item.
     *
     * @return The priority as an integer.
     */
	public int getPriority() {
		return priority;
	}

	/**
     * Gets the type of customer associated with the library item.
     *
     * @return The customer type as a {@code Member} object.
     */
	public Member getCustomerType() {
		return customerType;
	}

	/**
     * Gets the start date of the borrowing period.
     *
     * @return The start date as a {@code LocalDate} object.
     */
	public LocalDate getStartBorrow() {
		return startBorrow;
	}

	/**
     * Gets the end date of the borrowing period.
     *
     * @return The end date as a {@code LocalDate} object.
     */
	public LocalDate getEndBorrow() {
		return endBorrow;
	}

	/**
     * Calculates the discount based on the customer type.
     *
     * @return The discount as a double value.
     */
	public double discount() {
		return customerType.getDiscount() * borrowingCharge();
	}

	/**
     * Calculates the total price of the borrowing transaction,
     * considering borrowing charges, late charges, and discounts.
     *
     * @return The total price as a double value.
     */
	public double totalPrice() {
		return borrowingCharge() + lateCharge() - discount();
	}

	/**
     * Checks if the library item exists based on its title.
     *
     * @param title The title to be checked.
     * @return {@code true} if the title matches, {@code false} otherwise.
     */
	@Override
	public boolean exists(String title) {
		return this.title.equalsIgnoreCase(title);
	}
	
	/**
     * Checks if the library item exists based on its title and item type.
     *
     * @param title    The title to be checked.
     * @param itemType The item type to be checked.
     * @return {@code true if both title and item type match, {@code false} otherwise.
     */
	@Override
	public boolean exists(String title, String itemType) {
		return this.title.equalsIgnoreCase(title) &&
			   getClass().getSimpleName().equalsIgnoreCase(itemType);
	}

	 /**
     * Compares this {@code LibraryItem} with another object for equality.
     *
     * @param o The object to be compared.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
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

	 /**
     * Abstract method to generate a string representation of the {@code LibraryItem}.
     *
     * @return A string representation of the {@code LibraryItem}.
     */
	public abstract String toString();
}

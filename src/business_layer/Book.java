package business_layer;

import java.time.LocalDate;

/**
 * The {@code Book} class represents a book in the library.
 * It extends the {@code LibraryItem} class and includes additional
 * properties and methods specific to books.
 */
public class Book extends LibraryItem {

	
	private static int LATE_CHARGE = 5;
	private static int ALLOWED_BORROWING_DAYS = 10;
	private static int BORROWING_CHARGE_PER_DAY = 5;

	private String authorName;
	private String publisher;

	/**
     * Default constructor for the {@code Book} class.
     * Initializes default values for properties.
     */
	public Book() {
		super();
		this.authorName = "No author name";
		this.publisher = "No publisher";
	}
	
	/**
     * Parameterized constructor for the {@code Book} class.
     * Initializes properties with the provided values.
     *
     * @param itemNumber      The item number of the book.
     * @param title           The title of the book.
     * @param priority        The priority of the book.
     * @param customerType    The type of customer (member) borrowing the book.
     * @param startBorrow     The start date of the borrowing period.
     * @param endBorrow       The end date of the borrowing period.
     * @param authorName      The name of the author of the book.
     * @param publisher       The publisher of the book.
     */
	public Book(int itemNumber, String title, int priority, Member customerType, LocalDate startBorrow,
			LocalDate endBorrow, String authorName, String publisher) {
		super(itemNumber, title, priority, customerType, startBorrow, endBorrow);
		this.authorName = authorName;
		this.publisher = publisher;
	}

	 /**
     * Copy constructor for the {@code Book} class.
     * Creates a copy of the provided book.
     *
     * @param book The book to be copied.
     */
	public Book(Book book) {
		super(book);
		this.authorName = book.authorName;
		this.publisher = book.publisher;
	}

	/**
     * Calculates the borrowing charge for the book based on the
     * number of days it has been borrowed.
     *
     * @return The borrowing charge for the book.
     */
	public double borrowingCharge() {
		return BORROWING_CHARGE_PER_DAY * getDifferenceInDays() * getPriority();
	}

	/**
     * Calculates the late charge for the book if it has exceeded
     * the allowed borrowing days.
     *
     * @return The late charge for the book.
     */
	public double lateCharge() {
		return (exceed()) ? LATE_CHARGE : 0;
	}
	
	/**
     * Gets the name of the author of the book.
     *
     * @return The author's name.
     */
	public String getAuthorName() {
		return authorName;
	}

	/**
     * Gets the publisher of the book.
     *
     * @return The publisher of the book.
     */
	public String getPublisher() {
		return publisher;
	}

	/**
     * Checks if the book has exceeded the allowed borrowing days.
     *
     * @return {@code true} if the book has exceeded the allowed borrowing days, {@code false} otherwise.
     */
	@Override
	public boolean exceed() {
		return (getDifferenceInDays() <= ALLOWED_BORROWING_DAYS) ? false : true;
	}

	/**
     * Compares this book with another object for equality.
     *
     * @param o The object to compare with.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
	@Override
	public boolean equals(Object o) {
		if (super.equals(o)) {
			Book otherBook = (Book) o;
			return authorName.equals(otherBook.authorName) && publisher.equals(otherBook.publisher);
		}
		return false;
	}

	/**
     * Returns a string representation of the book, including its item number, title,
     * item type, borrowing days, exceed status, and total price.
     *
     * @return A string representation of the book.
     */
	@Override
	public String toString() {
		return "Item Number: " + getItemNumber() + ", Title: " + getTitle() + ", Item Type: " + getClass().getSimpleName()
				+ ", Borrowing Days: " + getDifferenceInDays() + " days" + ", Exceed: " + getExceedString() + ", Total Price: $" + totalPrice();
	}

}

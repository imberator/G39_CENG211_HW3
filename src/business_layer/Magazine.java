package business_layer;

import java.time.LocalDate;

/**
 * The {@code Magazine} class represents a magazine item in the library, extending the {@code LibraryItem} class.
 * It provides specific functionality for calculating borrowing charges, late charges, and checking if
 * the borrowing period exceeds the allowed duration for magazines.
 */
public class Magazine extends LibraryItem {

    private static int LATE_CHARGE = 2;
    private static int ALLOWED_BORROWING_DAYS = 7;
    private static int BORROWING_CHARGE_PER_DAY = 10;
   
    private String genre;
    private String producer;

    /**
     * Default constructor for the {@code Magazine} class.
     * Initializes attributes with default values.
     */
    public Magazine() {
        super();
        this.genre = "No genre";
        this.producer = "No producer";
    }

    /**
     * Parameterized constructor for the {@code Magazine} class.
     * Initializes attributes with specified values.
     *
     * @param itemNumber   The item number of the magazine.
     * @param title        The title of the magazine.
     * @param priority     The priority of the magazine.
     * @param customerType The type of customer associated with the magazine.
     * @param startBorrow  The start date of the borrowing period.
     * @param endBorrow    The end date of the borrowing period.
     * @param genre        The genre of the magazine.
     * @param producer     The producer of the magazine.
     */
    public Magazine(int itemNumber, String title, int priority, Member customerType, LocalDate startBorrow,
                    LocalDate endBorrow, String genre, String producer) {
        super(itemNumber, title, priority, customerType, startBorrow, endBorrow);
        this.genre = genre;
        this.producer = producer;
    }

    /**
     * Copy constructor for the {@code Magazine} class.
     * Creates a new {@code Magazine} object with the same attributes as the provided magazine.
     *
     * @param magazine The {@code Magazine} object to be copied.
     */
    public Magazine(Magazine magazine) {
        super(magazine);
        this.genre = magazine.genre;
        this.producer = magazine.producer;
    }

    /**
     * Calculates the borrowing charge for the magazine.
     * The charge is based on the number of days the magazine is borrowed.
     *
     * @return The borrowing charge as a double value.
     */
    @Override
    public double borrowingCharge() {
        return BORROWING_CHARGE_PER_DAY * getDifferenceInDays() * getPriority();
    }

    /**
     * Calculates the late charge for the magazine.
     * The charge is applied if the borrowing period exceeds the allowed duration.
     *
     * @return The late charge as a double value.
     */
    @Override
    public double lateCharge() {
        return (exceed()) ? LATE_CHARGE : 0;
    }

    /**
     * Checks if the borrowing period for the magazine exceeds the allowed duration.
     *
     * @return {@code true} if the borrowing period exceeds, {@code false} otherwise.
     */
    @Override
    public boolean exceed() {
        return (getDifferenceInDays() > ALLOWED_BORROWING_DAYS);
    }

    /**
     * Gets the genre of the magazine.
     *
     * @return The genre as a string.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Gets the producer of the magazine.
     *
     * @return The producer as a string.
     */
    public String getProducer() {
        return producer;
    }

    /**
     * Compares this {@code Magazine} with another object for equality.
     * Additionally checks the equality of genre and producer.
     *
     * @param o The object to be compared.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            Magazine otherMagazine = (Magazine) o;
            return genre.equals(otherMagazine.genre) && producer.equals(otherMagazine.producer);
        }
        return false;
    }

    /**
     * Generates a string representation of the {@code Magazine} object.
     *
     * @return A string representation of the magazine.
     */
    @Override
    public String toString() {
        return "Item Number: " + getItemNumber() + ", Title: " + getTitle() + ", Item Type: "
                + getClass().getSimpleName() + ", Borrowing Days: " + getDifferenceInDays() + " days" + ", Exceed: "
                + getExceedString() + ", Total Price: $" + totalPrice();
    }
}

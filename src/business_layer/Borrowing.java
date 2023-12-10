package business_layer;

/**
 * The Borrowing interface defines methods related to borrowing operations.
 * Implementing classes should provide functionality for calculating borrowing charges,
 * late charges, discounts, and the total price of the borrowing transaction.
 */
public interface Borrowing {
    
    /**
     * Calculates the borrowing charge for the operation.
     *
     * @return The borrowing charge as a double value.
     */
    public double borrowingCharge();
    
    /**
     * Calculates the late charge for the operation.
     *
     * @return The late charge as a double value.
     */
    public double lateCharge();
    
    /**
     * Calculates any applicable discount for the borrowing operation.
     *
     * @return The discount as a double value.
     */
    public double discount();
    
    /**
     * Calculates the total price of the borrowing operation,
     * considering borrowing charges, late charges, and discounts.
     *
     * @return The total price as a double value.
     */
    public double totalPrice();
}

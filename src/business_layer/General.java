package business_layer;

/**
 * The {@code General} class represents a general member in the borrowing system,
 * extending the {@code Member} class.
 * It is a default member type with no initial discount.
 */
public class General extends Member {

    /**
     * Constructs a General member with an initial discount of zero.
    */
    public General() {
        super(0);
    }
}

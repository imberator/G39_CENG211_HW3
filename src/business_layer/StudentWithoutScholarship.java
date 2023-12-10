package business_layer;

/**
 * Represents a student without a scholarship. Extends the {@code Student}
 * class.
 */
public class StudentWithoutScholarship extends Student {

	/**
	 * Default constructor for {@code StudentWithoutScholarship}. Initializes a
	 * student without a scholarship with a discount of 20%.
	 */
	public StudentWithoutScholarship() {
		super(0.2);
	}
}

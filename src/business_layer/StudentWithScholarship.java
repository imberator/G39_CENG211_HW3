package business_layer;

/**
 * Represents a student with scholarship.
 * Extends the {@code Student} class.
 */
public class StudentWithScholarship extends Student {

	/**
     * Default constructor for {@code StudentWithScholarship}.
     * Initializes a student with scholarship with a discount of 30%.
     */
	public StudentWithScholarship() {
		super(0.3);
	}
}

package business_layer;

/**
 * Abstract class representing a student.
 * This class extends the {@code Member} class and serves as a blueprint for different types of students.
 * It provides a structure for common attributes and behaviors shared among students.
 */
public abstract class Student extends Member {

	/**
     * Default constructor for {@code Student}.
     * Constructs a {@code Student} object without specifying any discount.
     */
	public Student() {
		super();
	}
	
	/**
     * Constructor for {@code Student} with a discount.
     *
     * @param discount The discount value applicable to the student.
     *                 This value represents a reduction in fees or prices for the student.
     */
	public Student(double discount) {
		super(discount);
	}
	
}

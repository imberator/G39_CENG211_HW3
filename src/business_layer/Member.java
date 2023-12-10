package business_layer;

/**
 * Abstract class representing a member in a business application. 
 * A member is an entity that can be associated with a discount in the system.
 */
public abstract class Member {

	private double discount;

	/**
     * Default constructor for {@code Member}, 
	 * initializes with no discount.
     */
	public Member() {
		this.discount = 0;
	}

	/**
     * Constructor for {@code Member} with a discount.
     * 
     * @param discount The discount value for the member.
     */
	public Member(double discount) {
		this.discount = discount;
	}
	
	/**
     * Copy constructor for {@code Member}.
	 * Creates a copy of the provided member.
     * 
     * @param member Another {@code Member} object to copy discount from.
     */
	public Member(Member member) {
		if (member == null) {
			System.out.println("Member not found!");
			System.exit(0);
		}
		this.discount = member.discount;
	}

	/**
     * Get the discount value for the {@code Member}.
     * 
     * @return The discount value.
     */
	public double getDiscount() {
		return discount;
	}

	/**
     * Checks if the current {@code Member} object is equal to another object.
     * 
     * @param o The object to compare.
     * @return {@code true} if the objects are equal, otherwise {@code false}.
     */
	@Override
	public boolean equals(Object o) {

		if (o == null)
			return false;
		else if (getClass() != o.getClass())
			return false;
		else {
			Member otherMember = (Member) o;
			return discount == otherMember.discount;
		}
	}
	
	/**
     * Generates a string representation of the discount.
     * 
     * @return String representation of the discount.
     */
	@Override
	public String toString() {
		return "Discount: %" + discount*100;
	}
}

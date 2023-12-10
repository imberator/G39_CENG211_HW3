package business_layer;

/**
 * Enumeration representing different levels of priority that can be assigned to items or tasks in a system.
 * The levels are defined as constants within the enum: NOTEWORTHY, HIGHLY_SIGNIFICANT, and INVALUABLE.
 */
public enum Priority {
	NOTEWORTHY(1), HIGHLY_SIGNIFICANT(2), INVALUABLE(3);
	
	private final int priority;

	/**
     * Constructor for {@code Priority} enum.
     * @param priority The integer value representing the priority level.
     */
	Priority(int priority) {this.priority = priority;}

	/**
     * Gets the priority value.
     * @return The integer value representing the priority level.
     */
	public int getPriority() {return priority;}
}

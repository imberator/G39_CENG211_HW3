package hw;

public enum Priority {
	NOTEWORTHY(1), HIGHLY_SIGNIFICANT(2), INVALUABLE(3);
	private final int priority;
	Priority(int priority) {this.priority = priority;}
	public int getPriority() {return priority;}
}

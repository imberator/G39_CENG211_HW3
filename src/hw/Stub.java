package hw;

public class Stub {

	public static void main(String[] args) {
		Priority priority = Priority.valueOf("noteworthy".toUpperCase().replaceAll(" ", "_"));
		System.out.println(priority);
		
	}
}

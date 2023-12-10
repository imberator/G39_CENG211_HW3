package hw;

public class Stub {

	public static void main(String[] args) {
		Priority priority = Priority.valueOf("highly significant".toUpperCase().replace(" ", "_"));
		System.out.println(priority);
		
		String str = "qwuılegq";
		System.out.println(str.getClass().getSimpleName());
	
		System.out.println(Integer.parseInt("101"));
	}
	
}

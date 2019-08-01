
public class Student {
	private static int idInitializer =100;
	private final int id;
	//int id;
	String name;
	String gender = "male";
	
	Student( String name) {   //constructor
		this.name =name;  // invokes the other constructor by passing name value
		id = ++idInitializer;
		System.out.println("ID: " + id);
	}
	
	
	
	boolean updateProfile(String name) {
		this.name =name;
		return true;
	}
}

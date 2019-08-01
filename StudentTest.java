
public class StudentTest {
	public static  void  main(String[] args) {
		//int[] studentIds = new int[] {1001,1002,1003};
		
		Student student1 = new Student("joan");
		student1.gender = "male";
		
		Student student2 = new Student(  "raj");
		student2.gender = "male";
		
		Student student3 = new Student(  "anitha");
		student3.gender = "female";
		
		System.out.println("Name of Student1:" + student1.name);
		System.out.println("Name of Student2:" + student2.name);
		System.out.println("Name of Student3:" + student3.name);
		
		student1.updateProfile("john");
		System.out.println("Updated Name of Student1:" + student1.name);
 
		Student student4 = student1;  //student4 and student1 points to same memory address
		System.out.println("Name of Student4:" + student4.name);
		
		student4.updateProfile("mike");
		System.out.println("Name of Student1:" + student1.name);
		
		student4 = student2; //reinitializing object reference 
		System.out.println("Name of Student4:" + student4.name);
		
		student2 =student1;
		System.out.println("Name of Student4:" + student4.name); //student4 holds the same memory address of raj
		System.out.println("Name of Student2:" + student2.name);
		
		student4 = new Student("Alex");
		System.out.println("Name of Student4:" + student4.name);
		System.out.println("Name of Student2:" + student2.name);
		System.out.println("Name of Student1:" + student1.name);
		
	}
}

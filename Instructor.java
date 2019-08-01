
public class Instructor {
	    public long id;
		public String name;
		public String title;
		public String department;
		public Book[] books;
		//this() vs this reference. this() should be first statement
		public Instructor(long id, String name, String title, String department, Book[] books) {
			this(id,name,title,department);
			this.books = books;// your code
		}
		
		public Instructor(long id, String name, String title, String department) {
		    this(id,name,title);
		    this.department =department;// your code
		}
		
		public Instructor(long id, String name, String title) {
			this(id,name);
			this.title =title;// your code
		}
		
		public Instructor(long id, String name) {
		this.id =id;
		this.name =name;// your code
		}
		
		public String getMostRecentBookTitle() {
		    
			   return books[books.length-1].getTitle();
		 //hard coding return books[2].getTitle()
	
		}
		
		public Book updateBook(int index, String title) {
			Book old = new Book(books[index].getTitle());
			books[index].setTitle(title);
			return old;
		}
			// your code
			
			/*Common Mistakes 
			 #Not using temp variable
			 #oldbook and books[index] refer to same book object
			 Book oldbook = books[index];
			*/
		
		/*
		 #Version 2 of above method 
		 Book oldbook = new Book(); //need to add noarg constructor in Book class
		 oldbook.setTitle(books[index].getTitle());
		 books[index].setTitle(title);
		 return oldBook;
		 
				*/
		
		
		public Book updateBook(int index, Book book) {
			Book oldVal = books[index];  //refers to book[1] memory addr
			books[index]= book;// book[1] memory addr updated with book[4]
			return oldVal;
		}
		
		public static void main(String[] args) {
			Book book1 = new Book("Java for Beginners");
	        Book book2 = new Book("Scala for Beginners");
	        Book book3 = new Book("Effective Python");
			
			Instructor instructor = new Instructor(101, "John", "Assistant Professor", "Computer Science", new Book[]{book1, book2, book3});
			System.out.println(instructor.getMostRecentBookTitle());
			System.out.println("old book title: " + instructor.updateBook(1, "Effective C#").getTitle());
					
			Book book4 = new Book("Introduction to Data Mining");
			System.out.println("old book title: " + instructor.updateBook(1, book4).getTitle());
		}
	}


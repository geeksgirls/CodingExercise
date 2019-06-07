
public class Recursion {
	
	int x = 0;
	int y =1;
	int z =0;
	public static int factorial(int n){
		if(n==0){
			return 1;
		}
		return n* factorial(n-1);
	}
	
	public  void fibonacci(int num) {
		
		if(num >0){
			z = x+y;
			System.out.println(z + " ");
			x=y;
			y=z;
			fibonacci(num-1); 
			System.out.println("num "+num);
			 // if num-- used stack overflow error but --n is working
		}	
	}
	public static int binarySearch(int[] a , int l, int h, int key) {
		if(l == h) {
			if(key == a[l] ){
				return l;
			}else {
				return -1;
			}
		}
		int mid=(l+h)/2;
		if(key == a[mid]) {
			return mid;
		}else if(key > a[mid]) {
			return binarySearch(a,mid+1,h,key);
		}else{
			return binarySearch(a,l,mid-1,key);
		}
	}
	public static void main(String[] args) {
		int[] a =  {11,19,34,56,78,91,99};
		int index = binarySearch(a,0,6,11);
		System.out.println(index);
		System.out.println(factorial(4));	// Clearer Code (slightly slow)
		
		//Fibonacci Execution
		Recursion f = new Recursion();
		System.out.println(f.x + "\n" +f.y);
		
		f.fibonacci(7-2);
	}
}
		
		/* public class Recursion {
			
			static int factorialNR(int n) {
				if (n == 0 || n == 1) {
					return 1;
				}
				
				int factorial = n;
						
				while (n >= 2) { 
					factorial = factorial * (n - 1); // 4 * 3 = 12 * 2 = 24 * 1 = 24
					n--; // 3, 2, 1
				}
			
				return factorial;
			}
			
			            	    	   
			static int factorial(int n) {
				if (n == 0) {
					return 1;
				}
				return n * factorial(n-1);     
		    }
			
			// O(log(n)): 
			public static int binarySearch(int a[], int l, int h, int key) { 
				if (l == h) {
					if (key == a[l]) {
						return l;
					} else {
						return -1;
					}
				}
				
				int mid = (l + h)/2;
				
				if (key == a[mid]) {
					return mid;
				} else if (key > a[mid]) {
					return binarySearch(a, mid+1, h, key);
				} else {
					return binarySearch(a, l, mid-1, key);
				}
			}
				
			
			public static void main(String[] args) {
		        System.out.println(factorialNR(4));	
				System.out.println(factorial(4));	// Clearer Code (slightly slow)   		
				int[] a = {11, 19, 24, 34, 55, 65, 71, 83, 91}; 
				int index = binarySearch(a, 0, 8, 100);
				System.out.println("index: " + index);
		    }
		}

		
		  When recursion?
		      Problem addressed via similar sub-problems
		      e.g., Binary Search, Towers of Hanoi, Word Frequency Count
		*/

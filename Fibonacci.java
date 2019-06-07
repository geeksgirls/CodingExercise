
public class Fibonacci {
	
	void fibonacci(int n,int z) {
		int x =0;
		int y =1;
		
		System.out.print(x +" "+y+" ");
		
		while(n>=2){
			z = x+y;
			
			System.out.println(z + " ");
			
			x=y;
			y=z;
			n--;
		}
		
		for(int i=n; i>=2; i--){
			z = x+y;
			
			System.out.println(z + " ");
			
			x=y;
			y=z;
		}
	}
	public static void main(String[] args){
		int n =5;
		int z =0;
		Fibonacci f = new Fibonacci();
	
		f.fibonacci(n,z);
		
	}
}

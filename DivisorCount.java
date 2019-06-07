
public class DivisorCount {
	public static void main(String[] args) {
		int count = 0;
		int num = 24;
		System.out.println("List of divisors");
		for (int i =1; i <= num; i++) {
			if (num % i ==0 ) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println("\nDivisors count = " + count);
	}
}

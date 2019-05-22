import java.util.*;

public class GuessingGame {
	public static void main(String[] args) {
		int random = 8;
		System.out.println("Enter a number from 1-10");
		
		int guess = 0;
		Scanner sc = new Scanner(System.in);
		
		
		do{
			
			guess = sc.nextInt();
			if(guess == random){
				System.out.println("You are right!!");
			}else {
			if(guess>random){
				System.out.println("Hint: Guess a smaller number");
			}
			else{
				System.out.println("Hint: Guess a larger number");
			}
			}
			
			
		}while(guess!=random);
	}
}

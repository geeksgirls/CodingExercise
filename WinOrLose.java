
import java.util.*;
public class WinOrLose {
	
	//Techgig coding - 4/5/2019
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		int length = sc.nextInt();
		int[] villain = new int[length];
		int[] player = new int[length];
		int count =0;
		for(int i =0; i<length; i++){
			villain[i]= sc.nextInt();
		}
		
		for(int j =0; j<length; j++){
			player[j]= sc.nextInt();
		}
		
		Arrays.sort(villain);
		Arrays.sort(player);
		
		for(int k =0; k<length;k++){
			if(player[k]> villain[k]){
				count++;
			}
			else{
			}
			}
		
		if(count==length){
			System.out.println("WIN");
		}
		else{
			System.out.println("LOSE");
		}
		}
	
	}


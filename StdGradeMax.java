
public class StdGradeMax {
	public static void main(String[] args) {
		int[][] stdGrades = { { 78,67,57,89,90}, {34,56,78,45}, {76,45,67,84}, {90,76,56}};
		for(int i =0; i<stdGrades.length;i++) {
			int max =0;
			System.out.println("\nDisplaying grades of section " + i) ;
			for(int j=0; j<stdGrades[i].length;j++){
				
				if (stdGrades[i][j] > max) {
					max = stdGrades[i][j];
				}
				System.out.print(stdGrades[i][j] + " ");
				
			}
			System.out.println("\nMax grade =" + max);
			
		}
	}
}

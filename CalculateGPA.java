
import com.pluralsight.exceptions.InvalidDataException;
import com.pluralsight.exceptions.MissingGradeException;

public class CalculateGPA {


	    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException {
	    	
	    	// Your code: throw IllegalArgumentException with the 
	    	//message that lengths of input arrays are out-of-sync
	    	
	    	//parameter validation
	    	if(studentIdList.length != studentsGrades.length){
	    		throw new IllegalArgumentException("studentIdList and studentsGrade are out-of-sync. studentIdList ="+studentIdList.length +",studentsGrades ="+studentsGrades.length);
	    	}
	    	double[] gpa = new double[studentIdList.length];
	    
	        for(int i=0; i<studentIdList.length;i++){// your code
	        	int points =0;
	        	for(int j=0; j<studentsGrades[i].length; j++){
	        		//char grade = 'A';
	        		
	        		if(studentsGrades[i][j] == 'A'){
	        				points += 4;
	        		}else if(studentsGrades[i][j] == 'B'){
	        			points += 3;
	        		}else if(studentsGrades[i][j] == 'C'){
	        			points += 2;
	        		}else if (studentsGrades[i][j] == ' ') {
	                    // student is yet to receive a grade
	                    // Your code: throw checked exception MissingGradeException with student ID
	        			throw new MissingGradeException(studentIdList[i]);
	                }
	        				        	
	        	}
	        
	        gpa[i] = (double)points/(double)studentsGrades[i].length;
	       
	        }
	        return gpa;
	        
	    }
	    
	    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades)  {
	        // perform parameter validation. Return null if passed parameters are not valid
	        if(lower < 0 || higher < 0 || lower>higher) {
	        	return null;
	        }
	        // invoke calculateGPA
	        int count =0;
	        double[] gpa = new double[studentIdList.length];
			try {
				 //double[] gpa;
				gpa = calculateGPA(studentIdList, studentsGrades);
				} catch (MissingGradeException e) {
					//e.printStackTrace();
					// TODO Auto-generated catch block
					// Your code: catch MissingGradeException and re-throw runtime exception InvalidDataException
					//initialized with the cause MissingGradeException
					
							InvalidDataException e1 =  new InvalidDataException();
							e1.initCause(e);
							 throw e1;
						//	e1.printStackTrace();
		}
					
					
				
					
				
			
	        // construct the result array and return it. You would need an extra for loop to compute the size of the resulting array
	        
	        for( int i =0;  i < gpa.length; i++){
	        	if(gpa[i]>lower && gpa[i]<higher) {
	        		System.out.println(studentIdList[i]);
	        		count++;
	        	}
	        
	        } 
	        
	        /*for (double gpa : gpaList) {
	            if (gpa >= lower && gpa <= higher) {
	                count++;
	            }}*/

	        int[] result = new int[count];
	        for(int k=0; k<result.length; k++){
	        for(int j=0; j<gpa.length; j++){
	        	if(gpa[j] > lower && gpa[j]<higher){
	        		result[k]=studentIdList[j];
	        	}
	        }
	        }
	       
			
			return result;
	    }
	    
	    public static void main(String[] args){
	    	int[] studentIdList = {1001,1002};
	    	char[][] studentsGrades = {{'A','A','C','B'},
	    			{'B',' ','B'}};
	    	int[] res=getStudentsByGPA(3.2,3.7,studentIdList,studentsGrades);
	    	//System.out.println(count);
	    	 
	    	
	    	/*for(int i =0; i< res.length;i++){
	    		System.out.println(res[i]);
	    	}*/
	    	
	    }
	    
	}


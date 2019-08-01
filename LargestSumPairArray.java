
public class LargestSumPairArray {
	
	/*Given an unsorted of distinct integers, find the largest pair sum in it. For example, the largest pair sum in {12, 34, 10, 6, 40} is 74.
	Difficulty Level: Rookie
	Expected Time Complexity: O(n) [Only one traversal of array is allowed]

	Recommended: Please try your approach on {IDE} first, before moving on to the solution.
	This problem mainly boils down to finding the largest and second largest element in array. We can find the largest and second largest in O(n) time by traversing array once.

	1) Initialize both first and second largest
	   first = max(arr[0], arr[1])
	   second = min(arr[0], arr[1])
	2) Loop through remaining elements (from 3rd to end)
	   a) If the current element is greater than first, then update first 
	       and second. 
	   b) Else if the current element is greater than second then update 
	    second
	3) Return (first + second)*/
	
	static int arr[] = new int[]{12, 34, 10, 6, 40}; 
    
    /* Method to return largest pair sum. Assumes that  
       there are at-least  two elements in arr[] */
	 static int findLargestSumPair() 
	    { 
	        // Initialize first and second largest element 
	        int first, second; 
	        if (arr[0] > arr[1]) 
	        { 
	            first = arr[0]; 
	            second = arr[1]; 
	        } 
	        else
	        { 
	            first = arr[1]; 
	            second = arr[0]; 
	        } 
	       
	        // Traverse remaining array and find first and second largest 
	        // elements in overall array 
	        for (int i = 2; i<arr.length; i ++) 
	        { 
	            /* If current element is greater than first then update both 
	              first and second */
	            if (arr[i] > first) 
	            { 
	                second = first; 
	                first = arr[i]; 
	            } 
	       
	            /* If arr[i] is in between first and second then update second  */
	            else if (arr[i] > second && arr[i] != first) 
	                second = arr[i]; 
	        } 
	        return (first + second); 
	    } 
	 
	 public static void main(String[] args){
		 System.out.println("Max Pair Sum is " + findLargestSumPair()); 
	 }
}

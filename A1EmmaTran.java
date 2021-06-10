import java.util.Arrays;
import java.util.Random;

/**
* 
* A1EmmaTran
* COMP 2140 SECTION A01
* INSTRUCTOR Cuneyt Akcora
* ASSIGNMENT Assignment #1
* @author Emma Tran, 7876069, tranmb@myumanitoba.ca
* @version Monday, Feb 24th
*
* PURPOSE: write a Java program that times the execution of three sorting
algorithms (radix sort, merge sort, quick sort) and reports on the run times and whether the algorithms
actually sorted the list
*/

public class A1EmmaTran{
	
	// QUESTION 1: A RECURSIVE MERGE SORT ALGORITHM
	public static void mergeSort(int[] arr)
	{
		 if (arr == null) //arr means array 
     	{return;}
         if (arr.length < 2)
     	{return;}
		
		int[] temp = new int[arr.length];
		mergeSort(arr, 0, arr.length, temp);
		
	}//end driver public method mergeSort
	
	private static void mergeSort(int[] arr, int start, int end, int[] temp)
	{
		int mid;
		if (1< end-start) // when there is more than 1 element in the list 
		{
			mid = start + (end-start)/2;
			mergeSort(arr, start, mid, temp);
			mergeSort(arr, mid, end, temp);
			merge(arr, start, mid, end, temp);
		}
		if (end-start<2)  //when there is less than 2 element in the list then do nothing
		{
			return;
		}
	} // end helper method mergeSort
	
	private static void merge(int[] arr, int start, int mid, int end, int[] temp)
	{
		int currL = start; //current item in left half
		int currR = mid; //current item in right half
		int currT; //current in temp array 
		
		for (currT = start; currT<end; currT++)
		{
			if (currL <mid && (currR >= end || arr[currL] < arr[currR]))
			{
				temp[currT] = arr[currL];
				currL++;
			}
		
		    else 
		    {
			    temp[currT] = arr[currR];
			    currR++;
			
		    }
	    }
		for (currT = start; currT < end; currT++)
		{
			arr[currT] = temp[currT];
		}
	 }	//end merge method
	
	
	//QUESTION 2: A RECURSIVE MERGE SORT ALGORITHM THAT 
	//DOES NOT USE A SHARED TEMP ARRAY
	public static void mergeSortInefficeient(int[] arr)
	{
		 if (arr == null) 
     	{return;}
         if (arr.length < 2)
     	{return;}
		mergeSortInefficeient(arr, 0, arr.length);
	} //end public driver mergeSortInefficeient
	
	private static void mergeSortInefficeient(int[] arr, int start, int end)
	{
		int mid;
		if (1< end-start)
		{
			mid = start + (end-start)/2;
			mergeSortInefficeient(arr, start, mid);
			mergeSortInefficeient(arr, mid,end);

			merge(arr, start, mid, end);
		}
	} //end helper method mergeSortInefficeient
	
	private static int[] merge(int[] arr, int start, int mid, int end)
	{
		int count = arr.length; 
		int[] sorted = new int[count]; //create an array with the size of passed array 
		                                // to store the sorted value from the list
		int currL = start;
		int currR = mid;
		int currT;
		
		for (currT = start; currT<end; currT++)
		{
			if (currL <mid && (currR >= end || arr[currL] < arr[currR]))
			{
				sorted[currT] = arr[currL];
				currL++;
			}
		
		    else 
		    {
			    sorted[currT] = arr[currR];
			    currR++;
			
		    }
	    }
		for (currT = start; currT < end; currT++)
		{
			arr[currT] = sorted[currT];
		}
		return sorted;
	 }	//end merge method
	
	
	//QUESTION 3 RECURSIVE QUICK SORT
	public static void quickSort(int[] arr) {
        if (arr == null) 
        	{return;}
        if (arr.length < 2)
        	{return;}
        quickSort(arr, 0, arr.length);
        for (int i =0; i <arr.length; i++)
        {
        //System.out.print(arr[i]); 
	}
       
    } 

    private static void quickSort(int[] a, int start, int end) {
        if (2 == (end - start)) {
            if (a[start + 1] < a[start]) {
                swap(a, start, start + 1);
            } //if there are only 2 elements in the list, 
            //check then swap if needed

        }
        if (start + 2 < end) { //more than 3 elements 
            int pivot = partition(a, start, end);

            quickSort(a, start, pivot); //pivot shifted 1 positon past so dont need +1
            quickSort(a, pivot + 1, end); //after pivot
        }
    }
     
    private static void pivot(int[] arr, int start, int end)//median of three method
    {
    	// find the smallest element then swap it to the first index position
    	end = end-1;
    	int mid = (start+end)/2;
    	if(arr[mid] <arr[start]) 
    	{
    		swap(arr, mid, start);
    	}
    	if (arr[end] < arr[start])
    	{
    		swap(arr, end, start);
    	}
    	if (arr[mid] >arr[end])
    	{
    		swap(arr,mid, end);
    		swap(arr, mid, end-1);
    	}
    }
    
    private static int partition(int[] arr, int start, int end) {
        pivot(arr, start, end); //put the pivot to the 1st element in array 
        int pivot = arr[start];
        int bigStart = (start + 1);

        //check these elements in the list with the pivot and swap if needed 
        for (int curr = start + 1; curr < end; curr++) {
            if (arr[curr] < pivot) {
                swap(arr, bigStart, curr);
                bigStart++;
            }
        }

        swap(arr, start, bigStart - 1);

        return bigStart - 1;
    }

    //helper method to swap elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    
    //QUESTION 4: RADIX SORT 
    public static void radixSort(int arr[]) {
        int maximumNumber = findMaximumNumberIn(arr);
        int numberOfDigits = calculateNumberOfDigitsIn(maximumNumber);
        int currDigit = 1;

        while (numberOfDigits-- > 0) {
            sort(arr, currDigit);
            currDigit *= 10;
        }
    }

    private static void sort(int[] arr, int currDigit) {
        int range = 10; 

        int length = arr.length;
        int[] frequency = new int[range];
        int[] sortedValues = new int[length];

        for (int i = 0; i < length; i++) {
            int value = (arr[i] / currDigit) % range;
            frequency[value]++;
        }

        for (int i = 1; i < range; i++) {
            frequency[i] += frequency[i - 1];
        }

        for (int i = length - 1; i >= 0; i--) {
            int digit = (arr[i] / currDigit) % range;
            sortedValues[frequency[digit] - 1] = arr[i];
            frequency[digit]--;
        }

        System.arraycopy(sortedValues, 0, arr, 0, length);//copy sorted values to a
    }

    private static int calculateNumberOfDigitsIn(int number) {
        return (int) Math.log10(number) + 1; // valid only if number > 0
    }

    private static int findMaximumNumberIn(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }
    
    
    //QUESTION 5: VERIFIES SORTED ORDER METHOD
    
    public static boolean checkSorted(int[]arr){
        int error = 0;
        boolean value = true;
        //check for error, loop through the list to check if it is sorted
        for(int i=0; i<arr.length-1; i++)
        {
          if(arr[i]>arr[i+1])
          { 
            error++; 
          }
        }
        if(error > 0)
        {
          value = false;
        }
        return value;
      }
    
    //QUESTION 6: FILL ARRAY METHOD
    public static void fillArray(int[] arr){
        int length = arr.length;
        for(int i=0; i<length; i++){
          arr[i] = i;    
        }
      }
    
    //QUESTION 7: RANDOMIZE ARRAY WITH NUMBER METHOD
    public static void randomize(int[] arr, int n){
        int temp;
        int random1,random2;
        int swaps=0;
        while(swaps!=n){
         random1=(int)(arr[new Random().nextInt(arr.length)]);//choose random index position 
         random2=(int)(arr[new Random().nextInt(arr.length)]); //choose random index position 
         temp = arr[random1];
         arr[random1]=arr[random2];
         arr[random2]=temp;
         swaps++;
        }
      } 
    
    //QUESTION 8: TESTING METHOD
    private static void testSortMethods(int[]arr) {
        boolean sortvalue;
        fillArray(arr);
        long start, stop, elapsedTime;  // Time how long sorting takes
        long timings[] = new long[100];
        
        // Test the merge sort using shared array 
        for(int i=0;i<8;i++){
          randomize(arr,8);
          start = System.nanoTime();
          mergeSort(arr);
          stop = System.nanoTime();
          elapsedTime = stop - start;
          sortvalue = checkSorted(arr);
          timings[i]=elapsedTime;
          if(sortvalue == false){
            System.out.println("MERGE SORT USING SHARED ARRAY is not sorted!");
          }
        }
        double result1 = arithmeticMean(timings);
        System.out.println( "Arthemetic mean for MERGE SORT USING SHARED ARRAY is "+ result1 +" nanosecs." );
        
        
     // Test the merge sort NOT using shared array 
        for(int i=0;i<8;i++){
            randomize(arr,1250);
            start = System.nanoTime();
            mergeSortInefficeient(arr);
            stop = System.nanoTime();
            elapsedTime = stop - start;
            sortvalue = checkSorted(arr);
            timings[i] = elapsedTime;
            if(sortvalue == false){
              System.out.println("MERGE SORT NOT USING SHARED ARRAY is not sorted!");
            }
          }
          double result2 = arithmeticMean(timings);
          System.out.println( "Arthemetic mean for MERGE SORT NOT USING SHARED ARRAY is "+ result2 +" nanosecs." );
          
          
        // Test the quick Sort
        for(int i=0;i<8;i++){
            randomize(arr,8);
            start = System.nanoTime();
            quickSort(arr);
            stop = System.nanoTime();
            elapsedTime = stop - start;
            sortvalue = checkSorted(arr);
            timings[i] = elapsedTime;
            if(sortvalue == false){
              System.out.println("QUICK SORT is not sorted!");
            }
          }
          double result3 = arithmeticMean(timings);
          System.out.println( "Arthemetic mean for QUICK SORT is "+ result3 +" nanosecs." );
          
       // Test the Radix Sort
          for(int i=0;i<8;i++){
              randomize(arr,8);
              start = System.nanoTime();
              radixSort(arr);
              stop = System.nanoTime();
              elapsedTime = stop - start;
              sortvalue = checkSorted(arr);
              timings[i] = elapsedTime;
              if(sortvalue == false){
                System.out.println("RADIX SORT is not sorted!");
              }
            }
            double result4 = arithmeticMean(timings);
            System.out.println( "Arthemetic mean for RADIX SORT is "+ result4 +" nanosecs." );
                  
    }
    
    //QUESTION 9:ARITHMETIC MEAN OF TIMINGS
    public static double arithmeticMean( long data[] ) {
        double sum = 0;
        for (int i = 0; i < data.length; i++)
          sum += (double)data[i];
          return sum / (double)data.length;
        
      } // end arithmeticMean
    
  //QUESTION 10: MAIN METHOD
	  public static void main(String[]args)
	  {
		    int[] array= new int[8];
		    testSortMethods(array);
	  }
    
}

//REPORT 
//
//cited: code resources based on instructor and course COMP2140 given information.
//
//QUESTION 1:
//   No || Alg Name       || Alg Size || Time(ms)
// --------------------------------------------------
//   1. || Merge Sort     || 10,000   || 858179.8
//         (shared array) || 20,000   || 1729880.86
//                        || 30,000   || 2527854.69
//                        || 40,000   || 3145588.31
//                        || 50,000   || 4161968.7
//
//	 2. || Merge Sort     || 10,000   || 4.076364846E7
//         (not shared)   || 20,000   || 1.4106805142E8
//                        || 30,000   || 3.0675691886E8
//                        || 40,000   || 5.0090357094E8
//                        || 50,000   || 8.1940670536E8
//	
//   3. || Quick Sort     || 10,000   || 605065.06
//                        || 20,000   || 1252547.36
//                        || 30,000   || 1977969.37
//                        || 40,000   || 2747916.88
//                        || 50,000   || 3394712.51
//   
//   4. || Radix Sort     || 10,000   || 893895.32
//                        || 20,000   || 1597246.04
//                        || 30,000   || 2209560.7
//                        || 40,000   || 2798808.58
//                        || 50,000   || 3324275.83
//
//QUESTION 2:
//Quick sort was faster than merge sort (the efficient version). 
//Because merge sort uses extra space for the temporary array, 
//while quick sort is in-place sorting; therefore, quick sort was faster.
// 
//QUESTION 3:
//The cost of using inefficient merge sort in this case is 3.9905468660000004E7 ms later. 
//
//QUESTION 4:
//Radix sort was faster than merge sort (the efficient version) in this case. 



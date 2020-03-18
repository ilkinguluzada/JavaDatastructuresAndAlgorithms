package algorithmshw1;

import java.util.ArrayList;

/*
 *  Both the deterministic and randomized quicksort algorithms have the same
 *  best-case running times of O(nlgn) and the same worst-case running times of O(n2). 
 *  The difference is that with the deterministic algorithm, a particular input can 
 *  elicit that worst-case behavior.  With the randomized algorithm, however, no input 
 *  can always elicit the worst-case behavior. 
 *  Reference: https://www.quora.com/How-does-randomized-quick-sort-perform-better-than-the-standard-quick-sort-algorithm-Why-should-anybody-care-about-a-sorting-method-that-is-not-optimal
 *  
 *  Using the normal quicksort algorithm can be vulnerability means that 
 *  in one particular input it would always pick worst case
 *  becuase pivoting is standart, but in randomized one, it always differ.
 *  
 *  
 * Analyzing from test cases, Quick Sort works 
 * faster than Randomized Quick Sort Algorithm if the 
 * number of elements to be sorted is low. (See Test Case 1) But the Quick Sort
 * with Randomized pivoting usually is faster when the array size is
 * getting higher. (See Test Case 2)
 */


public class QuickSortAnalysis {
	public static void main(String args[]){
		
		long started, ended;
		System.out.println("----------------------------");
		System.out.println("Analysing Timing");
		System.out.println("----------------------------"); 
		//Quick Sort Test 1
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(10);
		arr1.add(7);
		arr1.add(1);
		arr1.add(5);
		int n1 = arr1.size(); 
		
		System.out.println("Quick Sort Test 1:"); 
		started = System.nanoTime();
		System.out.println("Time started: " + started);
		QuickSort.sort(arr1, 0, n1-1); 
		ended = System.nanoTime();
		System.out.println("Time ended  : " + ended);
		QuickSort.printArrayList(arr1); 
		System.out.println("Time executed: " + (ended - started)); 

		System.out.println("----------------------------"); 
		
		//Randomized Quick Sort Test 1
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(10);
		arr2.add(7);
		arr2.add(1);
		arr2.add(5);

		int n2 = arr1.size();
		System.out.println("Randomized QuickSort Test 1:"); 
		started = System.nanoTime();
		System.out.println("Time started: " + started);
		QuickSortRandomized.sort(arr2, 0, n2-1); 
		ended = System.nanoTime();
		System.out.println("Time ended  : " + ended);
		QuickSort.printArrayList(arr2); 
		System.out.println("Time executed: " + (ended - started)); 
		
		System.out.println("----------------------------"); 
		
		//Quick Sort Test 2
		ArrayList<Integer> arr3 = new ArrayList<Integer>();
		arr3.add(7);
		arr3.add(3);
		arr3.add(10);
		arr3.add(9);
		arr3.add(2);
		arr3.add(4);
		arr3.add(1);
		arr3.add(6);
		arr3.add(8);
		arr3.add(11);
		arr3.add(13);
		arr3.add(12);
		arr3.add(14);
		arr3.add(15);
		arr3.add(19);

		int n3 = arr3.size(); 
		System.out.println("Quick Sort Test 2:");
		started = System.nanoTime();
		System.out.println("Time started: " + started);
		QuickSort.sort(arr3, 0, n3-1); 
		ended = System.nanoTime();
		System.out.println("Time ended  : " + ended);
		QuickSort.printArrayList(arr3); 
		System.out.println("Time executed: " + (ended - started)); 

		System.out.println("----------------------------"); 
		
		//Quick Sort Test 2
		ArrayList<Integer> arr4 = new ArrayList<Integer>();
		arr4.add(7);
		arr4.add(3);
		arr4.add(10);
		arr4.add(9);
		arr4.add(2);
		arr4.add(4);
		arr4.add(1);
		arr4.add(6);
		arr4.add(8);
		arr4.add(11);
		arr4.add(13);
		arr4.add(12);
		arr4.add(14);
		arr4.add(15);
		arr4.add(19);


		int n4 = arr4.size(); 
		System.out.println("Randomized Quick Sort Test 2:"); 
		started = System.nanoTime();
		System.out.println("Time started: " + started);
		QuickSortRandomized.sort(arr4, 0, n4-1); 
		ended = System.nanoTime();
		System.out.println("Time ended  : " + ended);
		QuickSort.printArrayList(arr4); 
		System.out.println("Time executed: " + (ended - started)); 

		System.out.println("----------------------------"); 

	}
}

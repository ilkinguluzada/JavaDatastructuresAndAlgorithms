package algorithmshw1;

import java.util.ArrayList;

public class QuickSort { 
	
	static long t = 0;
	
	public static void swap(ArrayList<Integer> arr, int i, int j){
        int temp= arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
	
	public static int partition(ArrayList<Integer> arr, int low, int high){
        
        int last = high;
        
        while(low <= high){
            if( arr.get(low) < arr.get(last) ) low++;
            else {
                swap(arr, low, high);
                high--;
            }
        }
        swap(arr, low, last);
        return low;
    }
	
	public static void sort(ArrayList<Integer> arr, int low, int high){
		 	t += System.nanoTime();
		 	if(low>=high) return;
	        if(low<0) return;
	        if(high>arr.size()-1) return;
	        int pivot = partition(arr, low, high);
	        sort(arr, low, pivot-1);
	        sort(arr, pivot+1, high);
	 }
	
	static void printArrayList(ArrayList<Integer> arr){ 
        int n = arr.size(); 
        for (int i=0; i<n; ++i) 
        System.out.print(arr.get(i)+" "); 
        System.out.println(); 
    }
	
	static void printArray(int arr[]){ 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
        System.out.print(arr[i] + " "); 
        System.out.println(); 
    }
    
    public static void main(String args[]){ 
        
    	ArrayList<Integer> arr1 = new ArrayList<Integer>();
    	arr1.add(10);
    	arr1.add(7);
    	arr1.add(8);
    	arr1.add(9);
    	arr1.add(1);
    	arr1.add(5);

        int n1 = arr1.size(); 
        QuickSort.sort(arr1, 0, n1-1); 
        System.out.println("QuickSort:"); 
        printArrayList(arr1); 
                
    } 
}


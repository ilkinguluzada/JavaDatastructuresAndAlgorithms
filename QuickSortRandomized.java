package algorithmshw1;

import java.util.ArrayList;

class QuickSortRandomized { 
    static long t = 0;
    public static void swap(ArrayList<Integer> arr, int i, int j){
        int temp= arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    
    public static int partition(ArrayList<Integer> arr, int low, int high){
        
        int random = low + ( (int) Math.random() * (arr.size()) ) / (high - low + 1);
        int last = high;
        swap(arr, random, high);
        high--;
        
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
        t+=System.nanoTime();
    	if(low>=high) return;
        if(low<0) return;
        if(high>arr.size()-1) return;
        int pivot = partition(arr, low, high);
        sort(arr, low, pivot-1);
        sort(arr, pivot+1, high);
    }
    
    public static void main(String args[]){ 
        
    	ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(10);
		arr2.add(7);
		arr2.add(8);
		arr2.add(9);
		arr2.add(1);
		arr2.add(5);

	    int n2 = arr2.size(); 
	    QuickSortRandomized.sort(arr2, 0, n2-1); 
	    System.out.println("Randomized QuickSort:"); 
	    QuickSort.printArrayList(arr2); 
                
    } 
    
     
      
}

package algorithmshw1;

import java.util.ArrayList;
import java.util.Collections;

public class MaxHeap {
	
	protected static int[] Heap; 
	protected static int size; 
  
    public MaxHeap(int arr[], int n){ 
    	  
        size = 0; 
        Heap = new int[n + 1]; 
        Heap[0] = arr[0];
    	  
        for (int i = 1; i < n; i++) { 
        	this.insert(arr[i]);
        } 
    } 
    
    protected int getParent(int i){ 
        return i / 2; 
    } 
  
    protected static int getLeftChild(int i){ 
        return (2 * i); 
    } 
    
    protected static int getRightChild(int i){ 
        return (2 * i) + 1; 
    } 
  
    protected static boolean isLeaf(int i){ 
        if (i >= (size / 2) && i <= size) return true; 
        return false; 
    } 
  
    protected static void swap(int i, int j){ 
        int temp; 
        temp = Heap[i]; 
        Heap[i] = Heap[j]; 
        Heap[j] = temp; 
    } 
	
	public void sort(int arr[]){ 
		
	     int n = arr.length; 
	     for (int i = n / 2 - 1; i >= 0; i--) maxHeapify(i); 

	     for (int i = n-1; i >= 0; i--){ 
	         int temp = arr[0]; 
	         arr[0] = arr[i]; 
	         arr[i] = temp; 
	         maxHeapify(0); 
	     } 
	 } 
	 
	 public void insert(int e){ 
	        Heap[++size] = e; 
	        int crrnt = size; 
	        while (Heap[crrnt] > Heap[getParent(crrnt)]) { 
	            swap(crrnt, getParent(crrnt)); 
	            crrnt = getParent(crrnt); 
	        } 
	 } 


	 protected static void maxHeapify(int i){ 
		 
	        if (isLeaf(i)) return; 
	  
	        if ( Heap[i] < Heap[getLeftChild(i)] || Heap[i] < Heap[getRightChild(i)] ) { 
	  
	            if (Heap[getLeftChild(i)] > Heap[getRightChild(i)]) { 
	                swap(i, getLeftChild(i)); 
	                maxHeapify(getLeftChild(i)); 
	            }else { 
	                swap(i, getRightChild(i)); 
	                maxHeapify(getRightChild(i)); 
	            } 
	        } 
	 } 
	 
	 public int extractMax(){ 
	        int extracted = Heap[0]; 
	        Heap[0] = Heap[size--]; 
	        maxHeapify(0); 
	        return extracted; 
	 }

	 public void print(){ 
	        for (int i = 0; i <= size / 2; i++) { 
	            System.out.print(" Root : " + Heap[i] + " Left : " + Heap[2 * i] + " Right :" + Heap[2 * i + 1]); 
	            System.out.println(); 
	        } 
	 } 
	 
	 
	 
	 static ArrayList<String> printPretty(int index, int[] array) {
		    int child1 = 2 * index + 1;
		    int child2 = 2 * index + 2;
		    if (child1 >= array.length) {
		        return new ArrayList<>(Collections.singletonList(toText(index, array)));
		    } else {
		    	ArrayList<String> childl1 = printPretty(child1, array);
		        if (child2 < array.length) {
		            joinLists(childl1, printPretty(child2, array));
		        }
		        String text = toText(index, array);
		        int currentLength = childl1.get(0).length();

		        if (currentLength >= text.length()) {
		            text = pad(text, (currentLength - text.length()) / 2, currentLength);
		        } else {
		            for (int i = 0, size = childl1.size(); i < size; i++) {
		                childl1.set(i, pad(childl1.get(i), (currentLength - text.length()) / 2, currentLength));
		            }
		        }

		        childl1.add(0, text);
		        return childl1;
		    }
	 }
	 
	 
	 static String pad(String s, int lright, int l) {
		    StringBuilder sbuilder = new StringBuilder();
		    for (int i = l - lright - s.length(); i > 0; i--) sbuilder.append(' ');
		    sbuilder.append(s);
		    for (int i = 0; i < lright; i++) sbuilder.append(' ');
		    return sbuilder.toString();
	 }

	 static StringBuilder addSpaces(String s, int sc) {
		    StringBuilder sbuilder = new StringBuilder(s.length() + sc).append(s);
		    for (int i = 0; i < sc; i++) sbuilder.append(' ');
		    return sbuilder;
	 }

	 static void joinLists(ArrayList<String> l1, ArrayList<String> l2) {
		    int i;
		    final int size = l2.size();
		    for (i = 0; i < size; i++) {
		        l1.set(i, addSpaces(l1.get(i), 2).append(l2.get(i)).toString());
		    }
	 }

	 static String toText(int i, int[] arr) {
		    return Integer.toString(arr[i]) + '(' + i + ')';
	 }

	 public static void main(String args[]){ 
		 
	     int arr[] = {12, 11, 13, 5, 6, 7}; 
	     int n = arr.length; 
	     
	     //Building Max Heap
	     MaxHeap ob = new MaxHeap(arr, n); 
	     System.out.println("Max Heap");
	     ob.print(); 
	     
	     System.out.println();
	     
	     //BONUS TASK: Printing Max Heap Pretty
	     System.out.println("Pretty Max Heap");
	     printPretty(0, MaxHeap.Heap).forEach(System.out::println);
	     
	     System.out.println();
	     
	     //Sorting array with Heap Sort
	     ob.sort(arr);
	     System.out.println("Sorted");
	     QuickSort.printArray(Heap);
	     
	     System.out.println();
	     
	     //Extracting maximum
	     ob.extractMax();
	     System.out.println("Extracted Max Heap");
	     ob.print(); 
	     
	     
	 } 
}

package algorithmshw1;

/*
 * A priority queue is an abstract datatype. It is a shorthand
 *  way of describing a particular interface and behavior, and 
 *  says nothing about the underlying implementation.A heap 
 *  is a data structure. It is a name for a particular way of 
 *  storing data that makes certain operations very efficient.
 *  It just so happens that a heap is a very good data structure 
 *  to implement a priority queue, because the operations which 
 *  are made efficient by the heap data strucure are the operations 
 *  that the priority queue interface needs.
 *  
 *  Reference: https://stackoverflow.com/questions/18993269/difference-between-priority-queue-and-a-heap
 */

public class PriorityQueue extends MaxHeap {
    
	public PriorityQueue(int[] Heap, int n) {
		super(Heap, n);
	}
	
	public int heapMax ()
	{
		return Heap[0];
	}
	
	void increaseKey(int i, int key)
	{
		if( key < Heap[i]) System.out.println("Opss, Key should be greater than current key!");
		Heap[i] = key;
		int temp;
		while ( i > 0 && Heap[getParent(i)] < Heap[i]){
			temp = Heap[i];
			Heap[i] = Heap[getParent(i)];
			Heap[getParent(i)] = temp;
			i = getParent(i);
		}
	}
	
	public static void main(String args[]){ 
		 
	     int Heap[] = {12, 11, 13, 5, 6, 7}; 
	     int n = Heap.length; 
	     
	     //Building Max Heap
	     PriorityQueue ob = new PriorityQueue(Heap, n); 
	     System.out.println("Priority Queue");
	     ob.print();
	     
	     System.out.println();
	     System.out.println("Max value: " + ob.heapMax());
	     
	     System.out.println();
	     
	     //Extracting maximum
	     ob.extractMax();
	     System.out.println("Extracted Priority Queue");
	     ob.print(); 
	     
	     System.out.println();
	     System.out.println("Max value: " + ob.heapMax());
	     System.out.println();
	     
	     //Increasing key
	     ob.increaseKey(3, 15);
	     System.out.println("Increased Key Priority Queue");
	     ob.print(); 
	     
	     
	 } 
}

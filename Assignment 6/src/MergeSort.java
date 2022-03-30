import java.util.Random; //For random number generation
//Implementation of the top-down merge sort algorithm.
public class MergeSort {
	
	public MergeSort() {

	}
	
	//Utility function that generates random values for input array, with values ranging from 0 to (u-1)
	public void fill(int[] a, int u) {
		Random r = new Random();
		int upperLimit = u;
		
		for(int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(upperLimit);
		}
	}
	
	//Utility function that prints values of the input array from index 0
	public void print(int[] a) {
		for(int i = 0; i < a.length; i++) {
			if(i == a.length - 1) {
				System.out.print(a[i]);
			} else {
				System.out.print(a[i] + ", ");
			}
		}
	}

	private int first(int[] a) {
		return a[0];
	}
	
	public int[] merge_sort(int[] a) {
		//Base case
		if(a.length <= 1) {
			 return a;
		}
		
		//Recursive case
		//Define left and right arrays and index counters
		int[] left;
		int[] right;
		int index = 0;
		int indL = 0;
		int indR = 0;
		//Define array lengths
		//If-else statement included for non-even arrays
		if(a.length % 2 == 0) {
			left = new int[a.length /2];
			right = new int[a.length /2];
		} else {
			left = new int[a.length /2];
			right = new int[(a.length /2) + 1];
		}
		
		//Add values to left and right
		for(int e: a) {
			if(index < (a.length / 2)) {
				//add e to left
				left[indL] = e;
				indL += 1;
				index += 1;
			} else {
				//add e to right
				right[indR] = e;
				indR += 1;
				index += 1;
			}
		}
		
		//Recursively sort sublists
		left = merge_sort(left);
		right = merge_sort(right);
		
		//merge the sorted sublists
		return merge(left, right);
	}
	
	private int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		//tempL and tempR used to keep length checks accurate
		int[] tempL = left;
		int[] tempR = right;
		int index = 0;
		int indL = 0;
		int indR = 0;

		//Compare and add values to result until one ind is = the length of its original array
		while(indL != left.length && indR != right.length) {
			if(first(tempL) <= first(tempR)) {
				result = append(result, first(tempL), index);
				tempL = collapse(tempL);
				
				indL += 1;
				index += 1;
			} else {
				result = append(result, first(tempR), index);
				tempR = collapse(tempR);
				
				indR += 1;
				index += 1;
			}
		}
		
		//For any leftover values after one array reaches the end
		while(indL != left.length) {
			result = append(result, first(tempL), index);
			tempL = collapse(tempL);
			indL += 1;
			index += 1;
		}
		
		while(indR != right.length) {
			result = append(result, first(tempR), index);
			tempR = collapse(tempR);
			indR += 1;
			index += 1;
		}
		return result;
	}
	
	//Add value into a at pos
	private int[] append(int[] a, int value, int pos) {
		int[] tempArray = a;
		
		tempArray[pos] = value;
		return tempArray;
	}
	
	//Collapse arrays for merge function by removing first value
	private int[] collapse(int[] a) {
		int[] tempArray = new int[a.length - 1];
		
		for(int i = 0; i < tempArray.length; i++) {
			tempArray[i] = a[i + 1];
		}
		
		return tempArray;
	}
	
}

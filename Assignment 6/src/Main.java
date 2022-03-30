
public class Main {

	public static void main(String[] args) {
		MergeSort microsoft = new MergeSort();
		int[] activisionBlizzard = new int[100];
		
		microsoft.fill(activisionBlizzard, 201);
		
		System.out.println("Oringal array unsorted: ");
		microsoft.print(activisionBlizzard);
		System.out.println("");
		System.out.println("");
		
		System.out.println("Array sorted: ");
		microsoft.print(microsoft.merge_sort(activisionBlizzard));
		System.out.println("");
		System.out.println("");
		
		//Confirming that original array is unchanged
		System.out.println("Confirmation of original array: ");
		microsoft.print(activisionBlizzard);

	}

}

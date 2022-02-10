public class Main {
	public static void main(String[] args) {
		CustomArray array1 = new CustomArray();
		
		//array1.print();
		array1.insert(1, 0);
		array1.insert(2, 0);
		array1.insert(3, 0);
		array1.insert(4, 0);
		array1.insert(5, 0);
		array1.insert(6, 0);
		array1.print();
		System.out.println("");
		
		array1.update(7, 2);
		array1.print();
		System.out.println("");
		
		array1.delete(2);
		array1.print();
		System.out.println("");
	}

}

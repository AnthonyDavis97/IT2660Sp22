public class Main {

	public static void main(String[] args) {
		
		LinkedList test = new LinkedList(new Node("A"));
		test.append(new Node("B"));
		test.print();
		
		test.append(new Node("C"));
		test.append(new Node("D"));
		test.append(new Node("E"));
		test.insertAt(new Node("Z"), 3);
		test.print();
		
		test.insertAt(new Node("J"), 6);
		test.print();
		
		test.insertAt(new Node("Y"), 7);
		test.print();
	}

}

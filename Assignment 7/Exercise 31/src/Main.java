public class Main {
	public static void main(String[] args) {

		BinaryTree t = new BinaryTree();
		t.insert(new Student("Anthony Davis", 0, 3.5));
		t.insert(new Student("Alan Brown", 1, 4));
		t.insert(new Student("Argyle Bromine", 2, 3.6));
		t.insert(new Student("Abby Carp", 3, 3.0));
		t.insert(new Student("Adam Fantasia", 4, 0));
		t.insert(new Student("Arron Smalls", 5, 0));
		t.insert(new Student("Real Name", 6, 0));
		
		TreeManager m = new TreeManager(t);
		m.manage();
		
	}
}

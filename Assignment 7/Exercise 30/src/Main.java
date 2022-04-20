
public class Main {

	public static void main(String[] args) {
		Student s1 = new Student("Test", 0, 3.2);
		Student s2 = new Student("Test 2", 1, 1.2);
		
		Student s3 = s2.deepCopy();
		s3.setValues(null, 2, null); // Will only update the ID
		
		System.out.println(s1.toString());
		System.out.println(s3.toString());
		
		System.out.println(s2.compareTo(s3.getKey())); //Returns 0 because the names are the same
		System.out.println(s1.compareTo(s2.getKey())); //Returns -2 because s1's name is considered greater than s2's name using lexicographic order
	}

}

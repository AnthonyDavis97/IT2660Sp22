public class Listing {
	private String name;
	private int age;
	
	public Listing() {
		name = " ";
		age = 0;
	}
	
	public Listing(String n, int a) {
		name = n;
		age = a;
	}
	
	public String toString() {
		return String.format("Name=%s, Age=%s", name, age);
	}
	
	public void input(String newName, int newAge) {
		setName(newName);
		setAge(newAge);
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setAge(int newAge) {
		age = newAge;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}
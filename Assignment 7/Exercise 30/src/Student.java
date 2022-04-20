//Modified version of listing class as depicted in figure 2.16
public class Student {
	private String name;
	private int id;
	private double gpa;
	
	public Student(String n, int i, double g) {
		name = n;
		id = i;
		gpa = g;
	}
	
	public String toString() {
		return ("Name: " + name + "\nID: " + id + "\nGPA: " + gpa + "\n");
	}
	
	public Student deepCopy() {
		Student clone = new Student(name, id, gpa);
		return clone;
	}
	
	public int compareTo(String targetKey) {
		return(name.compareTo(targetKey));
	}
	
	public void setValues(String n, Integer i, Double g) {
		if(n != null) {
			name = n;
		}
		
		if(i != null) {
			id = i.intValue();
		}
		
		if(g != null) {
			gpa = g.doubleValue();
		}
	}
	
	public String getKey() {
		return name;
	}
}

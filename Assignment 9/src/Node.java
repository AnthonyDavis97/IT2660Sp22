import java.util.Random;

public class Node {
	private int data;
	private int id;
	private Random r = new Random();
	
	public Node() {
		data = r.nextInt(11);
		id = 0;
	}
	
	public Node(int limit, int i) {
		data = r.nextInt(limit + 1);
		id = i;
	}
	
	public int getData() {
		return data;
	}
	
	public int getId() {
		return id;
	}
}

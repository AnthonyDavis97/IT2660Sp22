public class Node {
	private String value;
	private Node next;
	
	public Node(String v) {
		this.value = v;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void setNext(Node n) {
		this.next = n;
	}
}

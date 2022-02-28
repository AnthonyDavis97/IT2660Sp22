public class LinkedList {
	private Node root;
	private Node last;
	private int size;
	
	public LinkedList(Node n) {
		this.root = n;
		this.last = n;
		this.size = 1;
	}
	
	public void append(Node n) {
		this.last.setNext(n);
		this.last = n;
		size++;
	}
	
	public void insertAt(Node n, int position) {
		if(position == 0) {
			//Change root
			n.setNext(this.root);
			this.root = n;
			size++;
		} else if(position == this.size + 1) {
			//Append node if position is 1 larger than list size
			this.append(n);
		} else if(position > this.size + 1) {
			//Produce error message if position is larger than list size+1
			System.out.println("!!");
			System.out.println("Position value is too large. Please try again with a value equal to or less than " + this.size + ".");
			System.out.println("!!");
		} else {
			//insert a node anywhere in the list
			Node targetNode = getNode(position - 1);
			n.setNext(targetNode.getNext());
			targetNode.setNext(n);
			size++;
		}
	}
	
	public void print() {
		Node currentNode = this.root;
		
		System.out.println("The size of this list is " + this.size + " nodes.");
		
		for(int i = 1; i <= this.size; i++) {
			System.out.print(currentNode.getValue() + " ");
			currentNode = currentNode.getNext();
		}
		
		System.out.println("");
	}
	
	private Node getNode(int position) {
		Node currentNode = this.root;
		
		for(int i = 1; i < position; i++) {
			currentNode = currentNode.getNext();
		}
		
		return currentNode;
	}
}

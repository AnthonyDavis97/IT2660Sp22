//uses int values for example
public class StackExample {
	private int[] data;
	private int top;
	private int maxSize;
	
	public StackExample() {
		this.top = -1;
		this.maxSize = 10;
		this.data = new int[1];
	}
	
	public StackExample(int n) {
		this.top = -1;
		this.maxSize = n;
		this.data = new int[1];
	}
	
	public boolean push(int newNode) {
		if(top == maxSize - 1) {
			return false; //return false if stack is full
		} else if(top > -1) {
			//if stack is not full, increment top and copy contents of current array to a larger array and add newNode to the top
			top = top + 1;
			int[] tempArray = new int[this.data.length + 1];
			
			//should be skipped in new stacks when top is 0
			for(int i = 0; i < top; i++) {
				tempArray[i] = this.data[i];
			}
			
			tempArray[top] = newNode;
			this.data = tempArray;
			
			return true;
		} else if(top == -1) {
			//this block will only run for new stacks in order to remove the default 0 value from the stack
			//if 0 is desired to be in the stack then it can be pushed into it at any time, provided the stack is not full
			top = top + 1;
			int[] tempArray = new int[1];
			tempArray[top] = newNode;
			this.data = tempArray;
			
			return true;
		} else {
			return false;
		}
	}

	//Integer is returned because an int cannot be null
	public Integer pop() {
		//return null if top is -1 (stack is empty)
		if(top == -1) {
			return null;
		} else {
			int poppedValue = this.data[top];
			int[] tempArray = new int[this.data.length - 1];
			//copy original data into newArray
			for(int i = 0; i < tempArray.length; i++) {
				tempArray[i] = this.data[i];
			}
			this.data = tempArray;
			top = top - 1;
			return poppedValue;
		}
	}
	
	public void showAll() {
		if(top == -1) {
			System.out.println("The maximum size for this stack is: " + this.maxSize);
			System.out.println("This stack does not have any nodes in it. Try using the push() method to add some nodes!\n");
		} else {
			System.out.println("The maximum size for this stack is: " + this.maxSize);
			System.out.println("The current size of this stack is: " + this.data.length);
			System.out.println("The top of the stack is index " + this.top + " (Position " + (this.top + 1) + ")");
			System.out.println("The contents of the stack are as follows:");
			for(int i = 0; i < this.data.length; i++) {
				System.out.println(this.data[i]);
			}
			System.out.println("");
		}
		
	}
}

public class Main {

	public static void main(String[] args) {
		StackExample stack1 = new StackExample();
		
		stack1.showAll();
		stack1.push(1);
		stack1.showAll();
		
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		stack1.push(5);
		stack1.push(6);
		stack1.push(7);
		stack1.push(8);
		stack1.push(9);
		stack1.push(10);
		stack1.showAll();
		
		int pop1 = stack1.pop();
		System.out.printf("The value %d was removed from the stack.\n\n", pop1);
		stack1.showAll();
		
		System.out.println(stack1.push(11));
		System.out.println(stack1.push(12));
		
		System.out.println("");
		stack1.showAll();
		
		for(int i = 0; i < 15; i++) {
			System.out.println(stack1.pop() + " has been removed from stack1.");
		}
		
		System.out.println("");
		stack1.showAll();
	}

}
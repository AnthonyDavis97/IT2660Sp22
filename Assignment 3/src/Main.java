public class Main {

	public static void main(String[] args) {
		StackExample stack1 = new StackExample();
		
		stack1.showAll();
		stack1.push(1);
		
		System.out.println("");
		stack1.showAll();
		
		for(int i = 2; i < 11; i++) {
			stack1.push(i);
		}

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
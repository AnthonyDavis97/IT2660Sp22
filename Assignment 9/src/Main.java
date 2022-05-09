import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Graph g1 = new Graph(1000);
		int lookingFor = 0;
		int action;
		Scanner input = new Scanner(System.in);
		boolean done = false;

		g1.generateNodes(100000);
		g1.generateEdges();

		while(done == false) {
			System.out.println("Please select one of the following options:");
			System.out.println("1 to output the values of all nodes");
			System.out.println("2 to perform a depth first search for a number");
			System.out.println("3 to perform a breadth first search for a number");
			System.out.println("4 to exit");
			
			action = input.nextInt();
			
			switch(action) {
			case 1:
				System.out.println("");
				g1.outputNodes();
				System.out.println("");
				break;
			case 2:
				System.out.println("");
				System.out.println("Enter a number to search for");
				lookingFor = input.nextInt();
				g1.depthFirstSearch(lookingFor);
				System.out.println("");
				break;
			case 3:
				System.out.println("");
				System.out.println("Enter a number to search for");
				lookingFor = input.nextInt();
				g1.breadthFirstSearch(lookingFor);
				System.out.println("");
				break;
			case 4:
				System.out.println("");
				System.out.println("Exiting program");
				done = true;
				break;
			}
		}//end of while loop
		
		input.close();
	}
}

import java.util.Scanner;

public class TreeManager {
	private BinaryTree tree;
	Scanner input = new Scanner(System.in);
	
	public TreeManager() {
		tree = new BinaryTree();
	}
	
	public TreeManager(BinaryTree t) {
		tree = t;
	}
	
	public void manage() {
		boolean end = false;
		int action;
		String fName, lName, name, newFName, newLName, newName;
		int id;
		double gpa;
		
		while(end == false) {
			System.out.println("Enter: 1 to insert a new student's information");
			System.out.println("2 to fetch and output a student's information");
			System.out.println("3 to delete a student's information");
			System.out.println("4 to update a student's information");
			System.out.println("5 to output all student's information in descending order, and");
			System.out.println("6 to exit the program.");
			
			action = input.nextInt();
			
			switch(action) {
			case 1:
				System.out.println("Enter the student's first name: ");
				fName = input.next();
				
				System.out.println("Enter the student's last name: ");
				lName = input.next();
				
				name = fName + " " + lName;
				
				System.out.println("Enter the student's id: ");
				id = input.nextInt();
				
				System.out.println("Enter the student's gpa: ");
				gpa = input.nextDouble();
				
				tree.insert(new Student(name, id, gpa));
				break;
			case 2:
				System.out.println("Enter the student's first name: ");
				fName = input.next();
				
				System.out.println("Enter the student's last name: ");
				lName = input.next();
				
				name = fName + " " + lName;
				
				System.out.println(tree.fetch(name));
				break;
			case 3:
				System.out.println("Enter the student's first name: ");
				fName = input.next();
				
				System.out.println("Enter the student's last name: ");
				lName = input.next();
				
				name = fName + " " + lName;
				
				tree.delete(name);
				System.out.println(name + "'s entry has been removed from the tree.");
				break;
			case 4://assumes input exists in tree
				System.out.println("Enter the student's first name: ");
				fName = input.next();
				
				System.out.println("Enter the student's last name: ");
				lName = input.next();
				
				name = fName + " " + lName;
				
				System.out.println("Enter the student's new information at the following prompts:");
				System.out.println("Update the student's first name: ");
				newFName = input.next();
				System.out.println("Update the student's last name: ");
				newLName = input.next();
				
				newName = newFName + " " + newLName;
				
				System.out.println("Update the student's id: ");
				id = input.nextInt();
				
				System.out.println("Update the student's gpa: ");
				gpa = input.nextDouble();
				
				tree.update(name, new Student(newName, id, gpa));
				
				System.out.println(newName + "'s entry has been updated.");
				break;
			case 5:
				tree.RNLTraversal(tree.root);
				break;
			case 6:
				System.out.println("Exiting program.");
				end = true;
				break;
			}
		}
		input.close();
	}
}

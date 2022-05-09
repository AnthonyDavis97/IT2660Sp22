import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Graph {
	private Node[] vertices;
	private int[][] edges;
	
	public Graph() {
		vertices = new Node[10];
		edges = new int[10][10];
	}
	
	public Graph(int n) {
		vertices = new Node[n];
		edges = new int[n][n];
	}
	
	public void generateNodes(int limit) {
		int nodesMade = 0;
		
		for(int i = 0; i < vertices.length; i++) {
			vertices[i] = new Node(limit, i);
			nodesMade += 1;
		}
		
		System.out.println(nodesMade + " nodes generated in graph\n");
	}
	
	public void outputNodes() {
		for(int i = 0; i < vertices.length; i++) {
			System.out.print(vertices[i].getData() + " ");
		}
		System.out.print("\n");
	}
	
	//nested for loop enjoyers club
	public void generateEdges() {
		int maxEdges = 5;
		int currentEdges;
		Random r = new Random();
		
		//fill array with dummy number to determine if index has been worked on
		for(int i = 0; i < edges.length; i++) {
			for(int j = 0; j < edges[i].length; j++) {
				edges[i][j] = -1;
			}//end of outer for loop
		}//end of outer for loop
		
		//a node cannot have an edge to itself, so set values to 0 if j == i
		for(int i = 0; i < edges.length; i++) {
			for(int j = 0; j < edges[i].length; j++) {
				if(i == j) {
					edges[i][j] = 0;
					edges[j][i] = 0;
				}
			}//end of outer for loop
		}//end of outer for loop
		
		//randomly generate edges for remaining indexes
		for(int i = 0; i < edges.length; i++) {
			currentEdges = getEdges(edges, i);
			
			//System.out.println("Edges[" + i + "] has " + currentEdges + " edges.");
			
			for(int j = 0; j < edges[i].length; j++) {
				//exit current iteration if max edges has been reached
				if(currentEdges >= maxEdges) {
					//if there are remaining indexes that have not been checked, set them and their inverse to 0
					if(j < edges[i].length) {
						for(int x = j; x < edges[i].length; x++) {
							edges[i][x] = 0;
							edges[x][i] = 0;
						}//end of inner inner for loop
					}//end of inner if
					break;
				}//end of outer if
				
				//if inverse index has been worked on, set current index to it
				if(edges[j][i] != -1 && edges[i][j] != edges[j][i]) {
					edges[i][j] = edges[j][i];
					continue;
				}
				
				//if both indexes have not been worked on
				if(edges[i][j] == -1 && edges[j][i] == -1) {
					//try to generate an edge
					if(r.nextInt(11) % 2 == 0) {
						edges[i][j] = 1;
						edges[j][i] = 1;
						currentEdges += 1;
						//System.out.println("Generated edge between nodes " + vertices[i].getData() + " and " + vertices[j].getData() );
					} else {
						//if the edge check did not pass set the indexes to 0
						edges[i][j] = 0;
						edges[j][i] = 0;
					}
				}//end of outer if
			}//end of inner for loop
		}//end of outer for loop
		
		//failsafe: generate one edge if a node has none
		for(int i = 0; i < edges.length; i++) {
			if(getEdges(edges, i) == 0) {
				for(int j = 0; j < edges[i].length; j++) {
					//if edges[j] has less than 5 edges, add an edge to the current node and break the loop
					//may be able to generate an edge from a node to itself. '&& j != i' included to prevent this
					if(getEdges(edges, j) < 5 && j != i) {
						edges[i][j] = 1;
						edges[j][i] = 1;
						//System.out.println("Failsafe activated for node " + i);
						break;
					}
				}//end of inner for loop
			}
		}//end of outer for loop
	}//end of generate edges
	
	private int getEdges(int[][] arr, int index) {
		int edges = 0;
		
		for(int i = 0; i < arr[index].length; i++) {
			if(arr[index][i] == 1) {
				edges += 1;
			}
		}
		return edges;
	}

	public void depthFirstSearch(int n) {
		int nodesVisited = 0;
		boolean found = false;
		ArrayList<Node> searchedNodes = new ArrayList<Node>();
		Stack<Node> toSearch = new Stack<Node>();
		//toSearch.push(vertices[0]); sometimes would not push anything to stack, throwing an error
		Node toCheck;
		
		while(found == false) {
			//sometimes receive EmptyStackException without this block
			if(toSearch.empty() == true) {
				toSearch.push(vertices[0]);
			}
			
			if(toSearch.peek().getData() == n) {
				nodesVisited += 1;
				found = true;
			} else {
				toCheck = toSearch.pop();
				searchedNodes.add(toCheck);
				//uses node id to check adjacency matrix
				for(int i = 0; i < edges[toCheck.getId()].length; i++) {
					//checks adjacency matrix to find and add any nodes with edges to the stack, provided they have not been searched
					if(edges[toCheck.getId()][i] == 1 && searchedNodes.contains(vertices[i]) == false) {
						toSearch.push(vertices[i]);
						searchedNodes.add(vertices[i]);
						//for some reason a node may be added to searchedNodes multiple times
						//ideally this would not happen, but in tests nodes could not be added to toSearch more than once so behavior was left as-is
					}
				}
				nodesVisited += 1;
			}
			
			if(nodesVisited == vertices.length) {
				break;
			}
		}
		
		//DEBUG 
		//to view contents of searchedNodes
		//searchedNodes.forEach((nde) -> System.out.println("Node ID: " + nde.getId()));
		
		System.out.println(nodesVisited + " nodes visited in this search.");
		if(found == true) {
			Node target = toSearch.peek();
			System.out.println("Starting from node #0, " + n + " is first found in node #" + target.getId());
			System.out.print("The shortest path to this node begins at node ");
			for(int i = 0; i < edges[target.getId()].length; i++) {
				if(edges[target.getId()][i] == 1) {
					System.out.print(vertices[i].getId() + "\n");
					break;
				}
			}
		} else if(found == false) {
			System.out.println(n + " is not present in any node of this graph.");
		}
	}
	
	public void breadthFirstSearch(int n) {
		int nodesVisited = 0;
		boolean found = false;
		ArrayList<Node> searchedNodes = new ArrayList<Node>();
		ConcurrentLinkedQueue<Node> toSearch = new ConcurrentLinkedQueue<Node>();
		//toSearch.add(vertices[0]); sometimes would add nothing to the queue, throwing an error
		Node toCheck;
		
		while(found == false) {
			//sometimes receive NullPointerException without this block
			if(toSearch.isEmpty() == true) {
				toSearch.add(vertices[0]);
			}
			
			if(toSearch.peek().getData() == n) {
				nodesVisited += 1;
				found = true;
			} else {
				toCheck = toSearch.poll();
				searchedNodes.add(toCheck);
				//uses node id to check adjacency matrix
				for(int i = 0; i < edges[toCheck.getId()].length; i++) {
					//checks adjacency matrix to find and add any nodes with edges to the stack, provided they have not been searched
					if(edges[toCheck.getId()][i] == 1 && searchedNodes.contains(vertices[i]) == false) {
						toSearch.add(vertices[i]);
						searchedNodes.add(vertices[i]);
						//for some reason a node may be added to searchedNodes multiple times
						//ideally this would not happen, but in tests nodes could not be added to toSearch more than once so behavior was left as-is
					}
				}
				nodesVisited += 1;
			}
			
			if(nodesVisited == vertices.length) {
				break;
			}
		}
		
		//DEBUG 
		//to view contents of searchedNodes
		//searchedNodes.forEach((nde) -> System.out.println("Node ID: " + nde.getId()));
		
		System.out.println(nodesVisited + " nodes visited in this search.");
		if(found == true) {
			Node target = toSearch.peek();
			System.out.println("Starting from node #0, " + n + " is first found in node #" + target.getId());
			System.out.print("The shortest path to this node begins at node ");
			for(int i = 0; i < edges[target.getId()].length; i++) {
				if(edges[target.getId()][i] == 1) {
					System.out.print(vertices[i].getId() + "\n");
					break;
				}
			}
		} else if(found == false) {
			System.out.println(n + " is not present in any node of this graph.");
		}
	}
}

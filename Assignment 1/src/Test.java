public class Test {

	public static void main(String[] args) {
		Listing[] listingArray = {new Listing("One", 1200), new Listing("Gold", 26), new Listing("Thundermen", 43)};
		
		System.out.println("Test One:");
		for(Listing element: listingArray) {
			System.out.println(element.toString());
		}
		
		listingArray[0].input("Yeah", 100);
		listingArray[1].input("Frank", 36);
		listingArray[2].input("Atlantis", 48);
		
		System.out.println("\nTest Two:");
		for(Listing element: listingArray) {
			System.out.println(element.toString());
		}
	}
}

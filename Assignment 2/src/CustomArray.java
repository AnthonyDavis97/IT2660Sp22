public class CustomArray {
	private int[] list;
	
	public CustomArray() {
		this.list = new int[1];
	}
	
	public void print() {
		for(int element: this.list) {
			System.out.println(element);
		}
	}
	
	public void insert(int element, int index) {
		
		//add item to empty list
		if (this.list.length == 0 && index == 0) {
            this.list = new int[1];
            this.list[0] = element;
            return;
        }
		
		//chosen index must exist 
		if(index < 0 || index > this.list.length) {
			return;
		}
		
		int[] newArray = new int[this.list.length + 1];
		
		//copy the array up to chosen index
		for(int i = 0; i < this.list.length; i++) {
			if(i != index) {
				newArray[i] = this.list[i];
			} else {
				newArray[i] = element;
				break;
			}
		}
		
		//add the original array's contents to the new array after the new element
		for(int i = index + 1; i < newArray.length; i++) {
			newArray[i] = this.list[i - 1];
		}
		
		this.list = newArray;
	}
	
	public void delete(int index) {
		int[] newArray = new int[this.list.length - 1];
		
		//first loop adds values from original array until reaching the entry to be deleted, then stops
		for(int i = 0; i < newArray.length; i++) {
			if(i != index) {
				newArray[i] = this.list[i];
			} else {
				break;
			}
		}
		
		//second loop begins where the first one ended, making sure to add the correct value from the original array
		for(int i = index; i < newArray.length; i++) {
			newArray[i] = this.list[i + 1];
		}
		
		this.list = newArray;
	}
	
	public void update(int element, int index) {
		int[] newArray = new int[this.list.length];
		
		for(int i = 0; i < this.list.length; i++) {
			if(i == index) {
				newArray[i] = element;
			} else {
				newArray[i] = this.list[i];
			}
		}
		
		this.list = newArray;
	}
}
public class DoublyLinkedDequeTest {
	
	public static void main(String[] args) { // rename to 'main' and run
		DoublyLinkedDeque deque = new DoublyLinkedDeque();
		
		String person1 = "person1";
		String person2 = "person2";
		String person3 = "person3";
		String person4 = "person4";
		String person5 = "person5";
		String person6 = "person6";
		String person7 = "person7";
		String person8 = "person8";
		
		deque.addToFront(person4);
		deque.addToFront(person3);
		deque.addToFront(person2);
		deque.addToFront(person1);
		
		deque.addToBack(person5);
		deque.addToBack(person6);
		deque.addToBack(person7);
		deque.addToBack(person8);
		
		System.out.println(deque.getFront()); // person1
		
		System.out.println(deque.getBack()); // person8
		
		System.out.println(deque.isEmpty()); // false
		
		deque.clear();
		
		System.out.println(deque.isEmpty()); // true
		
		deque.addToBack(person4); // add to back while empty
		
		// with only 1 item, front and back should be equal
		System.out.println(deque.getFront()); // person4
		System.out.println(deque.getBack());  // person4
		
	}
	
}

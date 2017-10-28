
/**
 * A class implementing a Deque using doubly linked chain
 */

public final class DoublyLinkedDeque<T> implements DequeInterface<T> {
	// member variables
	private DoublyLinkedNode firstNode;
	private DoublyLinkedNode lastNode;
	
	public DoublyLinkedDeque() {
		firstNode = null;
		lastNode = null;
	}
	
	/** Adds a new entry to the front/back of this dequeue.
	 @param newEntry  An object to be added. */
	public void addToFront(T newEntry) {
		DoublyLinkedNode node = new DoublyLinkedNode(null, newEntry, firstNode);
		
		if(isEmpty())
			lastNode = node;
		else
			firstNode.setNextNode(node);
		
		firstNode = node;
	}
	
	public void addToBack(T newEntry) {
		DoublyLinkedNode node = new DoublyLinkedNode(lastNode, newEntry, null);
		
		if(isEmpty())
			firstNode = node;
		else
			lastNode.setNextNode(node);
		
		lastNode = node;
	}
	
	/** Removes and returns the front/back entry of this dequeue.
	 @return  The object at the front/back of the dequeue.
	 @throws  EmptyQueueException if the dequeue is empty before the operation. */
	public T removeFront() {
		if (isEmpty())
			throw new EmptyQueueException();
		
		T front = getFront();
		
		if(firstNode != null) {
			firstNode = firstNode.getNextNode();
			firstNode.setPrevNode(null);
		}
		else // firstNode == null
			lastNode = null;
		
		return front;
	}
	
	public T removeBack() {
		if (isEmpty())
			throw new EmptyQueueException();
		
		T back = getBack();
		
		if(lastNode != null) {
			lastNode = lastNode.getPrevNode();
			lastNode.setNextNode(null);
		}
		else
			firstNode = null;
		
		return back;
	}
	
	/** Retrieves the front/back entry of this dequeue.
	 @return  The object at the front/back of the dequeue.
	 @throws  EmptyQueueException if the dequeue is empty before the operation. */
	public T getFront() {
		if (isEmpty())
			throw new EmptyQueueException();
		
		T frontData = firstNode.getData();
		
		return firstNode.getData();
	}
	
	public T getBack() {
		if (isEmpty())
			throw new EmptyQueueException();
		
		T backData = lastNode.getData();
		
		return lastNode.getData();
	}
	
	/**  Detects whether this dequeue is empty.
	   @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty() {
		return (firstNode == null && lastNode == null);
	}
	
	/**  Removes all entries from this dequeue. */
	public void clear() {
		firstNode = null;
		lastNode = null;
	}
	
	private class DoublyLinkedNode {
		private T data;
		private DoublyLinkedNode next;
		private DoublyLinkedNode prev;
		
		public DoublyLinkedNode() {
			data = null;
			next = null;
			prev = null;
		}
		
		public DoublyLinkedNode(DoublyLinkedNode prev, T newEntry, DoublyLinkedNode next) {
			this.prev = prev;
			data = newEntry;
			this.next = next;
		}
		
		public T getData() {
			return data;
		}
		
		private void setData(T newData) {
			data = newData;
		}
		
		public DoublyLinkedNode getNextNode() {
			return next;
		}
		
		private void setNextNode(DoublyLinkedNode newNode) {
			next = newNode;
		}
		
		public DoublyLinkedNode getPrevNode() {
			return prev;
		}
		
		private void setPrevNode(DoublyLinkedNode newNode) {
			prev = newNode;
		}
		
	}
	
}

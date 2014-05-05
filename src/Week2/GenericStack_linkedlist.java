public class GenericStack_linkedlist<T> {
	private Node first = null;
	public int N = 0;
	
	private class Node{
		public T item;
		public Node next;
		
		public Node(T item, Node next){
			this.item = item;
			this.next = next;
		}
	}
	
	public void push(T stringarray){
		first = new Node(stringarray,first);
		N++;
	}
	
	public T pop(){
		T result = first.item;
		first = first.next;
		N--;
		return result;
	}
	
	public boolean isEmpty(){
		if(N==0)
			return true;
		return false;
	}
	
	public int size(){
		return N;
	}
	
}

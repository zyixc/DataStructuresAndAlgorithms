package Week2;

public class GenericStack_linkedlist {
	private Node first = null;
	public int N = 0;
	
	private class Node{
		public Object item;
		public Node next;
		
		public Node(Object item, Node next){
			this.item = item;
			this.next = next;
		}
	}
	
	public void push(Object stringarray){
		first = new Node(stringarray,first);
		N++;
	}
	
	public Object pop(){
		Object result = first.item;
		first = first.next;
		N--;
		return result;
	}
	
}

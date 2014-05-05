public class StackOfInts_linkedlist {
	private Node first = null;
	public int N = 0;
	
	private class Node{
		public int item;
		public Node next;
		
		public Node(int item, Node next){
			this.item = item;
			this.next = next;
		}
	}
	
	public void push(int item){
		first = new Node(item,first);
		N++;
	}
	
	public int pop(){
		int result = first.item;
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

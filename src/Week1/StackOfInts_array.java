
public class StackOfInts_array {
	private int[] intarray;
	public int position = 0;
	
	public StackOfInts_array(int size){
		intarray = new int[size];
	}
	
	public void push(int item){
		if(position == intarray.length){
			System.out.println("array size increasing");
			int[] temparray = new int[(intarray.length*2)]; 
			for(int i=0; i<position; i++){
				temparray[i] = intarray[i];
			}
			intarray = temparray;
		}
		intarray[position] = item;
		position++;
	}
	
	public int pop(){
		position--;
		int result = intarray[position];
		
		if(position < (intarray.length/4)){
			System.out.println("array size decreasing");
			int[] temparray = new int[(intarray.length/2)]; 
			for(int i=0; i<position; i++){
				temparray[i] = intarray[i];
			}
			intarray = temparray;
		}
		return result;
	}
	
	public boolean isEmpty(){
		if(position == 0)
			return true;
		return false;
	}
	
	public int size(){
		return position;
	}
}

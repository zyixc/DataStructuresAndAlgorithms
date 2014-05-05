
public class GenericStack_array <T> {
	private T[] tarray;
	public int position = 0;
	
	public GenericStack_array(int size){
		tarray = (T[]) new Object[size];
	}
	
	public void push(T item){
		if(position == tarray.length){
			System.out.println("array size increasing");
			T[] temparray = (T[]) new Object[(tarray.length*2)]; 
			for(int i=0; i<position; i++){
				temparray[i] = tarray[i];
			}
			tarray = temparray;
		}
		tarray[position] = item;
		position++;
	}
	
	public Object pop(){
		position--;
		Object result = tarray[position];
		
		if(position < (tarray.length/4)){
			System.out.println("array size decreasing");
			T[] temparray = (T[]) new Object[(tarray.length/2)]; 
			for(int i=0; i<position; i++){
				temparray[i] = tarray[i];
			}
			tarray = temparray;
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

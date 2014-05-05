package Week2;

public class GenericStack_array {
	private Object[] objectarray;
	public int position = 0;
	
	public GenericStack_array(int size){
		objectarray = new Object[size];
	}
	
	public void push(Object item){
		if(position == objectarray.length){
			System.out.println("array size increasing");
			Object[] temparray = new Object[(objectarray.length*2)]; 
			for(int i=0; i<position; i++){
				temparray[i] = objectarray[i];
			}
			objectarray = temparray;
		}
		objectarray[position] = item;
		position++;
	}
	
	public Object pop(){
		position--;
		Object result = objectarray[position];
		
		if(position < (objectarray.length/4)){
			System.out.println("array size decreasing");
			Object[] temparray = new Object[(objectarray.length/2)]; 
			for(int i=0; i<position; i++){
				temparray[i] = objectarray[i];
			}
			objectarray = temparray;
		}
		return result;
	}
}

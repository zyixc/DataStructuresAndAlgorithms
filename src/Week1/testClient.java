
public class testClient {
	private static final int testsize = 11;
	
	public static void main(String[] args) {
		ints_array();
		ints_linkedlist();
	}
		
	private static void ints_array(){
		StackOfInts_array intarray = new StackOfInts_array(testsize);		
		
		for(int i = 0; i < testsize; i++){
			intarray.push(i);
			System.out.println("position = "+intarray.position+" ; Value = "+i);
		}
		
		System.out.println("-------------------------------------");
		
		for(int i = 0; i < testsize; i++){
			int result = intarray.pop();
			System.out.println("position = "+intarray.position+" ; Value = "+result);
		}
	}

	private static void ints_linkedlist(){
		int[] intarray = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
		StackOfInts_linkedlist intnode = new StackOfInts_linkedlist();
		
		for(int i=0; i<intarray.length; i++){
			System.out.println("Node item = "+intnode.N+" ;");
			intnode.push(intarray[i]);
		}
		
		System.out.println("-------------------------------------");
		
		for(int i=0; i<intarray.length; i++){
			int result = intnode.pop();
			System.out.println("Node item = "+intnode.N+" ; Value = "+result);
		}
	}
	
}

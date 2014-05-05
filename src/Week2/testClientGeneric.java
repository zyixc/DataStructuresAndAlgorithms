
public class testClientGeneric {
	
	
	public static void main(String[] args) {
		object_array();
		System.out.println("###########################");
		object_linkedlist();
	}
	
	private static void object_array(){
		int testsize = 11;
		//Integer part
		
		GenericStack_array<Integer> intarray = new GenericStack_array<Integer>(testsize);		
		
		for(int i = 0; i < testsize; i++){
			intarray.push(i);
			System.out.println("position = "+intarray.position+" ; Value = "+i);
		}
		
		System.out.println("-------------------------------------");
		
		for(int i = 0; i < testsize; i++){
			Object result = intarray.pop();
			System.out.println("position = "+intarray.position+" ; Value = "+result);
		}
		
		
		System.out.println("##-------------------------------------##");
		//String part
		
		GenericStack_array<String> stringarray = new GenericStack_array<String>(testsize);		
		
		for(int i = 0; i < testsize; i++){
			stringarray.push("string"+i);
			System.out.println("position = "+stringarray.position+" ; Value = "+i);
		}
		
		System.out.println("-------------------------------------");
		
		for(int i = 0; i < testsize; i++){
			Object result = stringarray.pop();
			System.out.println("position = "+stringarray.position+" ; Value = "+result);
		}
		
	}
	
	private static void object_linkedlist(){
		//Integer part
		
		int[] intarray = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
		GenericStack_linkedlist<Integer> intnode = new GenericStack_linkedlist<Integer>();
		
		for(int i=0; i<intarray.length; i++){
			System.out.println("Node item = "+intnode.N+" ;");
			intnode.push(intarray[i]);
		}
		
		System.out.println("-------------------------------------");
		
		for(int i=0; i<intarray.length; i++){
			Object result = intnode.pop();
			System.out.println("Node item = "+intnode.N+" ; Value = "+result);
		}
		
		System.out.println("##-------------------------------------##");
		
		//String part
		
		String[] stringarray = {"test0","test1"};
		GenericStack_linkedlist<String> stringnode = new GenericStack_linkedlist<String>();
		
		for(int i=0; i<stringarray.length; i++){
			System.out.println("Node item = "+stringnode.N+" ;");
			stringnode.push(stringarray[i]);
		}
		
		System.out.println("-------------------------------------");
		
		for(int i=0; i<stringarray.length; i++){
			Object result = stringnode.pop();
			System.out.println("Node item = "+stringnode.N+" ; Value = "+result);
		}
	}
	
}

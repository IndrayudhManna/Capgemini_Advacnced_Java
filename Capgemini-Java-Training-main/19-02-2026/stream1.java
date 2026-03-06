package aStreams;

import java.util.*;

public class stream1 {
	// Order of Execution 
	//-------------------
	// Collection > Stream > Filter > Transform > Collect > Result
	//Stream pipeline:
	//SOURCE > INTERMEDIATE OPERATIONS > TERMINAL OPERATION 
	//-----------------------
	//Characteristics of Streams:-
	//1. Stream Does not store any data
	//2. Sources can be collections,arrays,files and generator functions
	//3. Stream is functional in nature and it uses lambda expressions, functional interfaces and method reference
	//4. Stream operations are lazy, nothing happens until you call terminal operations
	//5. Execution starts only after these functions : forEach(), collect(), toList(), count()
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);   //creating list (immutable)
//		List<Integer> even = new ArrayList<>();			   //creating arrayList
//		
//		
//		for(Integer n : list1) {
//			if(n%2==0) {
//				even.add(n);
//		}
//		}
		
		List<Integer> even1 = new ArrayList<>(list1.stream()//source                  //Turning list1 into an arrayList even1
								  .filter(n -> n%2 == 0)//intermediate operation      //Filter logic --> If true then keep. If false then skip. Syntax: n-> condition based on which to filter. 
								  .map(n -> n*2)//intermediate operation		   	  //Map logic --> takes input and does and operation. Syntax: n-> what to add to the list instead.
								  .toList()); //collect or terminal
		
		List<Integer> even2 =  list1.stream()												//Turning list1 into a List even2
								.filter(n -> n%2 == 0)
								.map(n -> n*2)
								.toList();
		
		Integer first = list1.stream()
						.filter(n -> n>=5)
						.findFirst()
						.orElse(0);
		
		Integer reduce1 = list1.stream()
						.map(n -> n*3)
						.reduce((a,b) -> b/a)
						.orElse(0);
	
		
//		Optional<Integer> min = numbers.stream()				//Common use of reduce
//			    .reduce((a, b) -> a < b ? a : b);
//			System.out.println("Min: " + min.orElse(-1));
		
		System.out.println(even1);
		System.out.println(first);
		System.out.println(reduce1);
	}

}

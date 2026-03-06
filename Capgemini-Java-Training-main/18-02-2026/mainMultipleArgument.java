package a2;

public class mainMultipleArgument {

	public static void main(String[] args) {
		DemoMultipleArgument demo=(num, name)->{			//Syntax #1
			System.out.println("For multiple argument method Syntax 1 "+num+" "+name);
			return num;
		};
		
		/*									//Syntax #2 (This does not work with multiple arguments)
		DemoMultipleArgument demo1 = num, name-> System.out.println("For multiple argument method Syntax 2 "+num+" "+name);				
		*/
		DemoMultipleArgument demo1= (num, name) -> num+10;   //Syntax #3 (Only for return type)
		  		
		System.out.println(demo.sample(1000, "Adam"));
		System.out.println(demo1.sample(5000, "Charlie"));
	}

}

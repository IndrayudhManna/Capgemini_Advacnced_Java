package a2;

public class mainArgument {

	public static void main(String[] args) {
		DemoArgument demo=(num)->{			//Syntax #1
			System.out.println("For argument method Syntax 1 "+num);
		};
		
											//Syntax #2
		DemoArgument demo1 = num-> System.out.println("For argument method Syntax 2 "+num);
		
		
		
		demo.sample(1000);
		demo1.sample(2000);
	}

}

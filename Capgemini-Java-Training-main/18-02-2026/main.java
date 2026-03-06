package a2;

public class main {

	public static void main(String[] args) {
	//Demo demo = new DemoImp();
	//demo.sample();
		Demo demo=()->{										//You can use () if the interface has no arguments 
															//Syntax #1
				System.out.println("Method implemented using lambda expression Syntax #1");
		};
		
		
		Demo demo1=()->										//Syntax #2
			System.out.println("Method implemented using lambda expression Syntax #2");

			
			
		demo.sample(); //non static so called through ANONYMUS CLASS object
		Demo.test(); //static so called through class 
		demo1.sample();
		
		}
	}


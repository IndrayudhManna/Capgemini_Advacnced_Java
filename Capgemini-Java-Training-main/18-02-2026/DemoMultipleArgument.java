package a2;
@FunctionalInterface    //Restricts the interface and stops adding more than 1 abstract method
public interface DemoMultipleArgument {	//Functional interface = only 1 non static abstract method. Can be any amount of static methods.
	int sample(int num, String name);
}


package aStreams;
import java.util.*;
class Employee {
		String name;
		Double worth;
		
		public Employee(String name, Double worth) {
			this.name=name;
			this.worth=worth;
		}
		public Employee() {}
		
		public double getWorth() {
			
			return this.worth;
		}
		public String getName() {
			
			return this.name;
		}
		@Override
		public String toString() {
			return "Name: " + name + "  Net Worth: "+worth; 
		}
		}
		
		
public class Comp{		
	public static void main(String[] args) {
		List<Employee> a=new ArrayList<>();
		a.add(new Employee("Kafka",90000.00));
		a.add(new Employee("Blade",50000.00));
		a.add(new Employee("Silverwolf",100000.00));
		a.add(new Employee("Firefly",100000.00));
		
		List<Employee> sortedOrder=new ArrayList<>(
				a.stream()
				.sorted(Comparator
						.comparingDouble((Employee e) -> e.getWorth())
						.thenComparing(e -> e.getName(), Comparator.reverseOrder())
						)
						.toList()
						);
				
			System.out.println(sortedOrder);	
				
	
	}

}

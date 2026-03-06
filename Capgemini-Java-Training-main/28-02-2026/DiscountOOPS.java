package a1;

public class DiscountOOPS {

	public static void main(String[] args) {
		 // Test Case 1: SEASONAL discount
        double amount1 = 2000;
        String type1 = "SEASONAL";
        double result1 = DefaultSolution.entry(amount1, type1);
        System.out.println("Test 1 - Amount: " + amount1 + ", Type: " + type1);
        System.out.println("Expected: 1800.0");
        System.out.println("Actual: " + result1);
        System.out.println(result1 == 1800.0 ? "✅ PASSED" : "❌ FAILED");
        System.out.println();
        
        // Test Case 2: MEMBERSHIP discount
        double amount2 = 2000;
        String type2 = "MEMBERSHIP";
        double result2 = DefaultSolution.entry(amount2, type2);
        System.out.println("Test 2 - Amount: " + amount2 + ", Type: " + type2);
        System.out.println("Expected: 1800.0");
        System.out.println("Actual: " + result2);
        System.out.println(result2 == 1800.0 ? "✅ PASSED" : "❌ FAILED");
        System.out.println();
        
        // Test Case 3: Case insensitivity test (seasonal in lowercase)
        double amount3 = 2000;
        String type3 = "seasonal";
        double result3 = DefaultSolution.entry(amount3, type3);
        System.out.println("Test 3 - Amount: " + amount3 + ", Type: " + type3);
        System.out.println("Expected: 1800.0");
        System.out.println("Actual: " + result3);
        System.out.println(result3 == 1800.0 ? "✅ PASSED" : "❌ FAILED");
        System.out.println();
        
        // Test Case 4: Case insensitivity test (membership in mixed case)
        double amount4 = 2000;
        String type4 = "Membership";
        double result4 = DefaultSolution.entry(amount4, type4);
        System.out.println("Test 4 - Amount: " + amount4 + ", Type: " + type4);
        System.out.println("Expected: 1800.0");
        System.out.println("Actual: " + result4);
        System.out.println(result4 == 1800.0 ? "✅ PASSED" : "❌ FAILED");
        System.out.println();
        
        // Test Case 5: Invalid discount type
        double amount5 = 2000;
        String type5 = "FESTIVAL";
        double result5 = DefaultSolution.entry(amount5, type5);
        System.out.println("Test 5 - Amount: " + amount5 + ", Type: " + type5);
        System.out.println("Expected: 1500.0");
        System.out.println("Actual: " + result5);
        System.out.println(result5 == 1500.0 ? "✅ PASSED" : "❌ FAILED");
        System.out.println();
        
        // Test Case 6: Different amounts with SEASONAL
        double amount6 = 500;
        String type6 = "SEASONAL";
        double result6 = DefaultSolution.entry(amount6, type6);
        System.out.println("Test 6 - Amount: " + amount6 + ", Type: " + type6);
        System.out.println("Expected: 450.0");
        System.out.println("Actual: " + result6);
        System.out.println(result6 == 450.0 ? "✅ PASSED" : "❌ FAILED");
        System.out.println();
        
        // Test Case 7: Different amounts with MEMBERSHIP
        double amount7 = 100;
        String type7 = "MEMBERSHIP";
        double result7 = DefaultSolution.entry(amount7, type7);
        System.out.println("Test 7 - Amount: " + amount7 + ", Type: " + type7);
        System.out.println("Expected: -100.0");  // 100 - 200 = -100
        System.out.println("Actual: " + result7);
        System.out.println(result7 == -100.0 ? "✅ PASSED" : "❌ FAILED");
        System.out.println();
        
        // Summary
        System.out.println("=====================");
        System.out.println("All tests completed!");
	}

}
class DefaultSolution{
	public static double entry(double amount, String s) {
		return calculation(amount, s);
	}
	public static double calculation(double amount, String s) {
		context c=new context();
		if(s.equalsIgnoreCase("MEMBERSHIP")) {
			c.setStrategy(new Membership());
		}else if(s.equalsIgnoreCase("SEASONAL")) {
			c.setStrategy(new Seasonal());
		}else if(s.equalsIgnoreCase("FESTIVAL")) {
			c.setStrategy(new Festival());
		}
		return c.calculateMoney(amount);
	}
	
}

class context{
	private strategy strat;
	public void setStrategy(strategy strat) {
		this.strat=strat;
	}
	public double calculateMoney(double amount) {
		if(strat==null) {
			return amount;
		}
		return strat.calculate(amount);
	}
	
}
interface strategy{
	double calculate(double amount); 
}
class Membership implements strategy{
	public double calculate(double amount) {
		return amount-200;
	}
}
class Seasonal implements strategy{
	public double calculate(double amount) {
		return amount*0.9;
	}
}
class Festival implements strategy{
	public double calculate(double amount) {
		return amount-500;
	}
}
package aThreads;

public class MultiThreading2 {
    public static void main(String[] args) throws Exception {
        
        // COFFEE SHOP OPENS - Manager prepares for 5 coffees to be made
        for(int coffee = 1; coffee <= 5; coffee++) {
            
            // Make a copy of coffee number for each barista (so it doesn't change)
            int currentCoffee = coffee;  // "This is coffee order #" + currentCoffee
            
            // BARISTA #1: The Coffee Maker - responsible for brewing
            Thread t1 = new Thread(() -> {
                // Barista-1's task: Brew one coffee
                System.out.println("Barista-1 made coffee " + currentCoffee);
                // (No sleep here because it's instant in this example)
            });
            
            // BARISTA #2: The Server - responsible for serving the coffee
            Thread t2 = new Thread(() -> {
                // Barista-2's task: Serve one coffee
                System.out.println("Barista-2 served coffee " + currentCoffee);
            });
            
            // MANAGER'S INSTRUCTIONS for THIS coffee order:
            
            // Step 1: Tell Barista-1 to start brewing
            t1.start();  // "Barista-1, make coffee #" + currentCoffee + " NOW!"
            
            // Step 2: Manager WAITS at the coffee machine until Barista-1 is done
            t1.join();   // "I'll stand here and wait for you to finish brewing..."
            
            // Step 3: Now tell Barista-2 to serve the coffee
            t2.start();  // "Barista-2, serve coffee #" + currentCoffee + " NOW!"
            
            // Step 4: Manager WAITS at the counter until coffee is served
            t2.join();   // "I'll wait here until the customer gets their coffee..."
            
            // Step 5: This coffee order is complete!
            System.out.println("--- Coffee " + currentCoffee + " done ---");
            // Manager moves to the next coffee order
        }
        
        // All 5 coffees are done, shop can close
        System.out.println("Coffee shop closed! All 5 coffees made and served!");
    }
}
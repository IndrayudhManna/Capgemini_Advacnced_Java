package aThreads;

public class MultiThreading {
    
    public static void main(String[] args) {
        
        // SCENE 1: HIRING BARISTAS USING LAMBDA
        
        // Hire Barista #1 - create thread with lambda
        Thread t1 = new Thread(() -> {
            // This barista will make 5 coffees
            for(int i = 1; i <= 5; i++) {
                System.out.println("Barista-1: " + i);
                
                try {
                    Thread.sleep(1000);  // Takes 1 second per coffee
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        
        // Hire Barista #2 - create thread with lambda
        Thread t2 = new Thread(() -> {
            // This barista will make 5 coffees
            for(int i = 1; i <= 5; i++) {
                System.out.println("Barista-2: " + i);
                
                try {
                    Thread.sleep(1000);  // Takes 1 second per coffee
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        
        // SCENE 2: START THEIR SHIFTS
        System.out.println("Coffee shop opens! Baristas start working...");
        
        t1.start();  // "Barista-1, start your shift!"
        t2.start();  // "Barista-2, start your shift!"
        
        // SCENE 3: MAIN THREAD (MANAGER) IS DONE
        System.out.println("Manager goes to office (main thread continues but has no more code)");
        // Program ends when both baristas finish their 5 coffees
    }
}
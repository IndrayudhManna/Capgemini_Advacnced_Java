package aThreads;

public class Thread1 {
    // The SPECIAL PHONE that only one person can use at a time
    static final Object lock = new Object();
    
    public static void main(String args[]) throws Exception {
        
        // ===== HIRING THE BARISTA (Creating the worker thread) =====
        Thread worker = new Thread(
            // These are the INSTRUCTIONS for the barista (what they will do)
            () -> {  // "Here's what you'll do when I tell you to start working"
                
                try {  // "In case something goes wrong..."
                    
                    // STEP 3b: Barista's first task - take a nap!
                    System.out.println("Worker is sleeping");
                    Thread.sleep(2000);  // Barista sleeps for 2 seconds
                    
                    // STEP 4b: Barista wakes up and goes to the counter
                    synchronized(lock) {  // Barista stands at the counter
                        System.out.println("Worker going to waiting state");
                        lock.wait();  // Barista waits by the phone for your call
                    }
                    
                    // STEP 6b: Barista gets your call and finishes
                    System.out.println("Worker: resumed and finishing");   
                }
                
                catch(InterruptedException e) {  // "If someone shakes me awake..."
                    throw new RuntimeException(e);
                }
            }
        );  // End of barista's instructions
        
        // ===== YOU (THE CUSTOMER) =====
        
        // STEP 1: You just hired the barista - they're standing there
        System.out.println("State after creation: " + worker.getState()); // NEW
        
        // STEP 2: You tell the barista "Start working now!"
        worker.start();
        
        // You wait a tiny bit (100ms) to let barista start
        Thread.sleep(100);
        System.out.println("State after starting: " + worker.getState()); // RUNNABLE
        
        // You wait longer (500ms) - barista should be sleeping now
        Thread.sleep(500);
        System.out.println("State during sleep: " + worker.getState()); // TIMED_WAITING
        
        // You wait even longer (2000ms) - barista should be waiting now
        Thread.sleep(2000);
        System.out.println("State during sleep: " + worker.getState()); // WAITING
        
        // STEP 5: You go to the counter to call the barista
        synchronized(lock) {  // You stand at the counter
            lock.notify();    // You call the barista: "Hey, I need you!"
        }
        
        // STEP 6a: You wait for barista to finish their last tasks
        worker.join();  // You stand at the door waiting for barista to leave
        
        // STEP 7: You check one last time - barista is gone
        System.out.println("State after complete: " + worker.getState()); // TERMINATED
    }
}
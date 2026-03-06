package aThreads;

public class Thread2 {
    public static void main(String[] args) {
        
        // MANAGER: "I need to hire 5 baristas for the morning shift!"
        for (int i = 0; i < 5; i++) {
            
            // Need a copy for lambda
            int currentBarista = i;
            
            // Hire barista #i using lambda (0, 1, 2, 3, 4)
            Thread barista = new Thread(() -> {
                
                // Each barista will try to make 5 coffees
                for (int coffee = 1; coffee <= 5; coffee++) {
                    
                    // Barista announces which coffee they're making and their ID
                    System.out.println(coffee + ": Thread Number : " + currentBarista);
                    
                    // DRAMA! Barista #3 has a MELTDOWN after first coffee!
                    //if (currentBarista == 3) {
                      //  throw new RuntimeException();  // Barista #3 QUITS on the spot!
                  //  }
                    
                    // Normal baristas take 1 second to make each coffee
                    try {
                        Thread.sleep(1000);  // "Making coffee... ☕"
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            
            // Tell them to start working immediately
            barista.start();  // "Barista #" + i + ", start your shift NOW!"
        }
        // Manager's work is done - the baristas work independently
    }
}
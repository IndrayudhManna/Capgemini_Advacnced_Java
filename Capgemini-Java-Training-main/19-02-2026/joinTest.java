package aThreads;

public class joinTest {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Main: Starting program");
        
        Thread creator = new Thread(() -> {
            System.out.println("Creator: I started working");
            
            for(int i = 1; i <= 3; i++) {
                System.out.println("Creator: Working on step " + i);
                try { Thread.sleep(500); } catch(Exception e) {}
            }
            
            System.out.println("Creator: I'm done!");
        });
        
        creator.start();
        
        System.out.println("Main: About to call join()");
        //creator.join();  // ← MAIN WAITS HERE
        System.out.println("Main: join() returned! Creator is done");
        
        System.out.println("Main: Program ending");
    }
}
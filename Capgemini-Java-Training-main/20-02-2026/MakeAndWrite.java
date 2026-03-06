package aFiles;
import java.io.*;

public class MakeAndWrite {
    public static void main(String[] args) {
        
        for(int fileNum = 1; fileNum <= 5; fileNum++) {
            
            // Create a FINAL copy for the lambda to use
            int currentFile = fileNum;  // This is effectively final
            
            // Thread to create file
            Thread creator = new Thread(() -> {
                try {
                    String fileName = "src/aFiles/File" + currentFile + ".txt";
                    File file = new File(fileName);
                    
                    if(file.createNewFile()) {
                        System.out.println("Created: File" + currentFile + ".txt");
                    }
                    
                } catch(Exception e) {
                    System.out.println("Error creating file: " + e.getMessage());
                }
            });
            
            // Thread to write to file
            Thread writer = new Thread(() -> {
                try {
                    String fileName = "src/aFiles/File" + currentFile + ".txt";
                    FileWriter writer2 = new FileWriter(fileName, true);
                    writer2.write("This is file number: " + currentFile + "\n");
                    writer2.close();
                    
                    System.out.println("Wrote to: File" + currentFile + ".txt");
                    
                } catch(Exception e) {
                    System.out.println("Error writing to file: " + e.getMessage());
                }
            });
            
            creator.start();
            writer.start();
            
            // Optional: Wait for threads to finish
            try {
                creator.join();
                writer.join();
            } catch(InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
        
        System.out.println("All files processed!");
    }
}
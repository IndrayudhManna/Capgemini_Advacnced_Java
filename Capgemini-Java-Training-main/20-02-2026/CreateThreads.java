package aFiles;

import java.io.*;

public class CreateThreads {
    public static void main(String[] args) throws InterruptedException {
        String dirPath = "src/aFiles/Folder/";
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        int totalFiles = 10;
        int numThreads = 2;
        int filesPerThread = totalFiles / numThreads;

        Thread[] threads = new Thread[numThreads];

        for (int t = 0; t < numThreads; t++) {
            final int threadId = t;
            final int startIndex = t * filesPerThread + 1;
            final int endIndex = (t == numThreads - 1) ? totalFiles : (t + 1) * filesPerThread;

            threads[t] = new Thread(() -> {
                for (int i = startIndex; i <= endIndex; i++) {
                    String fileName = dirPath + "file" + i + ".txt";
                    File file = new File(fileName);
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        writer.write("test file " + i);
                    } catch (IOException e) {
                        System.out.println("Error creating file: " + fileName);
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread " + threadId + " completed files " + startIndex + " to " + endIndex);
            });
            threads[t].start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("10 files created successfully using " + numThreads + " threads!");
    }
}
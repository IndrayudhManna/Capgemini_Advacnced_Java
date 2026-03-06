package aThreads;
import java.util.*;
class Task{
	public synchronized void countDown() throws InterruptedException{	//Synchronizes the tasks. Only first thread to do the task gets to do it 
		for(int i=0;i<=5 ;i++) {
			System.out.println("Count:"+i);
		}
	}
}

public class TaskTest {
	public static void main(String[] args) {
		Task t1 = new Task();
		Thread th1 = new Thread(() ->{
			try {
				t1.countDown();
			}catch(InterruptedException e) {
				throw new RuntimeException(e);
			}
		},"TH1");
		Task t2 = new Task();			//If th2 thread does a different task then no synchronization but if same task then
										//it will have to wait until th1 is finished with the task.
		Thread th2 = new Thread(() ->{
			try {
				th1.join();           //If th2 calls th1.join() then it'll have to wait for th1 to finish even if they have different tasks.
				t2.countDown();
			}catch(InterruptedException e) {
				throw new RuntimeException(e);
			}
		},"TH1");
		th1.start();
		th2.start();
		
		
		
	}
	

}

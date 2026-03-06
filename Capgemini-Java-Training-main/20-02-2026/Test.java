
//Method 1
//If you put the for loop inside each Thread then they won't be in sync. This will create only 2 threads (for 2 thread creations) 
//but output won't be in order. Check aThreads.MultiThreading.  
//Method 2
//If you put the for loop outside and create Threads for each loop it will be in sync but it will create 2 (for 2 thread creations) * number of loops Threads.
//Check aThreads.Multithreading2 and aFilesMakeAndWrite. Threads can't be brought back once terminated so you can't make 2 
//threads without loop and call them n times in main cuz once the first iterations are dead they are dead for good.
//You need to call .join() for each one in the main for the Method 2 as you need to sync them. You also need to take a new variable to
//store the Loop Iteration number cuz Lambda doesn't accept a value that keeps changing.

//Lock can only be accessed by one person at a time. If worker1 calls Synchronized(Lock){Lock.wait();} then it must wait until someone else 
//unlocks it with a Synchronized(Lock){Lock.notify();}.

//.wait and .notify don't need Locks to work.
//Lock isn't an actual thing. It's name given by the user.
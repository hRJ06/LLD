package Concurrency;

public class MyRunnable implements Runnable {
    public void run() {
        for(int i = 0; i<5; i++) {
            System.out.println("Thread " + Thread.currentThread().threadId() + " is running - " + i);
            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

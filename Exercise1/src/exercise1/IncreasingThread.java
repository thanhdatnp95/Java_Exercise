package exercise1;

public class IncreasingThread implements Runnable {
    private String threadName;
    private Thread thread;

    IncreasingThread(String name) {
        threadName = name;
        System.out.println("Creating " +  threadName);
    }

    public void run() {
        System.out.println("Running " +  threadName);
    }

    public void start () {
        System.out.println("Starting " +  threadName);
        if (thread == null) {
            thread = new Thread (this, threadName);
            thread.start();
        }
    }
}
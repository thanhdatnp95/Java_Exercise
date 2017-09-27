package multithread;

public class RemovingThread implements Runnable {
    private String threadName;
    private Thread thread;

    RemovingThread(String name) {
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
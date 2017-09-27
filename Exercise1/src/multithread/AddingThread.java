package multithread;

import java.util.*;

/** This class is to add element to the list after 20ms */
public class AddingThread implements Runnable {
    private String threadName;
    private Thread thread;
    private LinkedList<Integer> list;
    private Random rand;

    /** Constructor */
    AddingThread(String threadName, LinkedList<Integer> list) {
        System.out.println("Creating " +  threadName);

        this.threadName = threadName;
        this.list = list;
        rand = new Random();        
    }

    public void run() {
        System.out.println("Running " +  threadName);

        while (true) {
            /* Mutual exclusion */
            synchronized(list) {
                int  n = rand.nextInt(50) + 1;
                list.addLast(n);
            }

            /* Delay 20ms */
            try {
                Thread.sleep(20);
            } catch (Exception e) {
                System.out.println(threadName + " is interrupted");
            }
        }
    }
    
    /** The start() method start the runnable thread */
    public void start () {
        System.out.println("Starting " +  threadName);
        if (thread == null) {
            thread = new Thread (this, threadName);
            thread.start();
        }
    }
}
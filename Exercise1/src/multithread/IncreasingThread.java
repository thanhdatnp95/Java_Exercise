package multithread;

import java.util.*;

/** This class is to increase value of elements of the list */
public class IncreasingThread implements Runnable {
    private String threadName;
    private Thread thread;
    private LinkedList<Integer> list;

    /** Constructor */
    IncreasingThread(String threadName, LinkedList<Integer> list) {
        this.threadName = threadName;
        this.list = list;
        System.out.println("Creating " +  threadName);
    }

    public void run() {
        System.out.println("Running " +  threadName);
        
        while (true) {
            /* Mutual exclusion */
            synchronized(list) {
                ListIterator<Integer> it = list.listIterator(); 

                while (it.hasNext()) {
                    Integer value = it.next();
                    it.set(value + 1);
                }
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
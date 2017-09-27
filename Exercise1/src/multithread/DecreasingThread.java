package multithread;

import java.util.*;

/** This class is to decrease value of elements if it is odd
and print out the list */
public class DecreasingThread implements Runnable {
    private String threadName;
    private Thread thread;
    private LinkedList<Integer> list;

    /** Constructor */
    DecreasingThread(String threadName, LinkedList<Integer> list) {
        System.out.println("Creating " +  threadName);

        this.threadName = threadName;
        this.list = list;        
    }

    public void run() {
        System.out.println("Running " +  threadName);

        while (true) {
            /* Mutual exclusion */
            synchronized(list) {
                ListIterator<Integer> it = list.listIterator(); 

                System.out.print("List:");
                while (it.hasNext()) {
                    Integer value = it.next();                    
                    if (value % 2 != 0) {
                        it.set(--value);
                    }
                    System.out.print(" " + value);
                }
                System.out.println();
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
package multithread;

import java.util.*;

/** This class is to remove element from the list after 20ms */
public class RemovingThread implements Runnable {
    private String threadName;
    private Thread thread;
    private LinkedList<Integer> list;

    /** Constructor */
    RemovingThread(String threadName, LinkedList<Integer> list) {
        System.out.println("Creating " +  threadName);

        this.threadName = threadName;
        this.list = list;
    }

    public void run() {
        System.out.println("Running " +  threadName);

        while (true) {
            /* Mutual exclusion */
            synchronized(list) {
                try {
                    list.removeFirst();
                } catch (NoSuchElementException e) {
                    System.out.println("Nothing to remove");
                }
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
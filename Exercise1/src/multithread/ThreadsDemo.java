package multithread;

import java.util.*;

/** This class is the main class */
public class ThreadsDemo {

    public static void main(String args[]) {
        /* Declare some essential variable */
        LinkedList<Integer> list = new LinkedList<Integer>();

        IncreasingThread incThread = new IncreasingThread("Increasing Thread", list);
        DecreasingThread decThread = new DecreasingThread("Decreasing Thread", list);
        AddingThread addThread = new AddingThread("Adding Thread", list);
        RemovingThread rmThread = new RemovingThread("Removing Thread", list);

        /* Start all threads */
        incThread.start();
        decThread.start();
        addThread.start();
        rmThread.start();
    }
}
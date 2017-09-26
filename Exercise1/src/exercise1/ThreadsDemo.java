package exercise1;

public class ThreadsDemo {
    public static void main(String args[]) {
        IncreasingThread incThread = new IncreasingThread("Increasing Thread");
        DecreasingThread decThread = new DecreasingThread("Decreasing Thread");
        AddingThread addThread = new AddingThread("Adding Thread");
        RemovingThread rmThread = new RemovingThread("Removing Thread");

        incThread.start();
        decThread.start();
        addThread.start();
        rmThread.start();
    }
}
package multithread;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
    TestAddingThread.class,
    TestRemovingThread.class,
    TestIncreasingThread.class,
    TestDecreasingThread.class
})

public class TestAll {   
}
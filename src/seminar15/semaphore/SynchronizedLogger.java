package seminar15.semaphore;

import java.util.ArrayList;

/**
 * SynchronizedLogger class is used to keep track of thread activities
 * Logs are saved synchronously in a list
 */
public class SynchronizedLogger {
    private static final ArrayList<String> log = new ArrayList<String>();

    public static synchronized void log(String str) {
        log.add(Thread.currentThread().getName() + " - " + str);
    }
    
    public static synchronized void dumpLog(){
        int size = log.size();
        for (int i = 0; i < size; i++) {
            System.out.println(log.get(i));
        }
    }
}

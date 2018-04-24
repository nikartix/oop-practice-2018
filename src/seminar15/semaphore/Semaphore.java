package seminar15.semaphore;

public interface Semaphore {

    void acquire() throws InterruptedException;

    void release();

}

package Utilities.ParallelExecution;

import java.util.concurrent.TimeUnit;

public class ParallelDelayManager {
    private static final Object lock = new Object();
    private static long lastExecutionTime = 0;
    public static void addDelayBuffer(long delayInMillis) {
        synchronized (lock) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - lastExecutionTime;
            if (elapsedTime < delayInMillis) {
                try {
                    TimeUnit.MILLISECONDS.sleep(delayInMillis - elapsedTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            lastExecutionTime = System.currentTimeMillis();
        }
    }
}
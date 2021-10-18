package ch.hslu.ad.exercise.n1.addition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdditionTask implements Runnable {
    private static final Logger LOG = LogManager.getLogger(AdditionTask.class);

    private Thread runThread;
    private int rangeBegin;
    private int rangeEnd;

    public AdditionTask(int rangeBegin, int rangeEnd) {
        this.rangeBegin = rangeBegin;
        this.rangeEnd = rangeEnd;
    }

    @Override
    public void run() {
        this.runThread = Thread.currentThread();
        // Initialisierungsphase
        long sum = 0;
        // Arbeitsphase
        for (int i = this.rangeBegin; i <= this.rangeEnd; i++) {
            sum += i;
        }
        // Abschlussphase
        if (!isStopped()) {
            LOG.info(runThread.getName() + ": SUM -> " + sum);
        }
        else {
            LOG.info(runThread.getName() + ": interrupted.");
        }

    }

    private boolean isStopped() {
        return !this.runThread.isInterrupted();
    }
}

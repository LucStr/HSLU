package ch.hslu.ad.exercise.n1.joinAndSleep;

import ch.hslu.ad.exercise.n1.bank.DemoBankAccount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JoinAndSleep implements Runnable{
    private static final Logger LOG = LogManager.getLogger(JoinAndSleep.class);

    private Thread threadToJoin;
    private int timeToSleep;

    public JoinAndSleep(Thread threadToJoin, int timeToSleep){
        this.threadToJoin = threadToJoin;
        this.timeToSleep = timeToSleep;
    }

    @Override
    public void run() {
        LOG.info(Thread.currentThread().getName() + "Entered Run");
        try {
            if(threadToJoin != null){
                threadToJoin.join();
            }

            LOG.info(Thread.currentThread().getName() + "Starting to wait");
            Thread.sleep(timeToSleep);
            LOG.info(Thread.currentThread().getName() + "Finished waiting");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

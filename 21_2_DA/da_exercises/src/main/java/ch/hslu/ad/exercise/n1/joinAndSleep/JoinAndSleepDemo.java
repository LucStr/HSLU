package ch.hslu.ad.exercise.n1.joinAndSleep;

public final class JoinAndSleepDemo {
    public static void main(String[] args) {
        var t3 = new Thread(new JoinAndSleep(null, 4000), "T3 - ");
        var t2 = new Thread(new JoinAndSleep(t3, 3000), "T2 - ");
        var t1 = new Thread(new JoinAndSleep(t2, 2000), "T1 - ");

        t1.start();
        t2.start();
        t3.start();
    }
}

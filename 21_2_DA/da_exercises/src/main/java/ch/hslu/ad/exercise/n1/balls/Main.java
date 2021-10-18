package ch.hslu.ad.exercise.n1.balls;

import ch.hslu.ad.exercise.e1.Task;

import java.util.ArrayList;
import java.util.List;

public final class Main {
    public static void main(final String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<Thread>();

        for(var i = 0; i < 20; i++){
            var thread = new Thread(new BallTask());
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.exit(0);
    }
}

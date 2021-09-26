package ch.hslu.ad.sw01.e1;

import java.util.logging.Logger;

public class Task {
    private int count;
    private Logger logger;

    public Task() {
        this.logger = Logger.getLogger("Task");
    }

    public void task(final int n) {
        task1(); task1(); task1(); task1(); // T ~ 4
        for (int i = 0; i < n; i++) { // äussere Schleife: n-mal
            task2(); task2(); task2(); // T ~ n · 3
            for (int j = 0; j < n; j++) { // innerer Schleife: n-mal
                task3(); task3(); // T ~ n · n· 2
            }
        }
        logger.info("Started with: " + n + "Ended with: " + count);
    }

    private void incrementCount(){
        count++;
        //logger.info("CURRENT COUNT: " + count);
    }

    private void task1() {
        incrementCount();
    }

    private void task2() {
        incrementCount();
    }

    private void task3() {
        incrementCount();
    }

    public static void main(final String[] args) {
        new Task().task(1);
        new Task().task(2);
        new Task().task(5);
        new Task().task(10);
        new Task().task(15);
        new Task().task(20);
        new Task().task(30);
        new Task().task(50);
        new Task().task(100);
    }

}

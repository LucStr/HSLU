package ch.hslu.ad.exercise.n1.addition;

import java.util.ArrayList;

public final class AdditionDemo {
    public static void main(String[] args) throws InterruptedException {
        var threads = new ArrayList<Thread>(){
            {
                add(new Thread(new AdditionTask(10, 155453)));
                add(new Thread(new AdditionTask(1553, 154553)));
                add(new Thread(new AdditionTask(1450, 154553)));
                add(new Thread(new AdditionTask(10210, 155254543)));
                add(new Thread(new AdditionTask(11010, 155453)));
            }
        };

        for (Thread thread : threads) {
            thread.start();
        }

        Thread.sleep(10);

        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}

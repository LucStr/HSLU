package ch.hslu.ad.exercise.d1;

import java.util.Arrays;

public class Queue<T> implements Queueable<T>{
    private T[] queue;
    private int head;
    private int tail;

    public static int DEFAULT_QUEUE_SIZE = 10;

    public Queue(){
        this(DEFAULT_QUEUE_SIZE);
    }

    public Queue(int size){
        queue = (T[]) new Object[size];
        head = -1;
        tail = -1;
    }

    @Override
    public void enqueue(T item) {
        tail = (tail + 1) % queue.length;
        queue[tail] = item;
    }

    @Override
    public T dequeue() {
        head = (head + 1) % queue.length;
        return queue[head];
    }

    @Override
    public String toString() {
        return "Queue{" +
                "queue=" + Arrays.toString(queue) +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}

package ch.hslu.ad.exercise.d1;

public interface Queueable<T> {
    void enqueue(T item);

    T dequeue();
}

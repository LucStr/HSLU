package ch.hslu.ad.sw01.d1;

public interface Queueable<T> {
    void enqueue(T item);

    T dequeue();
}

package ch.hslu.ad.exercise.d2;

public interface BinarySearchable<K extends Comparable<K>, V> {
    V search(K key);
    void remove(K key);
    void add(K key, V value);
    boolean hasKey(K key);
    void addOrUpdate(K key, V value);
}

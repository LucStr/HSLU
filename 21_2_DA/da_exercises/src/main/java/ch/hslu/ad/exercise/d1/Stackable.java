package ch.hslu.ad.exercise.d1;


/**
 * StringStackable interface is used for object having stackable Strings
 */
public interface Stackable<T> {
    /**
     * @return The total size of the stack
     */
    int totalSize();

    /**
     * @return Size filled with items
     */
    int size();

    /**
     * @return If the stack is full
     */
    boolean isFull();

    /**
     * @param item the item to be pushed to the stack
     */
    void push(T item);

    /**
     * @return The top most item will be returned;
     */
    T pop();
}

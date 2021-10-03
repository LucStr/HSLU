package ch.hslu.ad.sw01.d1;


/**
 * StringStackable interface is used for object having stackable Strings
 */
public interface StringStackable {
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
    void push(String item);

    /**
     * @return The top most item will be returned;
     */
    String pop();
}

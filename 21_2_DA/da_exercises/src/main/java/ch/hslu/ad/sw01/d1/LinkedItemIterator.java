package ch.hslu.ad.sw01.d1;

import java.util.Iterator;

public class LinkedItemIterator<T> implements Iterator<T> {
    private LinkedItem<T> next;

    public LinkedItemIterator(LinkedItem<T> startItem) {
        this.next = startItem;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public T next() {
        var result = next.getItem();
        this.next = next.getNextItem();

        return result;
    }
}

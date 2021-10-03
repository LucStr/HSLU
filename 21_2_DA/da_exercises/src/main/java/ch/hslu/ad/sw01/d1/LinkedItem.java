package ch.hslu.ad.sw01.d1;

import java.util.Iterator;

public class LinkedItem<T> {
    private final T item;
    private LinkedItem<T> nextItem;

    public LinkedItem(final T item){
        this(item, null);
    }

    public LinkedItem(final T item, final LinkedItem<T> nextItem){
        this.item = item;
        this.nextItem = nextItem;
    }


    public void setNextItem(final LinkedItem<T> nextItem){
        this.nextItem = nextItem;
    }

    public T getItem(){
        return this.item;
    }

    public LinkedItem<T> getNextItem(){
        return nextItem;
    }
}


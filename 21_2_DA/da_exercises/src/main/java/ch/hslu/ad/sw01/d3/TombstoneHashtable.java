package ch.hslu.ad.sw01.d3;

import java.util.ArrayList;
import java.util.List;

public class TombstoneHashtable<T> {
    private List<TombstoneableItem<T>> list;
    private int filledSize = 0;
    private final int size;

    public final static int HASHTABLE_DEFAULT_SIZE = 10;

    public TombstoneHashtable(){
        this(HASHTABLE_DEFAULT_SIZE);
    }

    public TombstoneHashtable(int size){
        list = new ArrayList<>(size);
        this.size = size;

        for(var i = 0; i < size; i++){
            list.add(null);
        }
    }

    public T getItem(int hash){
        var item = list.get(getIndexFromHash(hash));

        return item == null || item.isDead() ? null : item.getItem();
    }

    public boolean isFull(){
        return filledSize == size;
    }

    public void addItem(T item){
        if(isFull() && !item.equals(getItem(item.hashCode()))){
            throw new IndexOutOfBoundsException("The Item cannot be added, The Hashtable is full. Try increasing the Size of your Hashtable");
        }

        var index = getIndex(item, true);

        if(list.get(index) == null){
            list.set(index, new TombstoneableItem<>());
        }

        list.get(index).reincarnate(item);
        filledSize++;
    }

    public boolean removeItem(T item){
        var index = getIndex(item, false);

        if(index == null){
            return false;
        }

        if(list.get(index + 1) != null){
            list.get(index).kill();
        } else {
            list.set(index, null);
        }

        filledSize--;
        return true;
    }

    private Integer getIndex(T item, boolean canBeEmpty){
        var perfectIndex = getIndexFromHash(item.hashCode());
        var index = perfectIndex;

        do {
            var isNullAndCanBeEmpty = list.get(index) == null && canBeEmpty;
            var isNotNullAndEitherAliveOrEqualToTheItem = list.get(index) != null && (list.get(index).isDead() || list.get(index).getItem().equals(item));

            if(isNullAndCanBeEmpty || isNotNullAndEitherAliveOrEqualToTheItem){
                return index;
            }

            index = (index + 1) % size;
        } while(perfectIndex != index);

        return null;
    }

    private int getIndexFromHash(int hash){
        return hash % size;
    }
}

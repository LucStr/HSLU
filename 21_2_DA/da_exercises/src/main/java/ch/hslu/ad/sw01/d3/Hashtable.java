package ch.hslu.ad.sw01.d3;

public class Hashtable<T> {
    private T[] array;

    public final static int HASHTABLE_DEFAULT_SIZE = 10;

    public Hashtable(){
        this(HASHTABLE_DEFAULT_SIZE);
    }

    public Hashtable(int size){
        array = (T[]) new Object[size];
    }

    public T getItem(int hash){
        return array[getIndexFromHash(hash)];
    }

    public void addItem(T item){
        var index = getIndex(item);

        if(array[index] != null && !array[index].equals(item)){
            throw new IndexOutOfBoundsException("The Item cannot be added, as there is an Index Conflict with it's hash. Try increasing the Size of your Hashtable");
        }

        array[index] = item;
    }

    public boolean removeItem(T item){
        var index = getIndex(item);

        if(array[index] == null || !array[index].equals(item)){
            return false;
        }

        array[index] = null;

        return true;
    }

    private int getIndex(T item){
        return getIndexFromHash(item.hashCode());
    }

    private int getIndexFromHash(int hash){
        return hash % array.length;
    }
}

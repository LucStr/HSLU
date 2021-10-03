package ch.hslu.ad.sw01.d1;

public class LinkedList<T> {
    private LinkedItem<T> start;

    public LinkedList(T[] array){
        if(array.length == 0){
            throw new IllegalArgumentException("The Array has to contain at least one item");
        }

        start = new LinkedItem(array[0]);
        var current = start;
        for (var i = 1; i < array.length; i++) {
            var next = new LinkedItem(array[i]);
            current.setNextItem(next);
            current = next;
        }
    }

    public int size(){
        var iterator = this.getIterator();
        var count = 0;
        while (iterator.hasNext()){
            iterator.next();
            count++;
        }

        return count;
    }

    public boolean remove(T item){
        if(start.getItem() == item){
            start = start.getNextItem();
            return true;
        }

        LinkedItem<T> previous = start;
        while (previous.getNextItem() != null){
            var next = previous.getNextItem();
            if(next.getItem() == item){
                previous.setNextItem(next.getNextItem());
                return true;
            }
            previous = next;
        }

        return false;
    }

    public void add(T item){
        start = new LinkedItem<>(item, start);
    }


    public LinkedItemIterator<T> getIterator() {
        return new LinkedItemIterator(start);
    }
}

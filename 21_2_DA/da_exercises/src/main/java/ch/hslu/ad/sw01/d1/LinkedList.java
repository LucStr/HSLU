package ch.hslu.ad.sw01.d1;

public class LinkedList<T> {
    private LinkedItem<T> head;

    public LinkedList(){
        head = null;
    }

    public LinkedList(T[] array){
        if(array.length == 0){
            throw new IllegalArgumentException("The Array has to contain at least one item");
        }

        head = new LinkedItem(array[0]);
        var current = head;
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
        if(head.getItem() == item){
            head = head.getNextItem();
            return true;
        }

        LinkedItem<T> previous = head;
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
        head = new LinkedItem<>(item, head);
    }


    public LinkedItemIterator<T> getIterator() {
        return new LinkedItemIterator(head);
    }
}

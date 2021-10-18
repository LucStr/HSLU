package ch.hslu.ad.sw01.d1;

public class Stack<T> implements Stackable<T> {
    private T[] stack;
    private int pointer;

    public static int DEFAULT_STACK_SIZE = 10;

    public Stack(){
        this(DEFAULT_STACK_SIZE);
    }

    public Stack(int size){
        stack = (T[]) new Object[size];
        pointer = -1;
    }

    @Override
    public int totalSize() {
        return stack.length;
    }

    @Override
    public int size() {
        return pointer + 1;
    }

    @Override
    public boolean isFull() {
        return totalSize() == size();
    }

    @Override
    public void push(T item) throws IndexOutOfBoundsException {
        stack[++pointer] = item;
    }

    @Override
    public T pop() throws IndexOutOfBoundsException {
        return stack[pointer--];
    }
}

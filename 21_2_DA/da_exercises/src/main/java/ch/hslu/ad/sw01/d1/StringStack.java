package ch.hslu.ad.sw01.d1;

public class StringStack implements StringStackable {
    private String[] stack;
    private int pointer;

    public static int DEFAULT_STACK_SIZE = 10;

    public StringStack(){
        this(DEFAULT_STACK_SIZE);
    }

    public StringStack(int size){
        stack = new String[size];
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
    public void push(String item) {
        stack[++pointer] = item;
    }

    @Override
    public String pop() {
        return stack[pointer--];
    }
}

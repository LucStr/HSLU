package ch.hslu.ad.sw01.d3;

import ch.hslu.ad.sw01.d1.Stack;
import ch.hslu.ad.sw01.e0.Allokation;

public final class StackPerformance {
    public final static int STACK_SIZE = 100000000;

    public static Allokation[] getTestAllocations(){
        var array = new Allokation[STACK_SIZE];

        for (var i = 0; i < STACK_SIZE; i++){
            array[i] = new Allokation(i * 10, 10);
        }

        return array;
    }

    public static void main(final String[] args) {
        var array = getTestAllocations();

        benchMarkOwn(array);
        benchMarkJava(array);
    }

    public static void benchMarkOwn(Allokation[] array){
        var start = System.currentTimeMillis();

        var stack = new Stack<Allokation>(STACK_SIZE);

        for (var i = 0; i < STACK_SIZE; i++) {
            stack.push(array[i]);
        }

        for (var i = 0; i < STACK_SIZE; i++) {
            stack.pop();
        }

        var end = System.currentTimeMillis();
        System.out.format("Own Implementation took %d ms!%n", end - start);
    }

    public static void benchMarkJava(Allokation[] array){
        var start = System.currentTimeMillis();

        var stack = new java.util.Stack<Allokation>();

        for (var i = 0; i < STACK_SIZE; i++) {
            stack.push(array[i]);
        }

        for (var i = 0; i < STACK_SIZE; i++) {
            stack.pop();
        }

        var end = System.currentTimeMillis();
        System.out.format("Java Implementation took %d ms!%n", end - start);
    }
}

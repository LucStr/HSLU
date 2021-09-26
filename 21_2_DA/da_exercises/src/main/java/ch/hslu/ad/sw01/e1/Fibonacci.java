package ch.hslu.ad.sw01.e1;

import java.util.ArrayList;
import java.util.List;

public final class Fibonacci {
    private final int[] buffer;

    public Fibonacci() {
        buffer = new int[]{0, 1};
    }

    public int fiboRec1(final int n){
        if(n == 0){
            return 0;
        } else if(n == 1){
            return 1;
        }

        return fiboRec1(n - 1) + fiboRec1(n - 2);
    }

    public int fiboRec2(final int n){
        try{
            return buffer[n];
        } catch (IndexOutOfBoundsException e) {
            return fiboRec2(n - 1) + fiboRec2(n - 2);
        }
    }

    public int fiboIter(final int n){
        var lastResult = 1;
        var result = 1;
        int newResult;

        for(var i = 2; i < n; i++){
            newResult = result + lastResult;
            lastResult = result;
            result = newResult;
        }

        return result;
    }
}

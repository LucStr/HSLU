package ch.hslu.ad.sw01.e1;

import ch.hslu.ad.sw01.e0.Allokation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    @Test
    void testRec1FibZero() {
        assertEquals(0, new Fibonacci().fiboRec1(0));
    }

    @Test
    void testRec1FibOne() {
        assertEquals(1, new Fibonacci().fiboRec1(1));
    }

    @Test
    void testRec1FibThree() {
        assertEquals(2, new Fibonacci().fiboRec1(3));
    }

    @Test
    void testRec1FibSix() {
        assertEquals(8, new Fibonacci().fiboRec1(6));
    }

    @Test
    void testRec2FibZero() {
        assertEquals(0, new Fibonacci().fiboRec2(0));
    }


    @Test
    void testRec2FibOne() {
        assertEquals(1, new Fibonacci().fiboRec2(1));
    }

    @Test
    void testRec2FibThree() {
        assertEquals(2, new Fibonacci().fiboRec2(3));
    }

    @Test
    void testRec2FibSix() {
        assertEquals(8, new Fibonacci().fiboRec2(6));
    }

    @Test
    void testIterFibOne() {
        assertEquals(1, new Fibonacci().fiboIter(1));
    }

    @Test
    void testIterFibThree() {
        assertEquals(2, new Fibonacci().fiboIter(3));
    }

    @Test
    void testIterFibSix() {
        assertEquals(8, new Fibonacci().fiboIter(6));
    }

    @Test
    void testIterFibThirtySix() {
        assertEquals(14930352, new Fibonacci().fiboIter(36));
    }
}
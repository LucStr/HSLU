package ch.hslu.ad.sw01.d1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    @Test
    void testSize() {
        var list = new LinkedList<>(new Integer[] {1, 4, 6});

        assertEquals(3, list.size());
    }

    @Test
    void testAdd(){
        Integer a1 = 1;
        Integer a2 = 4;
        Integer a3 = 6;

        var list = new LinkedList<>(new Integer[] {a1, a2, a3});
        list.add(5);

        assertEquals(4, list.size());
    }

    @Test
    void testRemove(){
        Integer a1 = 1;
        Integer a2 = 4;
        Integer a3 = 6;

        var list = new LinkedList<>(new Integer[] {a1, a2, a3});

        assertTrue(list.remove(a2));
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveFirstElement(){
        Integer a1 = 1;
        Integer a2 = 4;
        Integer a3 = 6;

        var list = new LinkedList<>(new Integer[] {a1, a2, a3});

        assertTrue(list.remove(a1));
        assertEquals(2, list.size());
    }

    @Test
    void testFalseIfNotRemoved(){
        Integer a1 = 1;
        Integer a2 = 4;
        Integer a3 = 6;
        Integer a4 = 8;

        var list = new LinkedList<>(new Integer[] {a1, a2, a3});

        assertFalse(list.remove(a4));
        assertEquals(3, list.size());
    }
}
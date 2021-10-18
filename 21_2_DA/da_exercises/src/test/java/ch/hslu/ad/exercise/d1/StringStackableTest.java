package ch.hslu.ad.exercise.d1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringStackableTest {
    @Test
    void testEmptyStackOnCreation() {
        StringStackable stack = new StringStack();

        assertEquals(0, stack.size());
    }

    @Test
    void testNotEmptyAfterAdding() {
        StringStackable stack = new StringStack();
        stack.push("");

        assertEquals(1, stack.size());
    }

    @Test
    void testStackIsFull() {
        StringStackable stack = new StringStack(1);
        stack.push("");

        assertTrue(stack.isFull());
    }

    @Test
    void testStackIsEmptyAfterCreation() {
        StringStackable stack = new StringStack();

        assertFalse(stack.isFull());
    }

    @Test
    void testGetLastItem(){
        StringStackable stack = new StringStack();

        stack.push("This");
        stack.push("Is");
        stack.push("A");
        stack.push("Test");

        assertEquals("Test", stack.pop());
    }

    @Test
    void testGetLastItemAfterPop(){
        StringStackable stack = new StringStack();

        stack.push("This");
        stack.push("Is");
        stack.push("A");
        stack.pop();
        stack.push("Test");
        stack.pop();

        assertEquals("Is", stack.pop());
    }

}
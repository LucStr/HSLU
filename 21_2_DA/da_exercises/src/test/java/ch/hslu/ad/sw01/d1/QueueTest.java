package ch.hslu.ad.sw01.d1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    @Test
    void testQueueWorking(){
        Queueable<Integer> test = new Queue();

        test.enqueue(4);
        test.enqueue(5);
        test.enqueue(6);

        assertEquals(4, test.dequeue());
        assertEquals(5, test.dequeue());
    }
}
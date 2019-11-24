package ua.edu.ucu.autocomplete;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.queue.Queue;

import static junit.framework.TestCase.assertEquals;

public class QueueTest {
    private Queue queue1;
    private Queue queue2;

    @Before
    public void init() {
        queue1 = new Queue();
        for (int i = 1; i <= 5; i++) {
            queue1.enqueue(i);
        }
        queue2 = new Queue();
    }

    @Test
    public void testPeek() {
        assertEquals(1, queue1.peek());
    }

    @Test
    public void testDequeue() {
        assertEquals(1, queue1.dequeue());
        assertEquals(2, queue1.dequeue());
        assertEquals(3, queue1.dequeue());
        assertEquals(4, queue1.dequeue());
        assertEquals(5, queue1.dequeue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyQueueDequeue() {
        queue2.dequeue();
    }
}

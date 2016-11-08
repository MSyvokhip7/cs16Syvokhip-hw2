package ua.edu.ucu.collections;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


public class QueueTest {
    @Test
    public void peek() throws Exception {
        Queue myQueue = new Queue();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        assertEquals(myQueue.peek(), 1);
    }

    @Test
    public void enqueue() throws Exception {
        Queue myQueue = new Queue();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        assertEquals(myQueue.toString(), "1 2 3 ");
    }
}

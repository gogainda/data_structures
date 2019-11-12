package com.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AryQueueTest {

    @Test
    void testQueue() {
        MyQueue queue = new AryQueue();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        assertEquals("a", queue.dequeue());
    }

}
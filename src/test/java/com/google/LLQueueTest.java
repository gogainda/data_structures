package com.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LLQueueTest {

    @Test
    void enqueTest() {
        LLQueue queue = new LLQueue();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        assertEquals("a", queue.dequeue());
    }

}
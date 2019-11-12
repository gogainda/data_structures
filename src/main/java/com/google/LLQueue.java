package com.google;

import java.util.LinkedList;
import java.util.List;

public class LLQueue implements MyQueue {
    LinkedList<String> items = new LinkedList<>();
    @Override
    public void enqueue(String v) {
        items.addFirst(v);

    }

    @Override
    public String dequeue() {
        return items.removeLast();
    }

    @Override
    public void empty() {
        items.clear();

    }
}

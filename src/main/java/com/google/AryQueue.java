package com.google;

public class AryQueue implements MyQueue {
    String[] ary = new String[4];
    int readIdx = 0;
    int writeIdx = 0;

    @Override
    public void enqueue(String v) {
        ary[writeIdx] = v;
        writeIdx++;

    }

    @Override
    public String dequeue() {
        String value = ary[readIdx];
        readIdx++;
        return value;
    }

    @Override
    public void empty() {

    }
}

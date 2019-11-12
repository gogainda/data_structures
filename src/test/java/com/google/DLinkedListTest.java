package com.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DLinkedListTest {

    @Test
    void pushFront() {
        DLinkedList list = new DLinkedList();
        list.pushFront('a');
        list.pushFront('b');
        list.pushFront('c');

        assertEquals("c, b, a, ", list.toString());
    }

    @Test
    void popFront() {
        DLinkedList list = new DLinkedList();
        list.pushFront('a');
        list.pushFront('b');
        list.popFront();

        assertEquals("a, ", list.toString());
    }

    @Test
    void pushBack() {
        DLinkedList list = new DLinkedList();
        list.pushBack('a');
        list.pushBack('b');
        list.pushBack('c');

        assertEquals("a, b, c, ", list.toString());
    }

    @Test
    void popBack() {
        DLinkedList list = new DLinkedList();
        list.pushBack('a');
        list.pushBack('b');
        list.pushBack('c');
        list.popBack();

        assertEquals("a, b, ", list.toString());
    }

    @Test
    void size() {
        DLinkedList list = new DLinkedList();
        list.pushBack('a');
        list.pushBack('b');
        list.pushBack('c');
        list.popBack();

        assertEquals(2, list.size());
    }

    @Test
    void size2() {
        DLinkedList list = new DLinkedList();
        list.pushBack('a');
        list.pushBack('b');
        list.popBack();
        list.popBack();
        list.popBack();

        assertEquals(0, list.size());
    }

    @Test
    void empty() {
        DLinkedList list = new DLinkedList();

        assertEquals(true, list.empty());
    }

    @Test
    void valueAt() {
        DLinkedList list = new DLinkedList();
        list.pushFront('a');
        list.pushFront('b');
        list.pushFront('c');

        assertEquals('a', list.valueAt(2));
    }

    @Test
    void insert() {
        DLinkedList list = new DLinkedList();
        list.pushBack('a');
        list.pushBack('b');
        list.pushBack('c');
        list.insert(1, 'x');

        assertEquals("a, x, b, c, ", list.toString());
    }

    @Test
    void front() {
        DLinkedList list = new DLinkedList();
        list.pushBack('a');
        list.pushBack('b');
        list.pushBack('c');

        assertEquals('a', list.front());
    }

    @Test
    void back() {
        DLinkedList list = new DLinkedList();
        list.pushBack('a');
        list.pushBack('b');
        list.pushBack('c');

        assertEquals('c', list.back());
    }

    @Test
    void erase() {
        DLinkedList list = new DLinkedList();
        list.pushBack('a');
        list.pushBack('b');
        list.pushBack('c');
        list.erase(1);

        assertEquals("a, c, ", list.toString());
    }

    @Test
    void valueNFromEnd() {
        DLinkedList list = new DLinkedList();
        list.pushBack('a');
        list.pushBack('b');
        list.pushBack('c');
        list.pushBack('d');
        list.pushBack('e');

        assertEquals('d', list.valueNFromEnd(1));
    }


}
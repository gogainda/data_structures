package com.google;

public class DLinkedList{
    final private LListNode head;
    int size;

    public DLinkedList() {
        LListNode sentinel = new LListNode();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        head = sentinel;
    }

    public void pushFront(Character value) {
        if (value == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        if (head.prev.value ==null) {
            LListNode node = new LListNode();
            node.value = value;
            node.next = head;
            node.prev = head;

            head.prev = node;
            head.next = node;

        } else {
            LListNode node = new LListNode();
            node.value = value;
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }
        size++;
    }

    public void popFront() {
        if (head.next.value == null) {
            return;
        }
        LListNode firstEl = head.next;
        head.next = firstEl.next;
        head.next.prev = head;
        firstEl.prev = null;
        firstEl.next = null;
        size--;


    }

    public void pushBack(Character value) {
        if (value == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        if (isFirstElement()) {
            LListNode node = new LListNode();
            node.value = value;
            node.next = head;
            node.prev = head;
            head.prev = node;
            head.next = node;

        } else {
            LListNode prevEl = head.prev;

            LListNode node = new LListNode();
            node.value = value;
            node.next = head;
            node.prev = prevEl;

            head.prev = node;



            prevEl.next = node;
        }
        size++;
    }

    private boolean isFirstElement() {
        return head.prev.value ==null;
    }

    public void popBack() {
        if (head.prev.value == null) {
            return;
        }
        LListNode lastEl = head.prev;

        head.prev = lastEl.prev;
        head.prev.next = head;

        lastEl.prev = null;
        lastEl.next = null;
        size--;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public Character valueAt(int p) {
        int i = 0;
        Character result = null;
        LListNode nextEl = head.next;
        while(i <= p) {
            if (i == p) {
                result = nextEl.value;
                break;
            } else {
                nextEl = nextEl.next;
            }
            i++;
        }
        return result;
    }

    public void insert(int p, char x) {
        int i = 0;
        LListNode nextEl = head.next;
        LListNode node = new LListNode();
        node.value = x;

        while(i <= p) {
            if (i == p) {
                node.next = nextEl;
                node.prev = nextEl.prev;
                nextEl.prev.next = node;
                nextEl.prev = node;

                break;
            } else {
                nextEl = nextEl.next;
            }
            i++;
        }
    }

    public Character front() {
        return head.next.value;
    }

    public Character back() {
        return head.prev.value;
    }

    public void erase(int p) {

        int i = 0;
        LListNode nextEl = head.next;

        while(i <= p) {
            if (i == p) {
                nextEl.prev.next = nextEl.next;
                nextEl.next.prev = nextEl.prev;
                nextEl.next = null;
                nextEl.prev = null;

                break;
            } else {
                nextEl = nextEl.next;
            }
            i++;
        }
    }

    public Character valueNFromEnd(int p) {
        int i = 0;
        LListNode nextEl = head.prev;
        Character result = null;
        while(i <= p) {
            if (i == p) {
                result =  nextEl.value;

                break;
            } else {
                nextEl = nextEl.prev;
            }
            i++;
        }
        return result;
    }


    private class LListNode {
        LListNode prev;
        LListNode next;
        Character value;

        @Override
        public String toString() {
            return "LListNode{" +
                    ", value=" + value +
                    '}';
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LListNode nextItem = head.next;
        Character nextItemValue = head.next.value;

        while(nextItemValue != null) {
            sb.append(nextItemValue);
            sb.append(", ");
            nextItem = nextItem.next;
            nextItemValue = nextItem.value;
        }
        return sb.toString();
    }
}


package com.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaxHeap {
   int [] data = new int[16];
   int size = 1;

    void insert(int value) {
        data[size]  = value;
        siftUp(size);
        size++;

    }

    List<Integer> getData() {
        return Arrays.stream(data).skip(1).limit(size).boxed().collect(Collectors.toList());
    }

    private void siftUp(int i) {
        int currentIdx = i;
        while (data[parent(currentIdx)] < data[currentIdx]) {
            swap(currentIdx, parent(currentIdx));
            currentIdx = parent(currentIdx);
        }
    }

    private int parent(int i) {
        if (i == 1) {
            return i;
        }
        return i / 2;
    }

    public int getMax() {
        return data[1];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 1;
    }

    public int extractMax() {
        int result = getMax();
        swap(1, size - 1);
        size--;
        siftDown(1);

        return result;
    }

    private void swap(int i, int i2) {
        int tmp = data[i];
        data[i] = data[i2];
        data[i2] = tmp;
    }

    private void siftDown(int i) {


            int leftValue = i * 2 <= size ? data[i * 2] : -1;
            int rightValue = i * 2 + 1 <= size ? data[i * 2 + 1] : -1;
            if (leftValue == -1 && rightValue == -1 ) {
                return;
            }

            if (leftValue > rightValue) {
                swap(i, i * 2);
                siftDown(i * 2);
            } else {
                swap(i, i * 2 + 1);
                siftDown(i * 2 + 1);
            }


    }

    public void remove(int i) {
        data[i] = Integer.MAX_VALUE;
        siftUp(i);
        extractMax();
    }

    public void heapify(List<Integer> asList) {
        data = new int[asList.size() + 1];
        for(int i = 1; i < data.length; i++) {
            data[i] = asList.get(i - 1);
        }
        size = asList.size();
        for(int i = size / 2 + 1; i >= 1; i--) {
            siftDown(i);
        }
    }

    public List<Integer> heapSort() {
        while(size > 2) {
            swap(1, size);
            size--;
            siftDown(1);
        }
    return Arrays.stream(data).boxed().collect(Collectors.toList());
    }
}

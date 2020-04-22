package com.google.sorting;

public class MyMergeSort {
    public static void sort(int[] ary) {
        int[] result = new int[ary.length];
        mergeSort(0, ary.length - 1, ary, result);
    }

    private static void mergeSort(int lo, int hi, int[] ary, int[] result) {
        if (lo < hi) {
            int mid = (hi + lo) / 2;
            mergeSort(lo, mid, ary, result);
            mergeSort(mid + 1, hi, ary, result);
            merge(lo, mid, mid + 1, hi, ary, result);
        }
    }

    private static void merge(int lo, int hi, int lo2, int hi2, int[] ary, int[] result) {
        int k = lo;
        int i = lo;
        int j = lo2;
        while (i <= hi && j <= hi2) {
            if (ary[i] < ary[j]) {
                result[k++] = ary[i++];
            } else {
                result[k++] = ary[j++];
            }
        }
        while(i <= hi) {
            result[k++] = ary[i++];
        }
        while(j <= hi2) {
            result[k++] = ary[j++];
        }
        System.arraycopy(result, lo, ary, lo, hi2 - lo + 1);
    }
}

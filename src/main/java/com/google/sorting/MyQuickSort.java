package com.google.sorting;

public class MyQuickSort {
  public static void sort(int[] ary) {
    quickSort(0, ary.length - 1, ary);
  }

  private static void quickSort(int lo, int hi, int[] ary) {
    if (lo < hi) {
      int pivot = partition(lo, hi, ary);
      quickSort(lo, pivot - 1, ary);
      quickSort(pivot + 1, hi, ary);
    }
  }

  private static int partition(int lo, int hi, int[] a) {
    int i = lo;
    int j = hi;
    int pivot = a[lo];
    while (i < j) {
      while (a[i] <= pivot && i < j) {

        i++;
      }
      while (a[j] > pivot && i <= j) {
        j--;
      }
      if (i < j) {
          int tmp = a[i];
          a[i] = a[j];
          a[j] = tmp;
      }

    }
    if (i >= j) {
      int tmp = a[j];
      a[j] = a[lo];
      a[lo] = tmp;
    }
    return j;
  }
}

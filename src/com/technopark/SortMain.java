package com.technopark;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SortMain {
    private static int[] array = new int[]{5, 7, 1, 9, 6, 5, 4, 7, 9, 0, 10, 18, 11, 12, 43, 1, 3, 2, 1, 4, 56, 7, 8, 3, 1, 33, 4, 1};
    public static void main(String[] args) throws InterruptedException {

        long start = System.nanoTime();
        //selectionSort(array);
        //insertionSort(array);
        //bubbleSort(array);
        qsort(0, array.length-1);
        long end = System.nanoTime();
        System.out.println(Arrays.toString(array) + " for " + (double) (end - start) / 100000 + " ms");
    }

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
       /* for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }*/
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    public static void qsort(int b, int e) {
        int l = b, r = e;
        int piv = array[(l + r) / 2]; // Опорным элементом для примера возьмём средний
        while (l <= r) {
            while (array[l] < piv) {
                l++;
            }
            while (array[r] > piv) {
                r--;
            }
            if (l <= r) {
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                //swap(array[l++], array[r--]);
                l++; r--;
            }
        }
        if (b < r)
            qsort(b, r);
        if (e > l)
            qsort(l, e);
    }

    //TODO how to get an index of a min element
    private static int findMin(int[] arr, int sortPosition) {
        return IntStream.range(sortPosition + 1, arr.length).boxed().min(Integer::min).get();
    }
}

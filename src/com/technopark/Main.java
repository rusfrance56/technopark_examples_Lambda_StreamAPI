package com.technopark;

public class Main {

    public static void main(String[] args) {
        //1 1 2 3 5 8 13 21 34

        //fibonnachi
        /*long timeout= System.currentTimeMillis();
        System.out.println(fibonnachi(40));
        timeout = System.currentTimeMillis() - timeout;

        long timeout2= System.currentTimeMillis();
        System.out.println(fibo2(40));
        timeout2 = System.currentTimeMillis() - timeout2;
        System.out.println("first: "+ timeout);
        System.out.println("second: "+ timeout2);*/

        //reverse list
        /*List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        Collections.reverse(list);
        System.out.println(list);

        System.out.println(Arrays.toString(reverse(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11})));*/

        //binary search
        int result = binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 1);
        System.out.println("index of element: " + result);
    }

    private static int binarySearch(int[] arr, int searchElement) {
        int first = 0;
        int last = arr.length;

        while (first < last) {
            int mid = (first + last) / 2;

            if (searchElement <= arr[mid]) {
                last = mid;
            } else {
                first = mid + 1;
            }
        }

        return (first == arr.length || arr[first] != searchElement) ? -1 : first;
    }

    public static int[] reverse(int input[]) {
        for (int i = 0; i < input.length / 2; i++) {
            int temp = input[i];
            input[i] = input[input.length - i - 1];
            input[input.length - i - 1] = temp;
        }
        return input;
    }

    public static int fibonnachi(int i) {
        if (i == 0 || i == 1) {
            return 1;
        }
        return fibonnachi(i - 1) + fibonnachi(i - 2);
    }

    public static int fibo2(int i) {
        if (i == 0) {
            return 1;
        }
        int pref = 1;
        int current = 1;

        for (int n = 2; n <= i; ++n) {
            int temp = current;
            current += pref;
            pref = temp;
        }
        return current;
    }
}

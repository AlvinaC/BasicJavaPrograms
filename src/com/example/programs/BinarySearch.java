package com.example.programs;

import java.util.Scanner;

public class BinarySearch {

    //Complexity = O(logn)
    public static int returnIfPresent(int[] arr, int key) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            System.out.println("Mid element index:" + m);
            if (arr[m] == key)
                return m;
            if (key > arr[m])
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n1 = s.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter elements of sorted ascending array:");
        for (int i = 0; i < n1; i++)
            arr1[i] = s.nextInt();
        System.out.println("Enter element to search:");
        int key = s.nextInt();
        int index = returnIfPresent(arr1, key);
        if (index == -1)
            System.out.println("Element is not found");
        else
            System.out.println("Element is found at index " + index);
    }

}

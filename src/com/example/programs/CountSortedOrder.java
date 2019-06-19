package com.example.programs;

//Problem Statement
//There are N trees planted, of different heights. We have to cut 1 tree, and have the others in sorted order(ascending heights)
//In how many ways can this be done

//solution:
//answer is always 0,1,2 or N

import java.util.Scanner;

public class CountSortedOrder {
    public static void main(String[] args) {
        CountSortedOrder cs = new CountSortedOrder();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n1 = s.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < 100000; i++)
            arr1[i] = i;
        int result = cs.findWays(arr1);
        System.out.print("result:" + result);
    }

    private int findWays(int[] arr1) {
        int count = 0;
        for (int i = 1; i < arr1.length; i++) {
            if (arr1[i - 1] > arr1[i]) {
                if (count != 0)
                    return 0;
                if (i == 1 || arr1[i - 2] <= arr1[i])
                    count++;
                if (i == arr1.length - 1 || arr1[i - 1] <= arr1[i + 1])
                    count++;
                if (count == 0)
                    return 0;
            }
        }
        if (count == 0)
            return arr1.length;
        return count;
    }

}

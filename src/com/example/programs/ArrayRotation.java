package com.example.programs;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ArrayRotation {

    public static void main(String[] args) {
        ArrayRotation ar = new ArrayRotation();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n1 = s.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter by how much to rotate:");
        int rotateBy = s.nextInt();
        System.out.println("Enter elements of array:");
        for (int i = 0; i < n1; i++)
            arr1[i] = s.nextInt();
        int[] result = ar.rotate(arr1, n1, rotateBy);
        System.out.println("Result:\n");
        for (int i = 0; i < n1; i++)
            System.out.print(arr1[i] + " ");
    }

    //juggling method
    //step 1: take gcd
    //step 2: iterate gcd no of times
    //step 3: take the value at i, increase i by gcd times, take that value...do this till the end of the array
    //step 4: these elements will be rotated once
    //step 5: repeat step 2,3,4
    //Complexity = O(n)
    private int[] rotate(int[] arr1, int n1, int rotateBy) {
        int gcd = gcd(rotateBy, n1);
        for (int i = 0; i < gcd; i++) {
            int temp = arr1[i];
            int j = i;
            while (true) {
                int k = j + rotateBy;
                if (k >= n1)
                    break;
                arr1[j] = arr1[k];
                j = k;
            }
            arr1[j] = temp;
        }
        return arr1;
    }

    private int gcd(int d, int n) {
        if (n == 0)
            return d;
        else
            return gcd(n, d % n);
    }
}

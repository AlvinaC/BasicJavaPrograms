package com.example.programs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Cops {

    int[] h;

    public static void main(String[] args) throws Exception {
        try {
            Scanner s = new Scanner(System.in);
            ArrayList<Integer> list = new ArrayList<>();
            Cops c = new Cops();
            int tc = s.nextInt();
            for (int i = 0; i < tc; i++) {
                int m = s.nextInt();
                int x = s.nextInt();
                int y = s.nextInt();
                int[] a = new int[m];
                for (int j = 0; j < m; j++) {
                    a[j] = s.nextInt();
                }
                int sum = c.checkNow(x * y, a);
                list.add(sum);
            }
            for (int i = 0; i < tc; i++) {
                System.out.println(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int checkNow(int max, int[] a) {
        int safe = 0;
        h = sort(a, 0, a.length - 1);
        for (int i = 1; i <= 100; i++) {
            int index = findNearestCop(h, i);
            int high = i + max >= 100 ? 100 : i + max;
            int low = i - max < 0 ? 1 : i - max;
            if (!(h[index] <= high && h[index] >= low))
                safe++;
        }
        return safe;
    }

    private int findNearestCop(int[] a, int thief) {
        return search(a, 0, a.length - 1, thief);
    }

    int search(int[] a, int l, int h, int key) {
        int indexL = -1, indexH = -1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (a[mid] == key)
                return mid;
            if (a[mid] > key)
                h = mid - 1;
            if (a[mid] < key)
                l = mid + 1;
        }
        if (l >= 0 && l <= a.length - 1)
            indexL = l;
        if (h >= 0 && h <= a.length - 1)
            indexH = h;
        if (indexH >= 0 && indexH <= a.length - 1 && indexL >= 0 && indexL <= a.length - 1) {
            if (Math.abs(a[indexH] - key) < Math.abs(a[indexL] - key))
                return indexH;
            else
                return indexL;
        } else if (indexL >= 0 && indexL <= a.length - 1)
            return indexL;
        else return indexH;
    }

    // quicksort
    int[] sort(int[] a, int low, int high) {
        obj o;
        if (low < high) {
            o = partition(a, low, high);
            sort(o.a, low, o.pivotI - 1);
            sort(o.a, o.pivotI + 1, high);
        }
        return a;
    }

    obj partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (a[j] < pivot) {
                i++;
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;
        return new obj(a, i + 1);
    }

    class obj {
        int[] a;
        int pivotI;

        public obj(int[] a, int pivotI) {
            super();
            this.a = a;
            this.pivotI = pivotI;
        }
    }

}

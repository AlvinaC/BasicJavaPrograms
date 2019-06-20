package com.example.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;




public class Cops {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
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
            c.checkNow(x * y, a);
        }
    }

    private int checkNow(int max, int[] a) {
        PriorityQueue<Myobj> p = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            int low = a[i] - max < 0 ? 1 : a[i] - max;
            int high = a[i] + max > 100 ? 100 : a[i] + max;
            if (low == 1 && high == 100)
                return 0;
            else {
                if (p.size() > 0) {
                    while (true) {
                        Myobj m = p.poll();
                        int pLow = m.a;
                        int pHigh = m.b;
                        boolean fIndex = between(low, pLow, pHigh);
                        boolean sIndex = between(high, pLow, pHigh);
                        if (fIndex && sIndex)
                            break;
                        else {
                            if (low < pLow && high > pHigh) {
                                p.remove(m);
                                Myobj mNew = new Myobj(low, high);
                                p.add(mNew);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static boolean between(int i, int minValueInclusive, int maxValueInclusive) {
        return (i >= minValueInclusive && i <= maxValueInclusive);
    }

    class Myobj {
        int a;
        int b;

        public Myobj(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}

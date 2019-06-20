package com.example.programs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class Cops {

    public static void main(String[] args) {
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
    }

    private int checkNow(int max, int[] a) {
        Queue<Myobj> p = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            int low = a[i] - max < 0 ? 1 : a[i] - max;
            int high = a[i] + max > 100 ? 100 : a[i] + max;
            if (low == 1 && high == 100)
                return 0;
            else {
                if (p.size() > 0) {
                    int count = p.size();
                    while (count > 0) {
                        Myobj m = ((LinkedList<Myobj>) p).peekFirst();
                        int pLow = m.a;
                        int pHigh = m.b;
                        boolean fIndex = between(low, pLow, pHigh);
                        boolean sIndex = between(high, pLow, pHigh);
                        if (fIndex && sIndex) {
                            count--;
                            continue;
                        } else {
                            if (low < pLow && high > pHigh) {
                                p.remove(m);
                                Myobj mNew = new Myobj(low, high);
                                p.add(mNew);
                            } else if (low > pLow && low < pHigh && high > pHigh) {
                                p.remove(m);
                                Myobj mNew = new Myobj(pLow, high);
                                p.add(mNew);
                            } else if (low < pLow && low < pHigh && high < pHigh) {
                                p.remove(m);
                                Myobj mNew = new Myobj(low, pHigh);
                                p.add(mNew);
                            } else {
                                Myobj mNew = new Myobj(low, high);
                                p.add(mNew);
                            }
                        }
                        count--;
                    }
                } else {
                    Myobj mNew = new Myobj(low, high);
                    p.add(mNew);
                }
            }
        }

        Comparator<Myobj> stringLengthComparator = new Comparator<Myobj>() {
            @Override
            public int compare(Myobj s1, Myobj s2) {
                return s1.a - s2.a;
            }
        };
        PriorityQueue<Myobj> pq = new PriorityQueue<>(stringLengthComparator);
        while (p.size() > 0) {
            pq.add(p.poll());
        }
        int sum = 0;
        Myobj prev;
        Myobj last = null;
        sum = sum + ((prev = pq.poll()).a - 1);
        while (pq.size() > 0) {
            Myobj l = pq.peek();
            sum = sum + (l.a - prev.b);
            last = pq.poll();
        }
        if (last != null)
            sum = sum + (100 - last.b);
        return sum;
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
